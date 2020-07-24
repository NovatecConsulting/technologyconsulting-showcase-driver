#!/bin/bash

while true; do 
    ## Clean reports
    rm -rf target/gatling/*

    # Running performance test
    mvn gatling:test -o
done