package net.openobject.nuguproxyserver.module.action.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.openobject.nuguproxyserver.module.action.controller.req.NuguCmnReq;
import net.openobject.nuguproxyserver.module.action.controller.req.NuguDepMemReq;
import net.openobject.nuguproxyserver.module.action.controller.res.NuguCmnRes;
import net.openobject.nuguproxyserver.module.action.controller.res.NuguDepMemRes;

/**
 * action_name 컨트롤러
 */
@Slf4j
@RestController
@RequestMapping("/action_name")
public class ActionController {

    /**
     * {@code GET /action_name} : echo
     *
     * @param
     * @return
     */
    @RequestMapping(value = "", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = {
            RequestMethod.GET, RequestMethod.POST,
            RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS })
    public ResponseEntity<?> echoBack1(@RequestBody(required = false) byte[] rawBody) {
        log.debug("echoBack start " + new String(rawBody));

        return ResponseEntity.status(HttpStatus.OK).body(new String(rawBody));
    }

    /**
     * {@code GET /action_name/answer.department.member-name} : NUGU BODY 확인용 API
     *
     * @param
     * @return
     */

    @PostMapping("/answer.department.member-name")        
    public ResponseEntity<NuguCmnRes<NuguDepMemRes>> departmentMemberName(@RequestBody NuguCmnReq<NuguDepMemReq> userSignupReq) {
        log.debug("departmentMemberName start " + userSignupReq.toString());

        NuguDepMemRes nuguDepMemRes = NuguDepMemRes.builder().resultCode(0).memberNames("홍길동 최세훈 조성재").build();
        NuguCmnRes<NuguDepMemRes> wapperNuguDepMemRes = NuguCmnRes.<NuguDepMemRes>builder().version("2.0").resultCode("OK").output(nuguDepMemRes).build();
        return ResponseEntity.ok().body(wapperNuguDepMemRes); 
    }

}
