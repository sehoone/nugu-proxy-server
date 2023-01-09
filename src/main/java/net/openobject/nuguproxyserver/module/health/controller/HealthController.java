package net.openobject.nuguproxyserver.module.health.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * health 컨트롤러
 */
@RestController
@RequestMapping("/health")
public class HealthController {

    /**
     * {@code GET /health} : health check
     * NUGU 심사 요청 시 /health url이 정상 동작해야 하며, /health url에서 200 이외의 상태가 오래 지속되면 서비스가 직권 중지될 수 있으므로 유의.
     * Spring actuator 를 사용해서 health check를 추가할 수도 있는데, openjdk환경에서는 actuator를 dependency에 추가하면 class not found 발생(org/springframework/boot/actuate/endpoint/jmx/DataEndpointMBean). 해당 클래스가 상용jdk에만 있음
     * @param
     * @return String
     */
    @GetMapping("")
    public ResponseEntity<String> health() {
        return ResponseEntity.status(HttpStatus.OK).body(new String("OK"));
    }

}
