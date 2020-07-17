FROM maven:3.6-jdk-14 

LABEL maintainer="Richard Hendricksen <richard.hendricksen@codecontrol.nl>"

ARG TIME_ZONE=Europe/Berlin
WORKDIR /build

COPY pom.xml .
RUN mvn org.apache.maven.plugins:maven-dependency-plugin:3.1.1:go-offline

COPY src/ /build/src
COPY bin/run.sh .

# With the latest scala-maven-plugin, it always wants to download certain libs at runtime without which the build fails
# Hence install with offline option not possible currently
# For root cause, see: https://github.com/davidB/scala-maven-plugin/blob/master/src/main/java/sbt_inc/SbtIncrementalCompiler.java#L219-L226
RUN mvn -B install

ENTRYPOINT ["./run.sh"]
