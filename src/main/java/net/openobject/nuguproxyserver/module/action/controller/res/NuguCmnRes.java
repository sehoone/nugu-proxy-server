package net.openobject.nuguproxyserver.module.action.controller.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
// @AllArgsConstructor
public class NuguCmnRes<T> {
    
	// public NuguCmnRes(){};

	private String version;
	private String resultCode;
	private T output;
	// private Object directives;

}