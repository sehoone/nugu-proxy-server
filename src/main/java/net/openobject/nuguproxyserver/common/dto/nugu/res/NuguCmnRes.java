package net.openobject.nuguproxyserver.common.dto.nugu.res;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NuguCmnRes<T> {

	@Schema(description = "Backend proxy API 버전", example = "", requiredMode=RequiredMode.REQUIRED)
	private String version;

	@Schema(description = "응답코드. OK : 성공인 경우 사용하는 값으로 다른 값을 전송하면 성공이 아닌 것으로 처리하기 때문에 주의. 성공이 아닌 경우는 PlayBuider의 General > 기본정보 페이지의 예외 처리 또는 Action > Custom Actions > 선택한 Action의 예외 처리에서 설정된 Result Code(Exception Code)값 전송", example = "", requiredMode=RequiredMode.REQUIRED)
	private String resultCode;

	@Schema(description = "Request에서 전송한 action.parameters의 KEY:VALUE를 처리한 결과를 전송", example = "", requiredMode=RequiredMode.REQUIRED)
	private T output;
	
	@Schema(description = "특정 Capability Interface를 지원하는 Play에서 Directive를 전송하는 경우에 이 필드를 통해 전송", example = "", requiredMode=RequiredMode.NOT_REQUIRED)
	private List<NuguCmnDirectiveRes> directives;
}