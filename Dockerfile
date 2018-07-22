FROM java:8
VOLUME /home
ARG JAR_FILE
COPY ${JAR_FILE} kata-service.jar
CMD ["java","-jar","kata-service.jar"]