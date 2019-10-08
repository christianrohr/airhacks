#!/bin/sh
mvn clean package && docker build -t com.airhacks/odata-jpa .
docker rm -f odata-jpa || true && docker run -d -p 8080:8080 -p 4848:4848 --name odata-jpa com.airhacks/odata-jpa 
