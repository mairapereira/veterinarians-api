package py.com.pegasus.test.veterinarians.services;

import org.springframework.security.core.Authentication;

public interface SecurityAuthentication {
    Authentication getAuthentication();
}