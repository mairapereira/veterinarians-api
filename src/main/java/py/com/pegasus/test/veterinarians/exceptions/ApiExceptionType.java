package py.com.pegasus.test.veterinarians.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApiExceptionType {
    APPLICATION,
    DATABASE,
    VALIDATION,
    SECURITY
}