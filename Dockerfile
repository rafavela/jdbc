FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/jdbc-1.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["sh","-c","java ${JAVA_OPTS} -jar /app.jar ${0} ${@}"]