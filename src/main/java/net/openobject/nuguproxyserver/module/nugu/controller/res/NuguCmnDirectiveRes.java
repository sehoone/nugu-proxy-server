package net.openobject.nuguproxyserver.module.nugu.controller.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NuguCmnDirectiveRes {
    
	private String type;
	private NuguCmnAudioItemRes audioItem;

}