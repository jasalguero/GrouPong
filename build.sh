#!/bin/bash
cd src/main/conf
mvn clean generate-resources install -Dzone=europe
cd ../../..
mvn clean resources:resources install -DskipTests

