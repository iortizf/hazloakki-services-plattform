FROM openjdk:8u171-jre-slim
MAINTAINER jovaniac@gmail.com"
COPY start.sh /start.sh
COPY wait-for-it.sh /wait-for-it.sh
COPY cuenta-microservice.jar /opt/cuenta-microservice.jar
RUN sh -c 'chmod +x *.sh'
EXPOSE 8085
ENTRYPOINT ["/wait-for-it.sh", "mysql:3307", "--", "/start.sh"]