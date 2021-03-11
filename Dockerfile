# a Dockerfile is a simple text file that contains the commands that
# a user could call to assemble an image whereas Docker Compose is
# this will pull the java and jre from alpine image
FROM openjdk:8u191-jre-alpine3.8

# Workspace dir will create and can be navigate to from
# docker run -it --entrypoint=/bin/sh selenium-docker
WORKDIR /usr/share/automation

# ADD .jars under project target from host into this image
ADD target/selenium-docker-project.jar 			selenium-docker-project.jar
ADD target/selenium-docker-tests.jar 	        selenium-docker-tests.jar
ADD target/libs						        	libs

# in case of any other dependency like .csv / .json / .xls
# please ADD that as well

# ADD suite files .xml/.csv/.json/.xls
ADD book-flight-module.xml				book-flight-module.xml
ADD search-module.xml					search-module.xml

# ADD health check script
ADD healthcheck.sh                      healthcheck.sh

# BROWSER -D preference
# HUB_HOST
# MODULE - probebly the .xml testng file
# -D stand for args $ means that browser/host/module are pass as arguments
# docker build -t=selenium-docker .
# This will get the container with the images from the contianer repository and than will create the image
ENTRYPOINT sh healthcheck.sh