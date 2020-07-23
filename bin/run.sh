#!/bin/bash

## Clean reports
rm -rf target/gatling/*

# Running performance test
mvn gatling:test -o

#Upload reports
for _dir in target/gatling/*/
do
echo "UPLOAD following dirs:" ${_dir}
#here we could define storage blob upload to az
done
