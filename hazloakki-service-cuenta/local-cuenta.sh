#!/usr/bin/env sh

gradle buildImage && cd src/main/docker && 
#cd src/main/docker && 
docker-compose up --build
docker-compose stop
docker-compose rm -f

