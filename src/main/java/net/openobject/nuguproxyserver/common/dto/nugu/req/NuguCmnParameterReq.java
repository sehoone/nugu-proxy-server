package net.openobject.nuguproxyserver.common.dto.nugu.req;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
public class NuguCmnParameterReq {
    
	@Schema(description = "사용자 발화에서 분석된 Entity인 경우 Play Builder에서 설정한 Entity의 타입", example = "", requiredMode=RequiredMode.REQUIRED)
	private String type;
	
	@Schema(description = "파라미터의 값으로 string 타입", example = "", requiredMode=RequiredMode.REQUIRED)
	private String value;

}