FROM openjdk:latest
COPY ./spring-test-0.0.1-SNAPSHOT.jar /spring_test.jar
WORKDIR /
EXPOSE 9001
CMD ["java","-jar","/spring_test.jar","--spring.profiles.active=prod"]


##command
##docker run -it --name srping-test weiyiliu/spring-test
##docker run -d --name srping-test weiyiliu/spring-test
##create table test(id int(4) not null primary key auto_increment, name char(20) not null);