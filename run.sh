#!/bin/bash

cd products && mvn clean package -DskipTests && cd ..
cd cart && mvn clean package -DskipTests && cd ..
cd payment && mvn clean package -DskipTests && cd ..

docker-compose rm -f -s -v products-db
docker-compose rm -f -s -v products-app
docker-compose rm -f -s -v cart-db
docker-compose rm -f -s -v cart-app
docker-compose rm -f -s -v payment-db
docker-compose rm -f -s -v payment-app
docker-compose pull
docker-compose up --build --remove-orphans --abort-on-container-exit
