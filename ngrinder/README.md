# Ngrinder

오픈소스 부하 테스트 도구인 grinder를 기반으로 NHN에서 제작하였다. 

웹 기반으로 테스트를 진행할 수 있고, 복수의 장비를 이용하여 큰 부하를 발생할 수 있다. 

또한 스크립트를 작성하여 테스트 시나리오를 만들 수 있다. 

- https://github.com/naver/ngrinder

- Installation Guide :https://github.com/naver/ngrinder/wiki/Installation-Guide
- Quick-Start : https://github.com/naver/ngrinder/wiki/Quick-Start

### Load Test

부하 테스트 혹은 스트레스 테스트라고 한다. 

시스템에 부하를 발생시켜, 얼마만큼의 부하를 버틸수 있는지를 평가한다. 



### Controller

- 웹기반의 GUI 시스템

- 유저 관리
- 에이전트 관리
- 부하 테스트 실시 & 모니터링 
- 부하 시나리오 작성 테스트 내역을 저장하고 재활용할 수 있다. 



### Agent

- 부하를 발생시키는 대상 
- controller의 지휘를 받는다.
- 복수의 머신에 설치하여 controller의 신호에 따라서 일시에 부하를 발생시킨다.