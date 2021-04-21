#!/usr/bin/env bash

echo "Checking if hub is ready - $HUB_HOST"

while [ "$( curl -s http://"$HUB_HOST":4444/wd/hub/status )" != "true" ]
do
	sleep 1
done
