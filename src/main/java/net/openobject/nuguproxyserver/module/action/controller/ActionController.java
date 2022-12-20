package net.openobject.nuguproxyserver.module.action.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * sample 컨트롤러
 */
@Slf4j
@RestController
public class ActionController {

    /**
     * {@code GET /api/sample/hello-world} : get hello-world text
     *
     * @param 
     * @return 
     */
	@RequestMapping(value = "/action_name", consumes = MediaType.ALL_VALUE, produces = 
		MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.GET, RequestMethod.POST,
		RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
	public ResponseEntity<?> echoBack(@RequestBody(required = false) byte[] rawBody) {
        log.debug("echoBack start "+new String(rawBody));

		return ResponseEntity.status(HttpStatus.OK).body(new String(rawBody));
	}

}
