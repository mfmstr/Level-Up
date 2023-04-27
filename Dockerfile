FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the application files to the container
COPY src/ /app/src/

# Build the application
RUN javac -d bin -cp src src/com/levelup/ecommerceapp/Main.java

# Set the command to run when the container starts
CMD ["java", "-classpath", "bin", "com.levelup.ecommerceapp.Main"]