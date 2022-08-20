#!/bin/bash

cd products && mvn clean install && cd ..
cd cart && mvn clean install && cd ..
cd payment && mvn clean install && cd ..

docker-compose rm -f -s -v products-db
docker-compose rm -f -s -v products-app
docker-compose rm -f -s -v cart-db
docker-compose rm -f -s -v cart-app
docker-compose pull
docker-compose up --build --remove-orphans --abort-on-container-exit
