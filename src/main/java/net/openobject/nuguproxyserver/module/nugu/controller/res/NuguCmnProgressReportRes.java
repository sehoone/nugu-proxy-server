package net.openobject.nuguproxyserver.module.nugu.controller.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NuguCmnProgressReportRes {
    
	private Long progressReportDelayInMilliseconds;
	private Long progressReportIntervalInMilliseconds;
}