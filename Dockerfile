FROM openjdk:8u191-jre-alpine3.8


# Workspace
# add curl
RUN apk add curl jq


# Workspace dir will create and can be navigate to from
# docker run -it --entrypoint=/bin/sh selenium-docker
WORKDIR /usr/share/automation


# ADD .jar under target from host
# into this image
ADD target/selenium-docker.jar 			selenium-docker.jar
ADD target/selenium-docker-tests.jar 	selenium-docker-tests.jar
ADD target/libs							libs


# in case of any other dependency like .csv / .json / .xls
# please ADD that as well


# ADD suite files
ADD book-flight-module.xml				book-flight-module.xml


# ADD health check script
#ADD healthcheck.sh                      healthcheck.sh

# BROWSER
# HUB_HOST
# MODULE
#ENTRYPOINT sh healthcheck.sh

# Command line to execute the test
# Expects below ennvironment variables
# BROWSER = chrome / firefox
# MODULE  = order-module / search-module
# HOST = selenium hub hostname / ipaddress
ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DHUB_HOST=$HUB_HOST -DBROWSER=$BROWSER org.testng.TestNG $MODULE