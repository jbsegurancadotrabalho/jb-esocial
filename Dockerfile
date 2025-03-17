FROM openjdk:17

WORKDIR /app

COPY . /app

RUN chmod +x ./mvnw

RUN ./mvnw -B clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/jb-esocial-1.0.jar"]
