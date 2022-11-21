FROM openjdk:17-alpine

ENV CLIENT_PRODUCTS_URL=http://host.docker.internal:18081/

COPY target/stats.jar stats.jar
CMD java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000 stats.jar
