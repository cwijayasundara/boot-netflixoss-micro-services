
#Software Needed

Kitematic(https://kitematic.com/) is used to kick off the Docker containers.

#Building the Docker Images
To build the code as a docker image, use the command-line window opened with Kitematic.
Run the following maven commands in the following directories:

    - confsvr  
    - eurekasvr
    - order-service
    - product-service

This command will execute the [Spotify docker plugin]

    mvn clean package docker:build

#Running the Application

form /docker run the below command

    docker-compose -f common/docker-compose.yml up

This command will start up 5 containers including the DB (postgres) Docker image.

The below command will give the Docker machine IP

docker-machine ip

#Testing the app

list all the apps in Eureka : http:/192.168.99.100:8761/eureka/apps/

 order service that internally call the product service through Eureka: http://192.168.99.100:8080/v1/products/prod-1/orders/ord-1
 order service : http://192.168.99.100:8080/v1/products/prod-1/orders/