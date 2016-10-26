# With Jacoco

Server Software:        WildFly/10
Server Hostname:        127.0.0.1
Server Port:            8080

Document Path:          /codecoverage-wildfly/resources/message
Document Length:        12 bytes

Concurrency Level:      10
Time taken for tests:   2.386 seconds
Complete requests:      10000
Failed requests:        0
Total transferred:      1930000 bytes
HTML transferred:       120000 bytes
Requests per second:    4190.43 [#/sec] (mean)
Time per request:       2.386 [ms] (mean)
Time per request:       0.239 [ms] (mean, across all concurrent requests)
Transfer rate:          789.80 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    1   4.5      0     197
Processing:     0    2  11.2      1     331
Waiting:        0    2  11.0      1     319
Total:          1    2  12.0      2     331

Percentage of the requests served within a certain time (ms)
  50%      2
  66%      2
  75%      2
  80%      2
  90%      3
  95%      3
  98%      4
  99%      6
 100%    331 (longest request)


# Without Jacoco


Server Software:        WildFly/10
Server Hostname:        127.0.0.1
Server Port:            8080

Document Path:          /codecoverage-wildfly/resources/message
Document Length:        74 bytes

Concurrency Level:      10
Time taken for tests:   1.348 seconds
Complete requests:      10000
Failed requests:        0
Non-2xx responses:      10000
Total transferred:      2470000 bytes
HTML transferred:       740000 bytes
Requests per second:    7420.78 [#/sec] (mean)
Time per request:       1.348 [ms] (mean)
Time per request:       0.135 [ms] (mean, across all concurrent requests)
Transfer rate:          1789.97 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.3      0       6
Processing:     0    1   3.2      1     101
Waiting:        0    1   3.0      1      96
Total:          1    1   3.2      1     101

Percentage of the requests served within a certain time (ms)
  50%      1
  66%      1
  75%      1
  80%      1
  90%      2
  95%      2
  98%      3
  99%      5
 100%    101 (longest request)



