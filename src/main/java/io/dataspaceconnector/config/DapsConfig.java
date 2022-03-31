/*
 * Copyright 2022 sovity GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.dataspaceconnector.config;

import de.fraunhofer.ids.messaging.core.daps.DapsVerifier;
import de.fraunhofer.ids.messaging.core.daps.customvalidation.ValidationRuleResult;
import io.dataspaceconnector.model.daps.Daps;
import io.dataspaceconnector.repository.DapsRepository;
import io.jsonwebtoken.Claims;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.util.List;

@Log4j2
@Configuration
public class DapsConfig {

    public final @NonNull DapsRepository repository;

    public DapsConfig(@NonNull DapsRepository repository) {
        checkWhitelist();
        this.repository = repository;
    }

    public void checkWhitelist() {
        DapsVerifier.addValidationRule(claim -> {
                    if (isWhitelisted(claim)) {
                        return ValidationRuleResult.success();
                    }
                    return ValidationRuleResult.failure("Issuer DAPS not whitelisted");
                }
        );
    }

    private boolean isWhitelisted(Claims claim) {
        List<String> whitelistedDaps = repository.findAll().stream().map(Daps::getLocation).map(URI::toString).toList();
        return whitelistedDaps.size() == 0 || whitelistedDaps.contains(claim.getIssuer());
    }
}
