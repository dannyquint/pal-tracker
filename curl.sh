#!/bin/bash

curl -i localhost:8080/time-entries

curl -i -XPOST -H"Content-Type: application/json" localhost:8080/time-entries -d"{\"projectId\": 1, \"userID\": 2, \"date\": \"2019-01-01\", \"hours\": 8}"

curl -i localhost:8080/time-entries/1

curl -i -XPUT -H"Content-Type: application/json" localhost:8080/time-entries/1 -d"{\"projectId\": 88, \"userID\": 99, \"date\": \"2019-01-01\", \"hours\": 8}"

curl -i -XDELETE -H"Content-Type: application/json" localhost:8080/time-entries/1
