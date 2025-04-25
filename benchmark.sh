#!/bin/sh

ab -n 1000 -c 100 -p request.json -T application/json http://127.0.0.1:8080/pickSpot
hey -n 500 -c 50 -m POST -H "Content-Type: application/json" -D request.json http://localhost:8080/pickSpot
