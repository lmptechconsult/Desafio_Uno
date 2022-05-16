#!/bin/sh
java -jar api-periodos-1.0.0.jar &
cd desafio
sh mvnw spring-boot:run