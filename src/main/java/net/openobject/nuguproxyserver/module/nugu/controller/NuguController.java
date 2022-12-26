package net.openobject.nuguproxyserver.module.nugu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.openobject.nuguproxyserver.module.action.controller.res.NuguDepMemRes;
import net.openobject.nuguproxyserver.module.nugu.controller.req.NuguCmnReq;
import net.openobject.nuguproxyserver.module.nugu.controller.req.NuguFashionReq;
import net.openobject.nuguproxyserver.module.nugu.controller.res.NuguCmnAudioItemRes;
import net.openobject.nuguproxyserver.module.nugu.controller.res.NuguCmnDirectiveRes;
import net.openobject.nuguproxyserver.module.nugu.controller.res.NuguCmnProgressReportRes;
import net.openobject.nuguproxyserver.module.nugu.controller.res.NuguCmnRes;
import net.openobject.nuguproxyserver.module.nugu.controller.res.NuguCmnStreamRes;
import net.openobject.nuguproxyserver.module.nugu.controller.res.NuguFashionRes;
import net.openobject.nuguproxyserver.module.nugu.service.NuguService;

/**
 * nugu 컨트롤러
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/nugu")
public class NuguController {

    private final NuguService nuguService;

    /**
     * {@code POST /nugu/answer.fashion} : NUGU fashion 확인용 API
     *
     * @param
     * @return
     */
    @PostMapping("/answer.fashion")
    public ResponseEntity<NuguCmnRes<NuguFashionRes>> fashion(
            @RequestBody NuguCmnReq<NuguFashionReq> nuguFashionReq) {
        log.debug("fashion start " + nuguFashionReq.toString());
        String name = nuguFashionReq.getAction().getParameters().getName().getValue();
        log.debug("fashion name " + name);

        NuguFashionRes nuguFashionRes = NuguFashionRes.builder()
                .fashionStatus(nuguService.getFashionStatus(name)).build();

        NuguCmnAudioItemRes nuguCmnAudioItemRes = NuguCmnAudioItemRes.builder().metadata(new Object()).build();

        NuguCmnDirectiveRes nuguCmnDirectiveRes = NuguCmnDirectiveRes.builder().type("AudioPlayer.Play")
                .audioItem(nuguCmnAudioItemRes).build();

        List<NuguCmnDirectiveRes> NuguCmnDirectives = new ArrayList<NuguCmnDirectiveRes>();
        NuguCmnDirectives.add(nuguCmnDirectiveRes);

        NuguCmnRes<NuguFashionRes> wapperNuguFashioRes = NuguCmnRes.<NuguFashionRes>builder().version("2.0")
                .resultCode("OK").output(nuguFashionRes).directives(NuguCmnDirectives).build();
        return ResponseEntity.ok().body(wapperNuguFashioRes);
    }

    /**
     * {@code POST /action-name/{action-path}} : NUGU BODY 확인용 API
     *
     * @param
     * @return
     */
    @PostMapping("/{action-path}")
    public ResponseEntity<NuguCmnRes<NuguDepMemRes>> actionPath(@PathVariable("action-path") String actionPath) {
        // log.debug("music start " + nuguDepMemReq.toString());

        NuguDepMemRes nuguDepMemRes = NuguDepMemRes.builder().resultCode(0).memberNames("홍길동 최세훈 조성재").build();

        NuguCmnProgressReportRes nuguCmnProgressReportRes = NuguCmnProgressReportRes.builder()
                .progressReportDelayInMilliseconds(0L)
                .progressReportIntervalInMilliseconds(0L).build();

        NuguCmnStreamRes nuguCmnStreamRes = NuguCmnStreamRes.builder()
                .url("http://mediaserv30.live-streams.nl:8086/live").offsetInMilliseconds(0L)
                .progressReport(nuguCmnProgressReportRes).token("openobject.music.01")
                .expectedPreviousToken("")
                .build();

        NuguCmnAudioItemRes nuguCmnAudioItemRes = NuguCmnAudioItemRes.builder().stream(nuguCmnStreamRes)
                .metadata(new Object()).build();

        NuguCmnDirectiveRes nuguCmnDirectiveRes = NuguCmnDirectiveRes.builder().type("AudioPlayer.Play")
                .audioItem(nuguCmnAudioItemRes).build();

        List<NuguCmnDirectiveRes> NuguCmnDirectives = new ArrayList<NuguCmnDirectiveRes>();
        NuguCmnDirectives.add(nuguCmnDirectiveRes);

        NuguCmnRes<NuguDepMemRes> wapperNuguDepMemRes = NuguCmnRes.<NuguDepMemRes>builder().version("2.0")
                .resultCode("OK").output(nuguDepMemRes).directives(NuguCmnDirectives).build();
        return ResponseEntity.ok().body(wapperNuguDepMemRes);
    }

}
