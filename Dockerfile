FROM openjdk:15
VOLUME /tmp
ADD ./target/app-interventor-0.0.1-SNAPSHOT.jar interventor.jar
ENTRYPOINT ["java","-jar","/interventor.jar"]