FROM openjdk:11
EXPOSE 8080
ADD target/product-rating-service.jar product-rating-service.jar
ENTRYPOINT ["java","-jar","/product-rating-service.jar"]