# logstash


## 설치 

~~~
brew tap elastic/tap
~~~
~~~
brew install elastic/tap/logstash-full
~~~

- https://www.elastic.co/guide/en/logstash/current/installing-logstash.html

## 설정

- 경로 : /usr/local/Cellar/logstash-full/7.13.3/libexec/config... 


## 실행

- debug : logstash  -e 'input { stdin { } } output { stdout {} }'

- config : logstash -f /usr/local/Cellar/logstash-full/7.13.3/libexec/config/*.conf

