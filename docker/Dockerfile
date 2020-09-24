FROM java:8
MAINTAINER David <dav1dch@outlook.com>
VOLUME /tmp
ADD ylsx-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "./app.jar"]
