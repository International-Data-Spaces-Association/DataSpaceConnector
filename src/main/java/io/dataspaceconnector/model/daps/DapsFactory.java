package io.dataspaceconnector.model.daps;

import io.dataspaceconnector.model.named.AbstractNamedFactory;
import io.dataspaceconnector.model.util.FactoryUtils;

import java.net.URI;

/**
 * Creates and updates a DAPS.
 */
public class DapsFactory extends AbstractNamedFactory<Daps, DapsDesc> {
    /**
     * Default location.
     */
    public static final URI DEFAULT_URI = URI.create("https://daps.com");

    /**
     * @param desc The description of the entity.
     * @return The new broker entity.
     */
    @Override
    protected Daps initializeEntity(final DapsDesc desc) {
        return new Daps();
    }

    /**
     * @param daps The entity to be updated.
     * @param desc The description of the new entity.
     * @return True, if daps is updated.
     */
    @Override
    protected boolean updateInternal(final Daps daps, final DapsDesc desc) {
        return updateLocation(daps, desc.getLocation());
    }

    /**
     * @param daps     The entity to be updated.
     * @param location The new location url of the entity.
     * @return True, if daps is updated.
     */
    private boolean updateLocation(final Daps daps, final URI location) {
        final var newLocation = FactoryUtils.updateUri(daps.getLocation(), location,
                DEFAULT_URI);
        return newLocation.isPresent();
    }
}
