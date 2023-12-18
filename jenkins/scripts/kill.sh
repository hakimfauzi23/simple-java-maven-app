#!/usr/bin/env bash

echo 'The following command terminates the "my-app-1.0-SNAPSHOT.jar" Java process using its PID'
echo '(written to ".pidfile"), all of which were conducted when "deliver.sh"'
echo 'was executed.'
set -x

# Use the `pkill` command to terminate the Java process with the specified name
pkill -f my-app-1.0-SNAPSHOT.jar
