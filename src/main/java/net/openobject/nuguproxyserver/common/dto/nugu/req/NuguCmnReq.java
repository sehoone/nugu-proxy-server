package net.openobject.nuguproxyserver.common.dto.nugu.req;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
public class NuguCmnReq<T> {
    
	@Schema(description = "Backend proxy API 버전", example = "1.0", requiredMode=RequiredMode.REQUIRED)
	private String version;
	
	@Schema(description = "action 정보", requiredMode=RequiredMode.REQUIRED)
	private NuguCmnActionReq<T> action;

	@Schema(description = "디바이스에서 발생한 event 정보", requiredMode=RequiredMode.REQUIRED)
	private NuguCmnEventReq event;

}