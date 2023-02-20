#!/bin/bash

mvn clean package -DskipTests

docker rm -f -v stats-app

docker-compose pull
docker-compose up --build --remove-orphans

