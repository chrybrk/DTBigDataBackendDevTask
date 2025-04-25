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
Time taken for tests:   1.879 seconds
Complete requests:      1000
Failed requests:        0
Total transferred:      140000 bytes
Total body sent:        436000
HTML transferred:       35000 bytes
Requests per second:    532.32 [#/sec] (mean)
Time per request:       187.856 [ms] (mean)
Time per request:       1.879 [ms] (mean, across all concurrent requests)
Transfer rate:          72.78 [Kbytes/sec] received
                        226.65 kb/s sent
                        299.43 kb/s total

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   25  22.1     18      92
Processing:    18  158  79.5    152     496
Waiting:        9  139  68.6    132     368
Total:         26  183  67.5    175     510

Percentage of the requests served within a certain time (ms)
  50%    175
  66%    208
  75%    230
  80%    243
  90%    266
  95%    280
  98%    350
  99%    388
 100%    510 (longest request)

Summary:
  Total:	0.8762 secs
  Slowest:	0.1735 secs
  Fastest:	0.0084 secs
  Average:	0.0794 secs
  Requests/sec:	570.6618


Response time histogram:
  0.008 [1]	|
  0.025 [6]	|■■
  0.041 [26]	|■■■■■■■■■
  0.058 [81]	|■■■■■■■■■■■■■■■■■■■■■■■■■■■■
  0.074 [117]	|■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
  0.091 [115]	|■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
  0.107 [78]	|■■■■■■■■■■■■■■■■■■■■■■■■■■■
  0.124 [41]	|■■■■■■■■■■■■■■
  0.140 [21]	|■■■■■■■
  0.157 [9]	|■■■
  0.173 [5]	|■■


Latency distribution:
  10% in 0.0452 secs
  25% in 0.0594 secs
  50% in 0.0776 secs
  75% in 0.0976 secs
  90% in 0.1192 secs
  95% in 0.1299 secs
  99% in 0.1601 secs

Details (average, fastest, slowest):
  DNS+dialup:	0.0033 secs, 0.0084 secs, 0.1735 secs
  DNS-lookup:	0.0011 secs, 0.0000 secs, 0.0266 secs
  req write:	0.0013 secs, 0.0000 secs, 0.0449 secs
  resp wait:	0.0654 secs, 0.0083 secs, 0.1663 secs
  resp read:	0.0085 secs, 0.0000 secs, 0.0704 secs

Status code distribution:
  [200]	500 responses
```
