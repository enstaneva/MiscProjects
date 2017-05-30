# At this point latest stable version of tomcat is 8.5.15
FROM tomcat:8.5.15-jre8

# Remove the ROOT, so we can deploy the app as ROOT
RUN rm -rf /usr/local/tomcat/webapps/

# Deploy the as ROOT
ADD target/*.war /usr/local/tomcat/webapps/ROOT.war
