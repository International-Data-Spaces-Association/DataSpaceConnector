package io.dataspaceconnector.model.daps;

import io.dataspaceconnector.model.named.NamedDescription;
import io.dataspaceconnector.model.util.UriConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Convert;
import java.net.URI;

import static io.dataspaceconnector.model.config.DatabaseConstants.URI_COLUMN_LENGTH;

/**
 * Describing DAPS properties.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DapsDesc extends NamedDescription {

    /**
     * The url location of the DAPS.
     */
    @Convert(converter = UriConverter.class)
    @Column(length = URI_COLUMN_LENGTH)
    private URI location;

}
