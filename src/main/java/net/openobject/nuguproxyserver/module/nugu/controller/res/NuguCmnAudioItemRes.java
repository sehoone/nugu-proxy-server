package net.openobject.nuguproxyserver.module.nugu.controller.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NuguCmnAudioItemRes {
    
	private NuguCmnStreamRes stream;
	private Object metadata;
}