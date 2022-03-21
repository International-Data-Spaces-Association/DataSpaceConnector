package io.dataspaceconnector.service.resource.type;

import io.dataspaceconnector.model.base.AbstractFactory;
import io.dataspaceconnector.model.daps.Daps;
import io.dataspaceconnector.model.daps.DapsDesc;
import io.dataspaceconnector.repository.BaseEntityRepository;
import io.dataspaceconnector.service.resource.base.BaseEntityService;

/**
 * Service class for daps.
 */
public class DapsService extends BaseEntityService<Daps, DapsDesc> {

    /**
     * Constructor.
     *
     * @param repository The daps repository.
     * @param factory    The daps object logic.
     */
    public DapsService(final BaseEntityRepository<Daps> repository,
                         final AbstractFactory<Daps, DapsDesc> factory) {
        super(repository, factory);
    }

}
