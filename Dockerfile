FROM tomcat:9.0.27-jdk11-openjdk
RUN rm -rf /usr/local/tomcat/webapps/*
ADD ./devops-1.0.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh", "run"]