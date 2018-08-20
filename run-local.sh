#!/usr/bin/env sh

cd hazloakki-service-ofertas-service
gradle clean buildImage

cd ../hazloakki-service-analitica
./gradlew clean buildImage

cd ../hazloakki-service-registry
./gradlew clean buildImage

cd ../hazloakki-service-gateway
./gradlew clean buildImage

cd ../hazloakki-service-cuenta
./gradlew clean buildImage

cd ../hazloakki-service-negocio
./gradlew clean buildImage

cd ../hazloakki-service-login
./gradlew clean buildImage

cd ../hazloakki-service-catalogos
./gradlew clean buildImage


docker-compose up 
docker-compose stop
docker-compose rm -f
