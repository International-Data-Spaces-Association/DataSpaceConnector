package io.dataspaceconnector.model.daps;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

public class DapsDescTest {
    @Test
    void testEquals_valid() {
        EqualsVerifier.simple().forClass(DapsDesc.class);
    }
}
