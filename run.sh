#!/bin/bash

cd products && mvn clean package -DskipTests && cd ..
cd cart && mvn clean package -DskipTests && cd ..
cd payment && mvn clean package -DskipTests && cd ..
cd stats && mvn clean package -DskipTests && cd ..


docker rm -f -v products-db
docker rm -f -v products-app

docker rm -f -v cart-db
docker rm -f -v cart-app

docker rm -f -v payment-db
docker rm -f -v payment-app

docker rm -f -v stats-app

docker-compose pull
docker-compose up --build --remove-orphans
