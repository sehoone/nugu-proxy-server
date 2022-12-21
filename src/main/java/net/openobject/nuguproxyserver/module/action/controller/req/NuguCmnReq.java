package net.openobject.nuguproxyserver.module.action.controller.req;

import lombok.Data;

@Data
public class NuguCmnReq<T> {
    
	private String version;
	private NuguCmnActionReq<T> action;

}