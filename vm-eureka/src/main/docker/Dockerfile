FROM java:8
VOLUME /tmp
ADD  vm-eureka-2.0.0.jar vm-eureka-2.0.0.jar
#RUN bash -c 'touch /*.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/vm-eureka-2.0.0.jar"]
EXPOSE 1110-1210