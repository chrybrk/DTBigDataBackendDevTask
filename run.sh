#!/bin/bash
JAR_PATH="target/pickspot-0.0.1-SNAPSHOT.jar"
PORTS=(8080 8081 8082)

mvn package

if [[ $? -eq 0 ]]; then
	for port in "${PORTS[@]}"; do
		echo "Starting instance on port $port..."
		java -jar -Dserver.port=$port "$JAR_PATH" &
	done

	echo "All instances started. Use 'killall java' to stop."

	sudo nginx -c nginx.conf
fi
