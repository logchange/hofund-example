#!/bin/bash

cd tools

docker-compose rm -f -s -v prometheus
docker-compose rm -f -s -v node-exporter
docker-compose rm -f -s -v alertmanager
docker-compose rm -f -s -v cadvisor
docker-compose rm -f -s -v grafana
docker volume rm -f tools_grafana_data
docker volume rm -f tools_prometheus_data


docker-compose pull
docker-compose up --build --abort-on-container-exit

