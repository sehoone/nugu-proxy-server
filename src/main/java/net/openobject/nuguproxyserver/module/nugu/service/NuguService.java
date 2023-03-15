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

    public String getMemberTeam(String memberName) {
        log.debug("Request to get getMemberTeam");
        String memberTeam = "잘모르겠어요";

        if(memberName.equals("문광식") | memberName.equals("조성재") | memberName.equals("이택성") | memberName.equals("김동현") ){
            memberTeam = "프론트개발2팀";
        } else if (memberName.equals("임영진") | memberName.equals("이정현") | memberName.equals("전승필") | memberName.equals("손호준") | memberName.equals("최윤찬")){
            memberTeam = "프론트개발4팀";
        } else if (memberName.equals("최세훈")){
            memberTeam = "웹서버개발3팀";
        } else if (memberName.equals("한수웅")){
            memberTeam = "DT그룹";
        }
        
        return memberTeam;
    }

}
