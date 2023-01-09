package net.openobject.nuguproxyserver.common.dto.nugu.req;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
public class NuguCmnEventReq {
    
	@Schema(description = "디바이스에서 발생한 event의 종류를 나타내며, 이 값에 따라 event의 데이터가 달라집니다. (Capability Interfaces 참조)", example = "", requiredMode=RequiredMode.REQUIRED)
	private String type;
	
}