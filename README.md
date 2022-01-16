## 공주대학교 소프트웨어전공 학술제 프로젝트 JARA -dreamfairy의 레포지토리입니다.

- 프로젝트 진행일자: 20.09 ~ 20.11
- 프로젝트 발표 자료: https://present.do/shows/61346fad5b179c0da746823b

---

#### 제작 계기

코로나에 의해 자가격리 또는 재택근무 등, 집에서의 생활이 대부분을 이루면서 스마트폰 이용시간 또한 크게 늘어났습니다.  
그에 따라 우리의 몸은 잠자기 직전까지 모니터와 스마트폰의 화면을 접하게 되었습니다.  
그리고 이 때문에 당연하게도 대부분의 사람들이 수면장애를 겪고 있습니다.  

저희는 이런 상황 속에서 **스마트폰 이용시간을 줄이고 수면에 집중할 수 있는 방법**을 모색하다가  
**수면과 게임을 접목시켜보자는 도전**을 하게되었고 JARA 프로젝트를 시작하게 되었습니다.  

#### 앱 소개

JARA는 수면에 도움이 되는 물건들을 모티브로 한 캐릭터를 수집하는 수집형 RPG 게임입니다.  
매일매일 수면을 방해하는 앰프, 모기, 층간소음들을 우리의 요정(캐릭터)을 통해 토벌해주세요.  

1. 원하는 캐릭터를 선택합니다. 초기에는 한 가지 캐릭터만 존재합니다.
2. 토벌하기를 희망하는 보스 몬스터를 고르고, 수면 타이머를 정해주세요. 보스마다 받을 수 있는 보상이 다르고, 시간에 따라 더 많은 보상을 획득할 수 있습니다.
3. 정해둔 시간만큼 푹 주무세요. 앱이 실행되는 동안에는 다른 앱을 사용하기 불편한 환경을 제공합니다. 잠시나마 스마트폰을 내려두고 숙면을 취해주세요.
4. 기상 알림에 맞춰 기상해주세요. 1분내로 확인 버튼을 누를 시 추가 보상이 지급됩니다.
5. 얻은 보상을 통해 우리 요정들을 모으고 꾸며주세요.

#### 주의사항

- 앱을 강제종료 할 경우에는 어떠한 보상도 주어지지 않습니다.


## 개발 정보

---

**이 프로젝트는 .apk 파일로 패키징하여 실행은 성공했으나 상점, 인벤토리, 아이템 등의 구현이 부족하여 배포는 되지 않았음을 밝힙니다.**

#### 개발 스택

**Android Version: Nougat 7.0 (APK Level 24)**  
**Android Studio (Java) 4.0.0 ver**  
**Google Firebase**  
**Git / Github**  
**Discord**  

클라이언트는 모두 Android Studio로 제작되었습니다.  
앱 서버와 관련된 내용은 전부 Firebase로 구축하고 Firebase API를 활용하여 접근했습니다.  
Firebase를 통해 사용한 기능은 다음과 같습니다.
- Remote Control을 통한 원격 제어
- RealtimeDB를 통한 유저 정보 저장
- Auth를 통한 유저 인증

- 전 연령이 가볍게 즐길 수 있는 앱을 목표로 했기 때문에 스마트폰 평균 수명이라고 알려진 2년보다 조금 더 시간을 두어 버전을 낮춰 설정했습니다. (Nougat Released at 16.08.22)
  또한 벤치마킹한 앱인 Forest와 Sleeptown 앱이 멀티윈도우 이용 차단을 구현했기 때문에 이를 클론해보려는 도전도 있었습니다. (멀티윈도우 기능은 Nougat에서 업데이트 되었습니다.)  
- 소스 버전 관리는 Git과 Github를 통해 하였습니다.  
- 협업은 Discord를 통해 원격으로 커뮤니케이션 하였습니다.  

#### 간단하게 보는 주요 기능들

- 회원가입, 로그인 기능
- 원격 유저 정보 저장을 통한 백업 및 치팅 방지 기능 (얻은 아이템, 얻은 재화, 얻은 캐릭터 등)
- 원격 제어 기능을 통한 앱 셧다운 / 앱 테마 변경
- 타이머 기능
- 알람 기능
