package net.openobject.nuguproxyserver.common.dto;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class NuguExceptionDTO {
	private String version;
	private String resultCode;
    private Object output;

    @Builder
    public NuguExceptionDTO(HttpStatus status, String version, String resultCode){
        this.version = version;
        this.resultCode = resultCode;
    }
}