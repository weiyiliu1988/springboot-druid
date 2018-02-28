FROM openjdk:latest
COPY ./study_test.jar /
WORKDIR /
CMD ["java","-jar","/study_test.jar"]