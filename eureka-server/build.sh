#!/bin/bash

mvn clean package -Dmaven.test.skip=true

docker rmi $(docker images -f "dangling=true" -q)

docker build -t eureka-server:latest .