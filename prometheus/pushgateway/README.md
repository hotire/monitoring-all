# Pushgateway

- https://github.com/prometheus/pushgateway


### Metric families have inconsistent help strings

Metric의 Description의 pushgateway 와 다를 경우 해당 에러가 발생함, 특이한 부분은... info 찍힘

~~~json
{
"err":"Metric families have inconsistent help strings. The latter will have priority. This is bad. Fix your pushed metrics!",
"level":"info",
"msg":"metric families inconsistent help strings"
}
~~~

- https://github.com/micrometer-metrics/micrometer/issues/2413
- https://github.com/prometheus/pushgateway/issues/299
