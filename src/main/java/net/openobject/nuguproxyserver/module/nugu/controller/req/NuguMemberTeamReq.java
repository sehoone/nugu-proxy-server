package net.openobject.nuguproxyserver.module.nugu.controller.req;

import lombok.Data;
import net.openobject.nuguproxyserver.common.dto.nugu.req.NuguCmnParameterReq;

@Data
public class NuguMemberTeamReq {
    
	private NuguCmnParameterReq memberName;

	private NuguCmnParameterReq memberRank;
	
}