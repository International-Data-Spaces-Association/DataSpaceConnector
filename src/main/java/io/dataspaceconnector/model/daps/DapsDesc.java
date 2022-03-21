package io.dataspaceconnector.model.daps;

import io.dataspaceconnector.model.named.NamedDescription;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.net.URI;

/**
 * Describing DAPS properties.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DapsDesc extends NamedDescription {

    /**
     * The url location of the DAPS.
     */
    private URI location;

}
