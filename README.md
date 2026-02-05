# Hello Servlet Project

A simple Java Servlet application that displays a personalized greeting message, deployed on Apache Tomcat.

## 📋 Table of Contents

- [Overview](#overview)
- [Software Requirements](#software-requirements)
- [Project Structure](#project-structure)
- [Installation Steps](#installation-steps)
- [Compilation Methods](#compilation-methods)
- [Deployment](#deployment)
- [Testing](#testing)
- [Screenshots](#screenshots)
- [Troubleshooting](#troubleshooting)

## 🎯 Overview

This project demonstrates the basic implementation of a Java Servlet that:
- Responds to HTTP GET and POST requests
- Generates dynamic HTML content
- Uses annotations for URL mapping
- Includes a styled welcome page with links to the servlet

## 💻 Software Requirements

### Required Software

| Software | Version Used | Download Link |
|----------|-------------|---------------|
| **Java JDK** | 11 or higher | [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/) |
| **Apache Tomcat** | 9.0.x or 10.x | [Apache Tomcat](https://tomcat.apache.org/download-90.cgi) |
| **Build Tool | Maven 3.9 | [Maven](https://maven.apache.org/) / [Gradle](https://gradle.org/) |


## 📁 Project Structure

```
servlet-project/
├── HelloServlet.java          # Main servlet class
├── index.html                 # Welcome page with link to servlet
├── web.xml                    # Deployment descriptor (optional with annotations)
├── pom.xml                    # Maven build configuration
├── build.gradle               # Gradle build configuration (alternative)
├── compile.sh                 # Manual compilation script
├── deploy.sh                  # Deployment script
└── README.md                  # This file

When deployed, structure becomes:
hello-servlet/
├── index.html
├── WEB-INF/
│   ├── classes/
│   │   └── HelloServlet.class
│   ├── lib/
│   └── web.xml
```

## 🚀 Installation Steps

### Step 1: Install Java JDK

#### Windows:
1. Download Java JDK from Oracle or AdoptOpenJDK
2. Run the installer
3. Set JAVA_HOME environment variable:
   ```cmd
   setx JAVA_HOME "C:\Program Files\Java\jdk-11"
   setx PATH "%PATH%;%JAVA_HOME%\bin"
   ```
4. Verify installation:
   ```cmd
   java -version
   javac -version
   ```

### Step 2: Install Apache Tomcat

#### All Platforms:
1. Download Tomcat from [https://tomcat.apache.org/download-90.cgi](https://tomcat.apache.org/download-90.cgi)
2. Extract to desired location (e.g., `C:\tomcat` or `/opt/tomcat`)
3. Set CATALINA_HOME environment variable:

   **Windows:**
   ```cmd
   setx CATALINA_HOME "C:\tomcat"
   ```

4. Start Tomcat:
   
   **Windows:**
   ```cmd
   %CATALINA_HOME%\bin\startup.bat
   ```
   
5. Verify Tomcat is running by visiting [http://localhost:8080](http://localhost:8080)



## 🔨 Compilation Using Maven

1. **Ensure Maven is installed:**
   ```bash
   mvn -version
   ```

2. **Build the project:**
   ```bash
   cd servlet-project
   mvn clean package
   ```

3. **Find the WAR file:**
   ```bash
   ls target/hello-servlet.war
   ```


## 📦 Deployment


### Manual Deployment - WAR File

1. **Copy WAR file to Tomcat webapps:**
   ```bash
   # Maven build
   cp target/hello-servlet.war $CATALINA_HOME/webapps/


2. **Tomcat will automatically:**
   - Detect the new WAR file
   - Extract it to a folder with the same name
   - Deploy the application

3. **Check logs:**
   ```bash
   tail -f $CATALINA_HOME/logs/catalina.out
   ```


### Manual Deployment - Exploded WAR

1. **Create directory structure:**
   ```bash
   mkdir -p $CATALINA_HOME/webapps/hello-servlet/WEB-INF/{classes,lib}
   ```

2. **Copy files:**
   ```bash
   # Copy compiled servlet
   cp build/classes/HelloServlet.class $CATALINA_HOME/webapps/hello-servlet/WEB-INF/classes/

   # Copy HTML file
   cp index.html $CATALINA_HOME/webapps/hello-servlet/

   # Copy web.xml
   cp web.xml $CATALINA_HOME/webapps/hello-servlet/WEB-INF/
   ```

3. **Restart Tomcat:**
   ```bash
   $CATALINA_HOME/bin/shutdown.sh
   $CATALINA_HOME/bin/startup.sh
   ```

## ✅ Testing

### Test 1: Access Welcome Page

1. Open browser
2. Navigate to: `http://localhost:8080/hello-servlet/`
3. You should see the styled welcome page
4. **Expected Result:** Professional landing page with project overview

### Test 2: Direct Servlet Access

1. Click "Launch Servlet" button on welcome page, or
2. Navigate directly to: `http://localhost:8080/hello-servlet/hello`
3. **Expected Result:** Greeting page displaying "Hello Ahmad Lakkis"

### Test 3: Verify URL Mapping

The servlet is mapped to `/hello` through the `@WebServlet` annotation:
```java
@WebServlet("/hello")
```

## 🔗 Useful Links

- [Java Servlet Tutorial](https://docs.oracle.com/javaee/7/tutorial/servlets.htm)
- [Tomcat Documentation](https://tomcat.apache.org/tomcat-9.0-doc/index.html)
- [Maven Getting Started](https://maven.apache.org/guides/getting-started/)

## 📝 Project Information

- **Author:** Ahmad Lakkis
- **Course:** Applications Distribuees
- **Date:** February 2026
- **Version:** 1.0

## 📄 License

This project is created for educational purposes.

---


---

**Happy Coding! 🚀**
