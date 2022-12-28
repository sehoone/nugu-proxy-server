package net.openobject.nuguproxyserver.common.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum NuguExceptionEnum {
    BAD_REQUEST_EXCEPTION("E0001"),
    ACCESS_DENIED_EXCEPTION("E0002"),
    INTERNAL_SERVER_ERROR("E0003"),
    ARGUMENT_NOT_VALIDATION_EXCEPTION("E0004"),
    RESOURCE_IS_EXIST_EXCEPTION("E0001", "resource is already exist"),
    RESOURCE_NOT_FOUND_EXCEPTION("E0001", "resource not found");
    

    private final String code;
    private String message;

    NuguExceptionEnum( String code) {
        this.code = code;
    }

    NuguExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}