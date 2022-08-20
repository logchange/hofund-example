FROM openjdk:17-alpine

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://payment-db:5432/payment

COPY target/payment.jar payment.jar
CMD java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 payment.jar
