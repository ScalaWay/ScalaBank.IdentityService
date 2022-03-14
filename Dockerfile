FROM maven as build
WORKDIR /app
COPY . .
RUN mvn -am -pl api clean package -DskipTests=true

COPY /api/target/*.jar .
EXPOSE 8010

# Run the jar file
ENTRYPOINT ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]
