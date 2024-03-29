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
import net.openobject.nuguproxyserver.common.dto.nugu.req.NuguCmnReq;
import net.openobject.nuguproxyserver.common.dto.nugu.res.NuguCmnAudioItemRes;
import net.openobject.nuguproxyserver.common.dto.nugu.res.NuguCmnDirectiveRes;
import net.openobject.nuguproxyserver.common.dto.nugu.res.NuguCmnProgressReportRes;
import net.openobject.nuguproxyserver.common.dto.nugu.res.NuguCmnRes;
import net.openobject.nuguproxyserver.common.dto.nugu.res.NuguCmnStreamRes;
import net.openobject.nuguproxyserver.module.nugu.controller.req.NuguFashionReq;
import net.openobject.nuguproxyserver.module.nugu.controller.req.NuguMemberTeamReq;
import net.openobject.nuguproxyserver.module.nugu.controller.res.NuguDepMemRes;
import net.openobject.nuguproxyserver.module.nugu.controller.res.NuguFashionRes;
import net.openobject.nuguproxyserver.module.nugu.controller.res.NuguMemberTeamRes;
import net.openobject.nuguproxyserver.module.nugu.service.NuguService;

/**
 * nugu 컨트롤러
 */
// @Slf4j
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
        String name = nuguFashionReq.getAction().getParameters().getName().getValue();

        // exception 처리 sample
        // if(name.equals("")){
        //      throw new NuguException(NuguExceptionEnum.BAD_REQUEST_EXCEPTION);
        // }

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

    /**
     * {@code POST /nugu/answer.member-team} : NUGU 직원 팀정보 API
     *
     * @param
     * @return
     */
    @PostMapping("/answer.member-team")
    public ResponseEntity<NuguCmnRes<NuguMemberTeamRes>> memberTeam(
            @RequestBody NuguCmnReq<NuguMemberTeamReq> nuguMemberTeamReq) {
        String memberName = nuguMemberTeamReq.getAction().getParameters().getMemberName().getValue().trim();
        // String memberRank = nuguMemberTeamReq.getAction().getParameters().getMemberRank().getValue();

        // exception 처리 sample
        // if(name.equals("")){
        //      throw new NuguException(NuguExceptionEnum.BAD_REQUEST_EXCEPTION);
        // }

        NuguMemberTeamRes nuguMemberTeamRes = NuguMemberTeamRes.builder()
                .memberTeam(nuguService.getMemberTeam(memberName)).build();

        NuguCmnAudioItemRes nuguCmnAudioItemRes = NuguCmnAudioItemRes.builder().metadata(new Object()).build();

        NuguCmnDirectiveRes nuguCmnDirectiveRes = NuguCmnDirectiveRes.builder().type("AudioPlayer.Play")
                .audioItem(nuguCmnAudioItemRes).build();

        List<NuguCmnDirectiveRes> NuguCmnDirectives = new ArrayList<NuguCmnDirectiveRes>();
        NuguCmnDirectives.add(nuguCmnDirectiveRes);

        NuguCmnRes<NuguMemberTeamRes> wapperNuguMemberTeamRes = NuguCmnRes.<NuguMemberTeamRes>builder().version("2.0")
                .resultCode("OK").output(nuguMemberTeamRes).directives(NuguCmnDirectives).build();
        return ResponseEntity.ok().body(wapperNuguMemberTeamRes);
    }

    /**
     * {@code POST /nugu/answer.member-team} : NUGU 오디오 플레이 API
     *
     * @param
     * @return
     */
    @PostMapping("/answer.audio-play")
    public ResponseEntity<NuguCmnRes<NuguDepMemRes>> audioPlayEntity() {

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
                .resultCode("OK").output(null).directives(NuguCmnDirectives).build();
        return ResponseEntity.ok().body(wapperNuguDepMemRes);
    }
}
