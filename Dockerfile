FROM openjdk:8
ADD target/order-service.jar order-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","order-service.jar"]

