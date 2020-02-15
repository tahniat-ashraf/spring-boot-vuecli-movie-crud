FROM tomcat:9-jre8-alpine

MAINTAINER tahniat88e@gmail.com

RUN rm -fr /usr/local/tomcat/webapps/ROOT

COPY backend/target/spring-boot-vue-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

CMD ["catalina.sh", "run"]
