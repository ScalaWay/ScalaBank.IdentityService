FROM maven as build
WORKDIR /app
COPY . .
RUN mvn -am -pl identity-api clean package -DskipTests=true

COPY /identity-api/target/*.jar .
EXPOSE 8090

# Run the jar file
ENTRYPOINT ["java", "-jar", "api-2.6.1.jar"]
