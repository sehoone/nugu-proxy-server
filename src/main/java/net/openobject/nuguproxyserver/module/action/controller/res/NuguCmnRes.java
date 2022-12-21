package net.openobject.nuguproxyserver.module.action.controller.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NuguCmnRes<T> {
    
	private String version;
	private String resultCode;
	private T output;

}