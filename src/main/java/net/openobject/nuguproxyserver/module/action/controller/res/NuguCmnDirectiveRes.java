package net.openobject.nuguproxyserver.module.action.controller.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NuguCmnDirectiveRes {
    
	private String type;
	private NuguCmnAudioItemRes audioItem;

}