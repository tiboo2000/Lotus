# Utilisez une image de base avec Gradle et Java 11
FROM gradle:7.4.1-jdk17
LABEL maintainer="LotusMaximilien"
# Copiez votre code source dans l'image
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

# Construisez l'application avec Gradle
RUN gradle build --no-daemon --info -x test

# Exposez le port sur lequel votre application s'exécute
EXPOSE 9090

# Définissez la commande pour exécuter votre application
CMD ["java", "-jar", "build/libs/Lotus-0.0.1-SNAPSHOT.jar"]