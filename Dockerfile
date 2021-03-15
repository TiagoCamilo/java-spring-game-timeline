FROM openjdk:8-jre
RUN mkdir app
ADD /target/timeline-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
ENTRYPOINT java -jar app.jar