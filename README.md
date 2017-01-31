# DevOps App

Program build in the DevOps course.

## Prerequisites
Make sure you have installed:
* Java 1.8
* Gradle 3.3
* Tomcat 7

## Compile and Deploy
1. Go the application folder
2. Run gradle war
3. Make sure tomcat is running
4. Copy the .war generated in build/lib to the tomcat webapps directory
5. Open a browser and type the following:

``` 
http://localhost:8080/altair/rest/hello
``` 


