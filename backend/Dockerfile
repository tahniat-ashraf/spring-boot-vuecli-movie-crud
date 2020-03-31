FROM maven:3.6.3-jdk-11
# Common Version from arg
ARG VERSION=1.0
# Creating app directory
WORKDIR /usr/local/movies
# Copying Application
COPY . .

RUN pwd

RUN ls -larth
# Getting .m2 libraries
RUN mvn clean package

RUN pwd

RUN ls -larth

WORKDIR /usr/local/movies/target

RUN pwd

RUN ls -larth

#FROM movies:1.0 as build

## Third Phase
FROM openjdk:11.0.6-jdk
# Creating app directory
WORKDIR /usr/src/movies
# Copying Jar
COPY --from=0 "/usr/local/movies/target/movies-0.0.1-SNAPSHOT.jar" movies.jar

RUN pwd

RUN ls -la
# Exposing Port
EXPOSE 8098
# Running App
ENTRYPOINT ["java","-jar","/usr/src/movies/movies.jar"]
