package net.openobject.nuguproxyserver.common.dto.nugu.res;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NuguCmnStreamRes {
    
	@Schema(description = "오디오 콘텐츠의 URL", example = "", requiredMode=RequiredMode.REQUIRED)
	private String url;

	@Schema(description = "재생을 어느 offset(위치)에서 시작할지 설정. 값이 '0'이면 처음부터 재생", example = "", requiredMode=RequiredMode.REQUIRED)
	private Long offsetInMilliseconds;

	@Schema(description = "", example = "", requiredMode=RequiredMode.NOT_REQUIRED)
	private NuguCmnProgressReportRes progressReport;

	@Schema(description = "현재 stream을 나타내는 token", example = "", requiredMode=RequiredMode.REQUIRED)
	private String token;

	@Schema(description = "이전 stream을 나타내는 token", example = "", requiredMode=RequiredMode.REQUIRED)
	private String expectedPreviousToken;
}