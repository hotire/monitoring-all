# Prometheus

Prometheus는 SoundCloud사에서 만든 메트릭 기반의 오픈소스 모니터링 시스템이다.

대부분의 모니터링 도구가 Push 방식 즉, 각 서버에 클라이언트를 설치하고 이 클라이언트가 메트릭 데이터를 수집해서 서버로 보내면 서버가 모니터링 상태를 보여주는 방식을 취한다.
하지만 Prometheus는 Pull 방식을 사용하여, 서버에 클라이언트가 떠 있으면 서버가 주기적으로 클라이언트에 접속해서 데이터를 가져오는 방식을 취한다.


- https://github.com/prometheus
