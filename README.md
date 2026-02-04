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
| **IDE** | IntelliJ IDEA Ultimate 2024.x | [JetBrains](https://www.jetbrains.com/idea/download/) |
| **Build Tool (Optional)** | Maven 3.8+ or Gradle 7+ | [Maven](https://maven.apache.org/) / [Gradle](https://gradle.org/) |

### Tested Configuration

```
OS: Windows 11 / macOS Sonoma / Ubuntu 22.04
Java: OpenJDK 11.0.21
Tomcat: Apache Tomcat 9.0.85
IDE: IntelliJ IDEA Ultimate 2024.3
Maven: Apache Maven 3.9.6
```

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

#### macOS:
```bash
# Using Homebrew
brew install openjdk@11

# Set JAVA_HOME
echo 'export JAVA_HOME=$(/usr/libexec/java_home -v 11)' >> ~/.zshrc
source ~/.zshrc

# Verify
java -version
```

#### Linux (Ubuntu/Debian):
```bash
sudo apt update
sudo apt install openjdk-11-jdk

# Verify
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

   **macOS/Linux:**
   ```bash
   echo 'export CATALINA_HOME=/opt/tomcat' >> ~/.bashrc
   source ~/.bashrc
   ```

4. Start Tomcat:
   
   **Windows:**
   ```cmd
   %CATALINA_HOME%\bin\startup.bat
   ```

   **macOS/Linux:**
   ```bash
   chmod +x $CATALINA_HOME/bin/*.sh
   $CATALINA_HOME/bin/startup.sh
   ```

5. Verify Tomcat is running by visiting [http://localhost:8080](http://localhost:8080)

### Step 3: Install IntelliJ IDEA (Recommended)

1. Download IntelliJ IDEA Ultimate from [JetBrains](https://www.jetbrains.com/idea/download/)
2. Install and activate with your license or student account
3. Configure Tomcat in IntelliJ:
   - Go to `File > Settings > Build, Execution, Deployment > Application Servers`
   - Click `+` and select `Tomcat Server`
   - Point to your Tomcat installation directory

## 🔨 Compilation Methods

### Method 1: Using IntelliJ IDEA (Recommended)

1. **Create New Project:**
   - Open IntelliJ IDEA
   - `File > New > Project`
   - Select `Java Enterprise`
   - Choose `Web Application`
   - Select `Tomcat` as application server
   - Click `Create`

2. **Import Project Files:**
   - Copy `HelloServlet.java` to `src` folder
   - Copy `index.html` to `web` folder
   - Copy `web.xml` to `web/WEB-INF` folder

3. **Configure Tomcat:**
   - `Run > Edit Configurations`
   - Click `+` and select `Tomcat Server > Local`
   - Configure deployment: Add `hello-servlet:war exploded`
   - Set Application context to `/hello-servlet`

4. **Build Project:**
   - `Build > Build Project` (Ctrl+F9)
   - IntelliJ automatically compiles and packages

5. **Run:**
   - Click the green Run button
   - IntelliJ will deploy and start Tomcat automatically

### Method 2: Using Maven

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

### Method 3: Using Gradle

1. **Ensure Gradle is installed:**
   ```bash
   gradle -version
   ```

2. **Build the project:**
   ```bash
   cd servlet-project
   gradle clean build
   ```

3. **Find the WAR file:**
   ```bash
   ls build/libs/hello-servlet-1.0-SNAPSHOT.war
   ```

### Method 4: Manual Compilation (No Build Tool)

1. **Set up environment:**
   ```bash
   export CATALINA_HOME=/path/to/tomcat
   ```

2. **Make compile script executable:**
   ```bash
   chmod +x compile.sh
   ```

3. **Run compilation:**
   ```bash
   ./compile.sh
   ```

4. **Verify compiled class:**
   ```bash
   ls build/classes/HelloServlet.class
   ```

## 📦 Deployment

### Automatic Deployment (IntelliJ)

When using IntelliJ IDEA with configured Tomcat, deployment is automatic when you click Run.

### Manual Deployment - WAR File

1. **Copy WAR file to Tomcat webapps:**
   ```bash
   # Maven build
   cp target/hello-servlet.war $CATALINA_HOME/webapps/

   # Gradle build
   cp build/libs/hello-servlet-1.0-SNAPSHOT.war $CATALINA_HOME/webapps/hello-servlet.war
   ```

2. **Tomcat will automatically:**
   - Detect the new WAR file
   - Extract it to a folder with the same name
   - Deploy the application

3. **Check logs:**
   ```bash
   tail -f $CATALINA_HOME/logs/catalina.out
   ```

### Manual Deployment - Using Script

```bash
chmod +x deploy.sh
./deploy.sh
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
3. **Expected Result:** Greeting page displaying "Hello John Doe"

### Test 3: Verify URL Mapping

The servlet is mapped to `/hello` through the `@WebServlet` annotation:
```java
@WebServlet("/hello")
```

### Test 4: Check Tomcat Manager (Optional)

1. Navigate to: `http://localhost:8080/manager/html`
2. Login with Tomcat credentials (configure in `tomcat-users.xml`)
3. Verify `hello-servlet` appears in the applications list

## 📸 Screenshots

### Screenshot Locations

Include the following screenshots in your documentation:

1. **Java Version Verification**
   ```bash
   java -version
   javac -version
   ```

2. **Tomcat Running**
   - Browser showing `http://localhost:8080`
   - Tomcat welcome page

3. **IntelliJ Configuration**
   - Project structure
   - Tomcat server configuration
   - Run configuration

4. **Compilation Output**
   - Terminal showing successful compilation
   - Build output from Maven/Gradle/Manual

5. **Deployment Confirmation**
   - Tomcat logs showing deployment
   - `webapps` directory structure

6. **Welcome Page (index.html)**
   - Browser showing `http://localhost:8080/hello-servlet/`

7. **Servlet Response**
   - Browser showing `http://localhost:8080/hello-servlet/hello`
   - Greeting message displayed

8. **Browser Developer Tools**
   - Network tab showing successful HTTP 200 response
   - Response headers

## 🐛 Troubleshooting

### Common Issues and Solutions

#### Issue 1: Port 8080 Already in Use

**Error:** `java.net.BindException: Address already in use`

**Solution:**
```bash
# Find process using port 8080
# Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# macOS/Linux
lsof -i :8080
kill -9 <PID>

# Or change Tomcat port in server.xml
```

#### Issue 2: Servlet Not Found (404 Error)

**Possible Causes:**
1. Servlet not compiled
2. Incorrect URL mapping
3. WAR not deployed properly

**Solution:**
```bash
# Check if WAR is extracted
ls $CATALINA_HOME/webapps/hello-servlet/

# Check servlet class exists
ls $CATALINA_HOME/webapps/hello-servlet/WEB-INF/classes/HelloServlet.class

# Check Tomcat logs
tail -f $CATALINA_HOME/logs/catalina.out
```

#### Issue 3: Compilation Errors

**Error:** `package javax.servlet does not exist`

**Solution:**
- Ensure servlet-api.jar is in classpath
- With Maven/Gradle, dependency should be marked as `provided`
- Manual compilation: include servlet-api.jar from Tomcat lib

#### Issue 4: CATALINA_HOME Not Set

**Error:** `CATALINA_HOME is not defined`

**Solution:**
```bash
# Set environment variable
export CATALINA_HOME=/path/to/tomcat

# Add to shell profile for persistence
echo 'export CATALINA_HOME=/path/to/tomcat' >> ~/.bashrc
source ~/.bashrc
```

#### Issue 5: Permission Denied on Scripts

**Error:** `Permission denied: ./compile.sh`

**Solution:**
```bash
chmod +x compile.sh
chmod +x deploy.sh
```

## 🔗 Useful Links

- [Java Servlet Tutorial](https://docs.oracle.com/javaee/7/tutorial/servlets.htm)
- [Tomcat Documentation](https://tomcat.apache.org/tomcat-9.0-doc/index.html)
- [IntelliJ IDEA Documentation](https://www.jetbrains.com/help/idea/)
- [Maven Getting Started](https://maven.apache.org/guides/getting-started/)

## 📝 Project Information

- **Author:** [Your Name]
- **Course:** Web Development / Java EE
- **Date:** February 2026
- **Version:** 1.0

## 📄 License

This project is created for educational purposes.

---

**Note:** Remember to replace "John Doe" in `HelloServlet.java` with your actual first and last name before deploying!

## 🎓 Learning Outcomes

By completing this project, you have learned:
- ✅ How to create a Java Servlet
- ✅ How to use servlet annotations for URL mapping
- ✅ How to compile Java web applications
- ✅ How to deploy applications to Tomcat
- ✅ How to create dynamic HTML content with servlets
- ✅ How to configure servlet deployment descriptors
- ✅ How to test web applications in a browser
- ✅ How to integrate HTML pages with servlet URLs

## 🔄 Next Steps

1. Add request parameters handling
2. Implement session management
3. Add JSP pages
4. Create a form that submits to the servlet
5. Implement database connectivity (JDBC)
6. Add servlet filters and listeners

---

**Happy Coding! 🚀**
