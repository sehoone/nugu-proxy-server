package net.openobject.nuguproxyserver.common.dto.nugu.req;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
public class NuguCmnActionReq<T> {
    
	@Schema(description = "요청하는 Action의 이름", example = "", requiredMode=RequiredMode.REQUIRED)
	private String actionName;
	
	@Schema(description = "Action에서 설정된 파라미터로 Play Builder에서 설정한 내용을 포함.(단, 값이 null인 경우 요청에서 제외됩니다. 요청에서 생략되었더라도 Backend parameter를 응답 값으로 포함해야 합니다.)", example = "", requiredMode=RequiredMode.REQUIRED)
	private T parameters;
}