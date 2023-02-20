#!/bin/bash

mvn clean package -DskipTests

docker rm -f -v cart-db
docker rm -f -v cart-app

docker-compose pull
docker-compose up --build --remove-orphans

