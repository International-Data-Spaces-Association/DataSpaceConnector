package io.dataspaceconnector.model.daps;

import org.junit.jupiter.api.Test;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

public class DapsFactoryTest {

    final DapsDesc desc = new DapsDesc();
    final DapsFactory factory = new DapsFactory();

    @Test
    void create_validDesc_returnNew() {
        /* ARRANGE */
        final var title = "MyDaps";
        desc.setTitle(title);

        /* ACT */
        final var result = factory.create(desc);

        /* ASSERT */
        assertEquals(title, result.getTitle());
    }

    @Test
    void update_newLocation_willUpdate() {
        /* ARRANGE */
        final var desc = new DapsDesc();
        desc.setLocation(URI.create("https://someLocation"));
        final var daps = factory.create(new DapsDesc());

        /* ACT */
        final var result = factory.update(daps, desc);

        /* ASSERT */
        assertTrue(result);
        assertEquals(desc.getLocation(), daps.getLocation());
    }

    @Test
    void update_sameLocation_willNotUpdate() {
        /* ARRANGE */
        final var desc = new DapsDesc();
        final var daps = factory.create(new DapsDesc());

        /* ACT */
        final var result = factory.update(daps, desc);

        /* ASSERT */
        assertFalse(result);
        assertEquals(DapsFactory.DEFAULT_URI, daps.getLocation());
    }
}
