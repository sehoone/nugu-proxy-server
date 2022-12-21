package net.openobject.nuguproxyserver.module.action.controller.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NuguDepMemRes {
    
	private int resultCode;
	private String memberNames;
	
}