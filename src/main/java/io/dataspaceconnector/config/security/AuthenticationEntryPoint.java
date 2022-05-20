package io.dataspaceconnector.config.security;

import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * Sets Settings for the BasicAuthenticationEntryPoint.
 */
@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    /**
     * Sets additional properties after default are set.
     */
    @Override
    public void afterPropertiesSet() {
        setRealmName("admin realm");
        super.afterPropertiesSet();
    }
}
