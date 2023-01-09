package net.openobject.nuguproxyserver.common.dto.nugu.res;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NuguCmnProgressReportRes {
    
	@Schema(description = "재생을 시작해서 지정된 시간 뒤에 한 번 progressReportDelayElapsed 이벤트가 발생. (offsetInMilliseconds 값과는 상관없이 콘텐츠 시작 시간을 기준으로 한 절대값을 의미.)", example = "", requiredMode=RequiredMode.NOT_REQUIRED)
	private Long progressReportDelayInMilliseconds;

	@Schema(description = "재생을 시작해서 지정된 주기마다 progressReportIntervalElapsed 이벤트가 발생. (offsetInMilliseconds 값과는 상관없이 콘텐츠 시작 시간을 기준으로 한 절대값을 의미)", example = "", requiredMode=RequiredMode.NOT_REQUIRED)
	private Long progressReportIntervalInMilliseconds;
}