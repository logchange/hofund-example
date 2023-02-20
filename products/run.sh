#!/bin/bash

mvn clean package -DskipTests

docker rm -f -v products-db
docker rm -f -v products-app

docker-compose pull
docker-compose up --build --remove-orphans

