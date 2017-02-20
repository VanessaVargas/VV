# DevOps App

### Table Of Contents
1. [Introduction](#introduction)
2. [Prerequisites for Linux](#prerequisites-for-a-linux-machine)
3. [Run the application](#compile-and-deploy)

## Introduction
Application created for the DevOps course.
There is a list of profiles and each profiles can have one or more messages.
The following endpoints are present in the application:

Profiles:

GET /profiles

POST /profiles

GET /profiles/{ProfileId}

DELETE /profiles{ProfileId}

UPDATE /profiles/{ProfileId}


Messages:

GET /profiles/{profileId}/messages

POST /profiles/{profileId}/messages

GET /profiles/{profileId}/messages/{messageId}

DELETE /profiles/{profileId}/messages/{messageId}

UPDATE /profiles/{profileId}/messages/{messageId}

## Prerequisites for a Linux machine
The vagrant machine should have the following:
* unzip command
* Java 1.8
* Gradle 3.3
* Tomcat 7
* SonarQube 5.6
* Sonar Scanner 2.8

### Unzip command 
Execute the following in the console:
	``` 
	apt-get install unzip
	``` 

### Java
1. [Download JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. Create the directory where Java will be installed
	```
	mkdir /opt/java && cd /opt/java
	```
3. Extract the files downloaded in step 1
	```
	tar -zxvf jdk-8u121-linux-x64.tar.gz
	```
4. Move to the extracted directory and use command **update-alternatives** to tell system where java and its executables are installed.
	```
	cd jdk1.8.0_121/
	update-alternatives --install /usr/bin/java java /opt/java/jdk1.8.0_121/bin/java 100  
	update-alternatives --config java
	```
	```
	update-alternatives --install /usr/bin/javac javac /opt/java/jdk1.8.0_121/bin/javac 100
	update-alternatives --config javac
	```
	```
	update-alternatives --install /usr/bin/jar jar /opt/java/jdk1.8.0_121/bin/jar 100
	update-alternatives --config jar
	```

5. Set up Java Environment Variables.
	```
	export JAVA_HOME=/opt/java/jdk1.8.0_121/	
	export JRE_HOME=/opt/java/jdk1.8.0._121/jre 	
	export PATH=$PATH:/opt/java/jdk1.8.0_121/bin:/opt/java/jdk1.8.0_121/jre/bi
	```
6. Verify Java was installed
	```
	java -version
	```

### Gradle
1. [Download Gradle](https://gradle.org/install)
2. Create the folder where Gradle will be installed
	```
	mkdir /opt/gradle
	```
3. Extract gradle
	```
	unzip -d /opt/gradle /vagrant/gradle-3.3-bin.zip
	```
4. Set up the environment variables
	```
	export PATH=$PATH:/opt/gradle/gradle-3.3/bi
	```
5. Verify Gradle was installed
	```
	gradle -v
	```

### Tomcat
1. Install Tomcat7
	```
	apt-get install tomcat7
	```
2. Edit JAVA_HOME in the following file. Set it up to JDK 8.
	```
	nano /etc/default/tomcat7
	```
3. Edit the port in the following file. Set it up to **8585**.
	```
	nano /var/lib/tomcat7/conf/server.xml
	```
4. Restart the service
	```
	service tomcat7 restart
	```

### SonarQube and Sonar Scanner
Follow the steps in [this page](https://docs.sonarqube.org/display/SONAR/Get+Started+in+Two+Minutes) to install SonarQube and Sonar Scanner.

## Compile and Deploy
1. Go the application folder
2. Run gradle war
3. Make sure Tomcat service is running
4. Copy the .war generated in build/lib to the tomcat webapps directory
5. Open a browser and type the following:
	``` 
	http://localhost:8585/altair/rest/profiles
	``` 
You should see a list of the profiles that already exist in the application.

## Test
