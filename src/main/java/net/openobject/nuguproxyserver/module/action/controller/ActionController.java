package net.openobject.nuguproxyserver.module.action.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.openobject.nuguproxyserver.module.action.controller.res.NuguCmnAudioItemRes;
import net.openobject.nuguproxyserver.module.action.controller.res.NuguCmnDirectiveRes;
import net.openobject.nuguproxyserver.module.action.controller.res.NuguCmnProgressReportRes;
import net.openobject.nuguproxyserver.module.action.controller.res.NuguCmnRes;
import net.openobject.nuguproxyserver.module.action.controller.res.NuguCmnStreamRes;
import net.openobject.nuguproxyserver.module.action.controller.res.NuguDepMemRes;

/**
 * action_name 컨트롤러
 */
// @Slf4j
@RestController
@RequestMapping("/action-name")
public class ActionController {



//     /**
//      * {@code POST /action_name/answer.department.member-name} : NUGU BODY 확인용 API
//      *
//      * @param
//      * @return
//      */
//     @PostMapping("/answer.department.member-name")
//     public ResponseEntity<NuguCmnRes<NuguDepMemRes>> departmentMemberName(
//             @RequestBody NuguCmnReq<NuguDepMemReq> nuguDepMemReq) {
//         log.debug("departmentMemberName start " + nuguDepMemReq.toString());

//         NuguDepMemRes nuguDepMemRes = NuguDepMemRes.builder().resultCode(0).memberNames("홍길동 최세훈 조성재").build();
//         NuguCmnRes<NuguDepMemRes> wapperNuguDepMemRes = NuguCmnRes.<NuguDepMemRes>builder().version("2.0")
//                 .resultCode("OK").output(nuguDepMemRes).build();
//         return ResponseEntity.ok().body(wapperNuguDepMemRes);
//     }

//     /**
//      * {@code POST /action-name/answer.music} : NUGU BODY 확인용 API
//      *
//      * @param
//      * @return
//      */
//     @PostMapping("/answer.music")
//     public ResponseEntity<NuguCmnRes<NuguDepMemRes>> music(@RequestBody NuguCmnReq<NuguDepMemReq> nuguDepMemReq) {
//         log.debug("music start " + nuguDepMemReq.toString());

//         NuguDepMemRes nuguDepMemRes = NuguDepMemRes.builder().resultCode(0).memberNames("홍길동 최세훈 조성재").build();

//         NuguCmnProgressReportRes nuguCmnProgressReportRes = NuguCmnProgressReportRes.builder()
//                 .progressReportDelayInMilliseconds(0L)
//                 .progressReportIntervalInMilliseconds(0L).build();

//         NuguCmnStreamRes nuguCmnStreamRes = NuguCmnStreamRes.builder()
//                 .url("http://mediaserv30.live-streams.nl:8086/live").offsetInMilliseconds(0L)
//                 .progressReport(nuguCmnProgressReportRes).token("openobject.music.01").expectedPreviousToken("")
//                 .build();

//         NuguCmnAudioItemRes nuguCmnAudioItemRes = NuguCmnAudioItemRes.builder().stream(nuguCmnStreamRes).metadata(new Object()).build();

//         NuguCmnDirectiveRes nuguCmnDirectiveRes = NuguCmnDirectiveRes.builder().type("AudioPlayer.Play").audioItem(nuguCmnAudioItemRes).build();

//         List<NuguCmnDirectiveRes> NuguCmnDirectives = new ArrayList<NuguCmnDirectiveRes>();
//         NuguCmnDirectives.add(nuguCmnDirectiveRes);

//         NuguCmnRes<NuguDepMemRes> wapperNuguDepMemRes = NuguCmnRes.<NuguDepMemRes>builder().version("2.0")
//                 .resultCode("OK").output(nuguDepMemRes).directives(NuguCmnDirectives).build();
//         return ResponseEntity.ok().body(wapperNuguDepMemRes);
//     }

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
                .progressReport(nuguCmnProgressReportRes).token("openobject.music.01").expectedPreviousToken("")
                .build();

        NuguCmnAudioItemRes nuguCmnAudioItemRes = NuguCmnAudioItemRes.builder().stream(nuguCmnStreamRes).metadata(new Object()).build();

        NuguCmnDirectiveRes nuguCmnDirectiveRes = NuguCmnDirectiveRes.builder().type("AudioPlayer.Play").audioItem(nuguCmnAudioItemRes).build();

        List<NuguCmnDirectiveRes> NuguCmnDirectives = new ArrayList<NuguCmnDirectiveRes>();
        NuguCmnDirectives.add(nuguCmnDirectiveRes);

        NuguCmnRes<NuguDepMemRes> wapperNuguDepMemRes = NuguCmnRes.<NuguDepMemRes>builder().version("2.0")
                .resultCode("OK").output(nuguDepMemRes).directives(NuguCmnDirectives).build();
        return ResponseEntity.ok().body(wapperNuguDepMemRes);
    }

}
