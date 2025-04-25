## [TASK 2 - System Design](https://docs.google.com/spreadsheets/d/1Jx8_NOiCqblaf6qUwpK7njclWk_v2d7H_4pQseDrwao/edit?usp=sharing)

# Pick‑a‑Spot API
## Build & Run	
mvn spring-boot:run	
## Endpoint	
POST /pickSpot	
Body: { container, yardMap }  (see request.json)	
## Testing	
mvn test   # runs PickerServiceTest	
## Design notes	
- Stateless: every call keeps no server memory.	
- Score constant INVALID=10_000 ensures invalid slots never chosen.	
- For yard < 400 slots, O(n) scan is <50 ms; adequate for spec.	
# Benchmark
- Benchmark is done on `HP 240 G1 Notebook` with `4GB RAM`.
- Linux: 6.13.8-zen1-1-zen
- The results are achived after 10 or so iterations.
```txt
This is ApacheBench, Version 2.3 <$Revision: 1923142 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking 127.0.0.1 (be patient)
Completed 100 requests
Completed 200 requests
Completed 300 requests
Completed 400 requests
Completed 500 requests
Completed 600 requests
Completed 700 requests
Completed 800 requests
Completed 900 requests
Completed 1000 requests
Finished 1000 requests


Server Software:
Server Hostname:        127.0.0.1
Server Port:            8080

Document Path:          /pickSpot
Document Length:        35 bytes

Concurrency Level:      100
Time taken for tests:   1.080 seconds
Complete requests:      1000
Failed requests:        0
Total transferred:      140000 bytes
Total body sent:        436000
HTML transferred:       35000 bytes
Requests per second:    926.23 [#/sec] (mean)
Time per request:       107.964 [ms] (mean)
Time per request:       1.080 [ms] (mean, across all concurrent requests)
Transfer rate:          126.63 [Kbytes/sec] received
                        394.37 kb/s sent
                        521.01 kb/s total

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   15  13.7     12      61
Processing:     7   90  43.0     94     189
Waiting:        5   78  39.2     78     164
Total:         14  105  34.7    108     194

Percentage of the requests served within a certain time (ms)
  50%    108
  66%    124
  75%    133
  80%    139
  90%    150
  95%    157
  98%    165
  99%    175
 100%    194 (longest request)

Summary:
  Total:	0.4723 secs
  Slowest:	0.2087 secs
  Fastest:	0.0021 secs
  Average:	0.0400 secs
  Requests/sec:	1058.6865


Response time histogram:
  0.002 [1]	|
  0.023 [144]	|■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
  0.043 [186]	|■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
  0.064 [116]	|■■■■■■■■■■■■■■■■■■■■■■■■■
  0.085 [23]	|■■■■■
  0.105 [8]	|■■
  0.126 [3]	|■
  0.147 [4]	|■
  0.167 [10]	|■■
  0.188 [2]	|
  0.209 [3]	|■


Latency distribution:
  10% in 0.0105 secs
  25% in 0.0211 secs
  50% in 0.0343 secs
  75% in 0.0499 secs
  90% in 0.0666 secs
  95% in 0.1016 secs
  99% in 0.1754 secs

Details (average, fastest, slowest):
  DNS+dialup:	0.0012 secs, 0.0021 secs, 0.2087 secs
  DNS-lookup:	0.0005 secs, 0.0000 secs, 0.0078 secs
  req write:	0.0005 secs, 0.0000 secs, 0.0279 secs
  resp wait:	0.0351 secs, 0.0017 secs, 0.2082 secs
  resp read:	0.0026 secs, 0.0000 secs, 0.0395 secs

Status code distribution:
  [200]	500 responses
```
