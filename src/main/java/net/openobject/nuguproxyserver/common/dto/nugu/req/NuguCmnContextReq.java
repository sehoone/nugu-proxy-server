package net.openobject.nuguproxyserver.common.dto.nugu.req;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
public class NuguCmnContextReq {
    
	@Schema(description = "session 정보", example = "", requiredMode=RequiredMode.REQUIRED)
	private NuguCmnSessionReq session;

	@Schema(description = "디바이스 정보", example = "", requiredMode=RequiredMode.REQUIRED)
	private NuguCmnDeviceReq device;

	@Schema(description = "개발한 Play가 특정 Capability Interface를 지원하는 경우 각 Interface별로 상태 정보를 표시", example = "", requiredMode=RequiredMode.REQUIRED)
	private Object supportedInterfaces;
}