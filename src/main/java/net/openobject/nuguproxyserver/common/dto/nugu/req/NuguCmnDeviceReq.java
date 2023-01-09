package net.openobject.nuguproxyserver.common.dto.nugu.req;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
public class NuguCmnDeviceReq {
    
	@Schema(description = "현재 사용 중인 디바이스 종류", example = "", requiredMode=RequiredMode.REQUIRED)
	private String type;

	@Schema(description = "디바이스의 상태를 나타내는 값으로 현재는 정의된 것이 없음", example = "", requiredMode=RequiredMode.NOT_REQUIRED)
	private Object state;

}