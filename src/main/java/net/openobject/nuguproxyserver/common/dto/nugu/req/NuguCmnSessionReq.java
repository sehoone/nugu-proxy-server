package net.openobject.nuguproxyserver.common.dto.nugu.req;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
public class NuguCmnSessionReq {
    
	@Schema(description = "대화가 유지되는 동안의 유효한 키 값", example = "", requiredMode=RequiredMode.REQUIRED)
	private String id;

	@Schema(description = "대화의 처음을 알려주는 값", example = "", requiredMode=RequiredMode.REQUIRED)
	private boolean isNew;

	@Schema(description = "OAuth 2에 사용되는 인증 token", example = "", requiredMode=RequiredMode.NOT_REQUIRED)
	private String accessToken;

	@Schema(description = "Play Builder에서 테스트용으로 전달한 요청임을 의미. (기본값: false)", example = "", requiredMode=RequiredMode.NOT_REQUIRED)
	private boolean isPlayBuilderRequest;
	
}