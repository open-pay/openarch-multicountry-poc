# Base Image
FROM 378653672129.dkr.ecr.us-east-1.amazonaws.com/op-mx-dev-openarch-docker-java21:latest

# Port
EXPOSE 8443

# Environment Variables
ENV MS_JAVA_OPTS=""
ENV MS_PROFILE_ACTIVE=undefined
ENV MS_SECRET_NAME=undefined
ENV MS_CLOUD_CONFIG_URI=undefined

# Volumes
VOLUME /tmp
VOLUME /app-data

# App Data Setup
RUN rm -rf /app-data
RUN mkdir /app-data
RUN chown -R openpayu:openpayg /app-data

# App Home Setup
RUN rm -rf /app-home
RUN mkdir /app-home
WORKDIR /app-home
COPY ./target/openarch-multicountry-poc*[SNAPSHOT|RELEASE].jar app.jar
RUN sh -c "touch app.jar"
RUN chown -R openpayu:openpayg /app-home

# User Setup
USER openpayu

# App Execution
ENTRYPOINT exec java $MS_JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=$MS_PROFILE_ACTIVE -Dcustom.secret.name=$MS_SECRET_NAME -Dcustom.cloud.config.uri=$MS_CLOUD_CONFIG_URI -jar app.jar
