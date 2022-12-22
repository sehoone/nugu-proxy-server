
<h1>SKT NUGU Backend Proxy Server</h1>

## Introduction
- SKT NUGU 플랫폼 적용을 위한 Backend Proxy Server
- NUGU Developer Document: https://developers.nugu.co.kr
- NUGU Developer Backend Proxy Server Document: https://developers-doc.nugu.co.kr/nugu-play/create-plays-with-play-builder/use-backend-proxy

## Access information
- http://domain:8443

## Project spec
- java 17
- Spring boot 2.7.6
- Gradle

## Requirements
- java JDK 17+
- Gradle 
- Git

## Develop tool
- Visual Studio Code 1.73.1
- plugins: Extension Pack for Java
- plugins: Spring Boot Extension Pack
- plugins: Gradle for Java
- plugins: Git History

## Install(for linux)
- Get the project code
```sh
git clone https://github.com/sehoone/nugu-proxy-server.git
```
- Installation dependencies
```sh
cd nugu-proxy-server
./gradlew bootjar
```
- run boot jar
```sh
nohup java -Dspring.profiles.active=dev -Dserver.port=8443 -jar build/libs/nugu-proxy-server-0.0.1-SNAPSHOT.jar &
```

## Source Structure
```
├── nft-exhibit-server        # root
  ├── gradle                  # gradle config
  ├── src                     # source Directory
    ├── main
      ├── net/openobject/nuguproxyserver
        ├── common            # common package
        ├── config            # common config
        ├── module            # 업무별 module
          ├── 업무            # 업무별 패키지 생성
            ├── controller    # controller. Presentation Layer
            ├── service       # service. Business Layer
            ├── repository    # repository. Persistence Layer
            ├── domain        # domain. database table domain
      ├── resource            # resource. application propertie 정의
    ├── test                  # test source root
  ├── .gitignore              # gitignore
  ├── build.gradle            # gradle build config. plugins, dependency, etc
  ├── gradlew                 # gradlew
  ├── gradlew.bat             # gradlew.bat
  ├── README.md               # README.md
  ├── settings.gradle         # settings.gradle
```