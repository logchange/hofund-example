#!/bin/bash

cd tools

docker-compose rm -f -s -v prometheus
docker-compose rm -f -s -v node-exporter
docker-compose rm -f -s -v alertmanager
docker-compose rm -f -s -v cadvisor
docker-compose rm -f -s -v grafana

docker-compose pull
docker-compose up --build --remove-orphans --abort-on-container-exit
