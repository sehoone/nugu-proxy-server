package net.openobject.nuguproxyserver.module.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * sample 컨트롤러
 */
@RestController
@RequestMapping("/api/sample")
public class SampleController {

    /**
     * {@code GET /api/sample/hello-world} : get hello-world text
     *
     * @param 
     * @return 
     */
    @GetMapping("/hello-world")
    public String helloWorld() {
        String word = "hello-world!!";
        return word;
    }

}
