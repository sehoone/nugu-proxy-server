package net.openobject.nuguproxyserver.common.dto.nugu.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NuguCmnDirectiveRes {
    
	private String type;
	private NuguCmnAudioItemRes audioItem;

}