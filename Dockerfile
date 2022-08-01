FROM openjdk:11
ADD target/Employee.jar Employee.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","Employee.jar"]
