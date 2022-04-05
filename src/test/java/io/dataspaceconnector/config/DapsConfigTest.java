package io.dataspaceconnector.config;

import io.dataspaceconnector.model.daps.Daps;
import io.dataspaceconnector.model.daps.DapsDesc;
import io.dataspaceconnector.model.daps.DapsFactory;
import io.dataspaceconnector.repository.DapsRepository;
import io.dataspaceconnector.service.resource.type.DapsService;
import io.jsonwebtoken.impl.DefaultClaims;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {DapsService.class})
class DapsConfigTest {

    @Autowired
    private DapsService dapsService;

    @MockBean
    private DapsRepository dapsRepository;

    @MockBean
    private DapsFactory dapsFactory;

    @Test
    void whitelist_empty_issuer_whitelisted() throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> claimParams = new HashMap<>();
        final var claims = new DefaultClaims(claimParams).setIssuer("http://example.org");

        final var dapsConfig = new DapsConfig(dapsRepository);
        final var methods = dapsConfig.getClass().getDeclaredMethods();
        final var isWhitelisted = Arrays.stream(methods).filter(it -> it.getName().equals("isWhitelisted")).findFirst();

        assertTrue(isWhitelisted.isPresent());

        final var isWhitelistedMethod = isWhitelisted.get();
        isWhitelistedMethod.setAccessible(true);
        final var whitelisted = (Boolean) isWhitelistedMethod.invoke(dapsConfig, claims);

        assertTrue(whitelisted);
    }

    @Test
    void whitelist_notempty_issuer_notwhitelisted() throws InvocationTargetException, IllegalAccessException, URISyntaxException, NoSuchFieldException {
        final var dapsDesc = new DapsDesc();
        dapsDesc.setLocation(new URI("http://example.org"));
        dapsDesc.setTitle("test");
        dapsDesc.setDescription("test");
        final var dapsFactory = new DapsFactory();
        final var daps = dapsFactory.create(dapsDesc);

        Mockito.doReturn(List.of(daps)).when(dapsRepository).findAll();

        final var dapsConfig = new DapsConfig(dapsRepository);
        final var methods = dapsConfig.getClass().getDeclaredMethods();

        final var ownDapsUrlField = dapsConfig.getClass().getDeclaredField("ownDapsUrl");
        ownDapsUrlField.setAccessible(true);
        ownDapsUrlField.set(dapsConfig, "http://my-daps");

        final var isWhitelisted = Arrays.stream(methods).filter(it -> it.getName().equals("isWhitelisted")).findFirst();

        assertTrue(isWhitelisted.isPresent());

        final var isWhitelistedMethod = isWhitelisted.get();
        isWhitelistedMethod.setAccessible(true);

        Map<String, Object> claimParams = new HashMap<>();
        final var claims = new DefaultClaims(claimParams).setIssuer("http://example-false.org");
        final var whitelisted = (Boolean) isWhitelistedMethod.invoke(dapsConfig, claims);

        assertFalse(whitelisted);
    }

    @Test
    void whitelist_notempty_issuer_whitelisted() throws InvocationTargetException, IllegalAccessException, URISyntaxException, NoSuchFieldException {
        final var dapsDesc = new DapsDesc();
        dapsDesc.setLocation(new URI("http://example.org"));
        dapsDesc.setTitle("test");
        dapsDesc.setDescription("test");
        final var dapsFactory = new DapsFactory();
        final var daps = dapsFactory.create(dapsDesc);

        Mockito.doReturn(List.of(daps)).when(dapsRepository).findAll();

        final var dapsConfig = new DapsConfig(dapsRepository);
        final var methods = dapsConfig.getClass().getDeclaredMethods();

        final var ownDapsUrlField = dapsConfig.getClass().getDeclaredField("ownDapsUrl");
        ownDapsUrlField.setAccessible(true);
        ownDapsUrlField.set(dapsConfig, "http://my-daps");

        final var isWhitelisted = Arrays.stream(methods).filter(it -> it.getName().equals("isWhitelisted")).findFirst();

        assertTrue(isWhitelisted.isPresent());

        final var isWhitelistedMethod = isWhitelisted.get();
        isWhitelistedMethod.setAccessible(true);

        Map<String, Object> claimParams = new HashMap<>();
        final var claims = new DefaultClaims(claimParams).setIssuer("http://example.org");
        final var whitelisted = (Boolean) isWhitelistedMethod.invoke(dapsConfig, claims);

        assertTrue(whitelisted);
    }

    @Test
    void whitelist_notempty_issuer_owndaps() throws InvocationTargetException, IllegalAccessException, URISyntaxException, NoSuchFieldException {
        final var dapsDesc = new DapsDesc();
        dapsDesc.setLocation(new URI("http://example.org"));
        dapsDesc.setTitle("test");
        dapsDesc.setDescription("test");
        final var dapsFactory = new DapsFactory();
        final var daps = dapsFactory.create(dapsDesc);

        Mockito.doReturn(List.of(daps)).when(dapsRepository).findAll();

        final var dapsConfig = new DapsConfig(dapsRepository);
        final var methods = dapsConfig.getClass().getDeclaredMethods();

        final var ownDapsUrlField = dapsConfig.getClass().getDeclaredField("ownDapsUrl");
        ownDapsUrlField.setAccessible(true);
        ownDapsUrlField.set(dapsConfig, "http://my-daps");

        final var isWhitelisted = Arrays.stream(methods).filter(it -> it.getName().equals("isWhitelisted")).findFirst();

        assertTrue(isWhitelisted.isPresent());

        final var isWhitelistedMethod = isWhitelisted.get();
        isWhitelistedMethod.setAccessible(true);

        Map<String, Object> claimParams = new HashMap<>();
        final var claims = new DefaultClaims(claimParams).setIssuer("http://my-daps");
        final var whitelisted = (Boolean) isWhitelistedMethod.invoke(dapsConfig, claims);

        assertTrue(whitelisted);
    }
}
