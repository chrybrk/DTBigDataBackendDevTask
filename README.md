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
Document Length:        28 bytes

Concurrency Level:      100
Time taken for tests:   0.482 seconds
Complete requests:      1000
Failed requests:        0
Non-2xx responses:      1000
Total transferred:      133000 bytes
Total body sent:        436000
HTML transferred:       28000 bytes
Requests per second:    2076.26 [#/sec] (mean)
Time per request:       48.163 [ms] (mean)
Time per request:       0.482 [ms] (mean, across all concurrent requests)
Transfer rate:          269.67 [Kbytes/sec] received
                        884.03 kb/s sent
                        1153.70 kb/s total

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    8   5.5      8      24
Processing:     3   37  17.8     38      85
Waiting:        2   30  15.5     26      80
Total:          8   46  15.2     46      95

Percentage of the requests served within a certain time (ms)
  50%     46
  66%     53
  75%     56
  80%     59
  90%     65
  95%     70
  98%     75
  99%     78
 100%     95 (longest request)
```
