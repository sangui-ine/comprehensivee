FROM openjdk:11
ADD target/employee.jar employee.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","employee.jar"]