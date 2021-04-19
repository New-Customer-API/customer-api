FROM openjdk:8

ADD . /customer
WORKDIR /customer

RUN apt-get update && \
    apt-get install -y maven

RUN mvn clean package compile

EXPOSE 8080

ENTRYPOINT ["java","-jar","./target/customer-api.jar"]
