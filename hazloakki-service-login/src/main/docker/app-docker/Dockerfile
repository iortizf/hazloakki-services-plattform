ROM openjdk:8u171-jre-slim
MAINTAINER jovaniac@gmail.com"
COPY start.sh /start.sh
COPY login-microservice.jar /opt/login-microservice.jar
RUN sh -c 'chmod +x *.sh'
EXPOSE 8085
ENTRYPOINT ["/start.sh"]