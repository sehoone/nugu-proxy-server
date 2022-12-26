package net.openobject.nuguproxyserver.module.nugu.controller.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NuguCmnStreamRes {
    
	private String url;
	private Long offsetInMilliseconds;
	private NuguCmnProgressReportRes progressReport;
	private String token;
	private String expectedPreviousToken;
}