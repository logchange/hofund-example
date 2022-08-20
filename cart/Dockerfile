FROM openjdk:17-alpine

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://cart-db:5432/cart

COPY target/cart.jar cart.jar
CMD java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000 cart.jar
