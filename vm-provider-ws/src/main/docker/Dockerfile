FROM java:8
VOLUME /tmp
ADD vm-provider-ws-2.0.0.jar vm-provider-ws-2.0.0.jar
#RUN bash -c 'touch /*.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/vm-provider-ws-2.0.0.jar"]
EXPOSE 8880-8980