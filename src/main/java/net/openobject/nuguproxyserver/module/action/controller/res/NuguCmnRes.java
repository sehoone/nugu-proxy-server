package net.openobject.nuguproxyserver.module.action.controller.res;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NuguCmnRes<T> {
    
	private String version;
	private String resultCode;
	private T output;
	private List<NuguCmnDirectiveRes> directives;
}