/*
 * Copyright 2022 Sovity Gmbh
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
package io.dataspaceconnector.service.resource.type;

import io.dataspaceconnector.config.DapsConfig;
import io.dataspaceconnector.model.base.AbstractFactory;
import io.dataspaceconnector.model.daps.Daps;
import io.dataspaceconnector.model.daps.DapsDesc;
import io.dataspaceconnector.repository.BaseEntityRepository;
import io.dataspaceconnector.service.resource.base.BaseEntityService;
import lombok.NonNull;

/**
 * Service class for daps.
 */
public class DapsService<T extends Daps, D extends DapsDesc>
        extends BaseEntityService<T, D> {

    /**
     * DapsConfig instance used to add DAPS to whitelist
     */
    private final @NonNull DapsConfig dapsConfig;

    /**
     * Constructor for DapsService class, autowires the DapsConfig field.
     *  @param repository The daps repository.
     * @param factory    The daps object logic.
     * @param dapsConfig daps configuration
     */
    public DapsService(
            @NonNull BaseEntityRepository<T> repository,
            @NonNull AbstractFactory<T, D> factory,
            @NonNull DapsConfig dapsConfig) {
        super(repository, factory);
        this.dapsConfig = dapsConfig;
    }

    /**
     * Persists a daps and adds it to the whitelist.
     *
     * @param daps the daps to persist.
     * @return the persisted daps.
     */
    @Override
    protected final T persist(final T daps) {
        if (daps.getLocation() != null) {
            dapsConfig.addDapsToWhitelist(daps.getLocation());
        }

        return super.persist(daps);
    }

}
