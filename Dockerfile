FROM openjdk:12-oracle
ADD target/my_budget-0.0.1-SNAPSHOT.jar .
EXPOSE 8000
CMD java -jar my_budget-0.0.1-SNAPSHOT.jar
