FROM amazoncorretto:11
ADD target/self-metrics.jar self-metrics.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/self-metrics.jar"]