FROM openjdk:8-jre-alpine
EXPOSE 8080
ADD build/libs/java-tdd-exercise-1.0-SNAPSHOT.jar /java-tdd-exercise.jar
ENV DOJO_APP_VERSION DEPLOY_VERSION
RUN sh -c 'touch /java-tdd-exercise.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-Xmx768m","-jar","/java-tdd-exercise.jar"]
