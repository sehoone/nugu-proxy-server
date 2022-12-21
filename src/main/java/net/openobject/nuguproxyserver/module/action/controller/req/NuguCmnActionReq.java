package net.openobject.nuguproxyserver.module.action.controller.req;

import lombok.Data;

@Data
public class NuguCmnActionReq<T> {
    
	private String actionName;
	private T parameters;
}