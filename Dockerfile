FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy all source files into the container
COPY src/Main.java .

# Compile all Java source files
RUN javac Main.java

# Command to run the Java application with the correct classpath
CMD ["java","Main"]
