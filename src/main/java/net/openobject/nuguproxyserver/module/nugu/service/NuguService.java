package net.openobject.nuguproxyserver.module.nugu.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * nugu 서비스
 */
@Slf4j
@Service
public class NuguService {

    public String getFashionStatus(String name) {
        log.debug("Request to get getFashionStatus");
        String fashionStatus = "잘모르겠어요";

        if(name.contains("세훈")){
            fashionStatus = "나쁘진 않다";
        } else if(name.contains("수웅")){
            fashionStatus = "옷걸이가 좋아서 멋있습니다";
        } else if(name.contains("동현")){
            fashionStatus = "깔끔하게 멋있습니다";
        } else if(name.contains("광식")){
            fashionStatus = "옷걸이가 좋아서 멋있습니다";
        } else if(name.contains("성재")){
            fashionStatus = "셀럽 이라 그런지 뭔가 다르네요";
        }
        
        return fashionStatus;
    }

}
