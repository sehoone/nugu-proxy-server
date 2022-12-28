package net.openobject.nuguproxyserver.common.exception;

import lombok.Getter;
import net.openobject.nuguproxyserver.common.enums.NuguExceptionEnum;

@Getter
public class NuguException extends RuntimeException {
    private NuguExceptionEnum error;

    public NuguException(NuguExceptionEnum e) {
        super(e.getMessage());
        this.error = e;
    }

    public NuguException(NuguExceptionEnum e, String message) {
        super(message);
        this.error = e;
    }

}