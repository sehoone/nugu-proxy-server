package net.openobject.nuguproxyserver.common.dto.nugu.res;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NuguCmnAudioItemRes {
    
	@Schema(description = "stream 정보", example = "", requiredMode=RequiredMode.NOT_REQUIRED)
	private NuguCmnStreamRes stream;

	@Schema(description = "reserved", example = "", requiredMode=RequiredMode.NOT_REQUIRED)
	private Object metadata;
}