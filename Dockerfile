FROM hseeberger/scala-sbt:8u222_1.3.5_2.13.1
EXPOSE 8891
ADD target/test-1.0-jar-with-dependencies.jar test-1.0-jar-with-dependencies.jar
ENTRYPOINT ["java","-jar","test-1.0-jar-with-dependencies.jar"]