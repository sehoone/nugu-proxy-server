package net.openobject.nuguproxyserver.module.action.controller.res;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Builder
public class NuguCmnAudioItemRes {
    
	private NuguCmnStreamRes stream;
	private Object metadata;
}