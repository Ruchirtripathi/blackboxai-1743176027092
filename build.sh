#!/bin/bash
# Build script for the government scheme finder application

# Create necessary directories
mkdir -p WebContent/WEB-INF/classes
mkdir -p WebContent/css

# Compile Java files
javac -cp "/usr/share/tomcat9/lib/servlet-api.jar" -d WebContent/WEB-INF/classes src/main/java/com/government/SchemeFinderServlet.java

# Create WAR file
jar cvf government-scheme-finder.war -C WebContent .

echo "Build completed. WAR file created: government-scheme-finder.war"