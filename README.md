### Driver for TC-Showcase
based on: https://github.com/richardhendricksen/gatling-docker-on-aws/tree/v1 

Read more about it in the blog post [here](https://medium.com/@richard.hendricksen/distributed-load-testing-with-gatling-using-docker-and-aws-d497605692db).


[![Build Status](https://dev.azure.com/nt-tc-showcase/driver/_apis/build/status/driver?branchName=master)](https://dev.azure.com/nt-tc-showcase/driver/_build/latest?definitionId=9&branchName=master)
## Prerequisites  
TODO
### Install  
* Docker
TODO
## Running  
The test consists of 3 steps:  
* Building the Docker image  
TODO

## Developing
TODO extend
### Run Gatling tests directly without Docker
`mvn clean gatling:test`  

### Creating docker image locally
Use default time zone:
`docker build -t gatling-runner .` 

Set local time zone:
`docker build --build-arg TIME_ZONE="$(curl -s https://ipapi.co/timezone)" -t gatling-runner .`    

### Run docker image locally
`docker-compose up --scale gatling-runner=10` 
 