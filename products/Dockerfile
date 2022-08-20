FROM openjdk:17-alpine

ENV SPRING_DATASOURCE_URL=jdbc:oracle:thin:@//products-db:1521/products

COPY target/products.jar products.jar
# sleep to wait untill oracledb started
CMD sleep 300s && java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 products.jar
