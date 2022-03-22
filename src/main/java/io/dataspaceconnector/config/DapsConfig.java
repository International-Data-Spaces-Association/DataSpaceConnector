package io.dataspaceconnector.config;

import de.fraunhofer.ids.messaging.core.daps.DapsVerifier;
import de.fraunhofer.ids.messaging.core.daps.customvalidation.ValidationRuleResult;
import io.dataspaceconnector.repository.DapsRepository;
import lombok.NonNull;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

@Configuration
public class DapsConfig {

    public final @NonNull DapsRepository repository;

    public DapsConfig(@NonNull DapsRepository repository) {
        this.repository = repository;
    }

    public void addDapsToWhitelist(URI location) {
        System.out.println("Adding DAPS: " + location + " to whitelist.");
        DapsVerifier.addValidationRule(claim -> {
                    if (location.toString().equals(claim.getIssuer())) {
                        return ValidationRuleResult.success();
                    }
                    return ValidationRuleResult.failure("Issuer DAPS not whitelisted");
                }
        );
    }
}
