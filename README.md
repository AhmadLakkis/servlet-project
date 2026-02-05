# Hello Servlet Project

A Java Servlet application that displays a personalized greeting message, deployed on Apache Tomcat 9.0.115.

## 📋 Assignment Overview

This project fulfills the requirements of the "Applications Distribuees" course assignment:
1. ✅ Install and configure Apache Tomcat web server
2. ✅ Implement a servlet displaying "Hello Ahmad Lakkis"
3. ✅ Compile the servlet using Maven
4. ✅ Deploy servlet to Tomcat
5. ✅ Create HTML page with link to servlet
6. ✅ Test in web browser

## 👨‍💻 Student Information

- **Name:** Ahmad Lakkis
- **Course:** Applications Distribuees
- **Date:** February 2026
- **Assignment:** Java Servlet Implementation with Apache Tomcat

## 💻 Software & Versions Used

| Software | Version | Purpose |
|----------|---------|---------|
| **Java JDK** | 21.0.7 (Oracle) | Java development and runtime |
| **Apache Tomcat** | 9.0.115 | Web server and servlet container |
| **Apache Maven** | 3.9.12 | Build automation tool |
| **Operating System** | Windows 10 | Development environment |
| **Browser** | Chrome/Edge | Testing |

**Why Maven instead of IntelliJ?**
I chose to use Maven via command line for this project as it provides better understanding of the build process and doesn't require IntelliJ Ultimate license.

## 📁 Project Structure
```
servlet-project/
├── pom.xml                                # Maven configuration
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── example/
        │           └── HelloServlet.java  # Main servlet
        └── webapp/
            ├── index.html                 # Welcome page
            └── WEB-INF/
                └── web.xml                # Deployment descriptor
```

## 🎯 Implementation Details

### HelloServlet.java
- Extends `HttpServlet` class
- Mapped to `/hello` using `@WebServlet("/hello")` annotation
- Handles both GET and POST requests
- Generates dynamic HTML with CSS styling
- Displays: **"Hello Ahmad Lakkis"**

### index.html
- Professional welcome page with gradient background
- Single "Launch Servlet" button linking to `/hello`
- Responsive design
- Project information display

### web.xml
- Deployment descriptor for Tomcat
- Configures welcome files
- Sets session timeout

## 🔨 Build Process

### Prerequisites
```cmd
# Verify Java is installed
java -version
# Output: java version "21.0.7"

# Verify Maven is installed
mvn --version
# Output: Apache Maven 3.9.12
```

### Compilation Steps
```cmd
# Navigate to project directory
cd C:\Users\User\Desktop\servlet-project

# Clean and build
mvn clean package
```

**Output:** `target/hello-servlet.war` (approximately 4 KB)

## 📦 Deployment to Tomcat

### Step 1: Set Environment Variable
```cmd
set CATALINA_HOME=C:\apache-tomcat-9.0.115
```

### Step 2: Copy WAR file
```cmd
copy target\hello-servlet.war %CATALINA_HOME%\webapps\
```

### Step 3: Start Tomcat
```cmd
%CATALINA_HOME%\bin\startup.bat
```

### Step 4: Verify Deployment
Wait 10-15 seconds for Tomcat to extract the WAR file.

Check deployment in logs:
```cmd
type %CATALINA_HOME%\logs\catalina.out
```

Look for: `Deployment of web application archive ... has finished`

## ✅ Testing & Results

### Test 1: Tomcat Running
- **URL:** http://localhost:8080
- **Result:** ✅ Tomcat welcome page displays

### Test 2: Welcome Page
- **URL:** http://localhost:8080/hello-servlet/
- **Result:** ✅ Professional landing page with "Launch Servlet" button

### Test 3: Servlet Response
- **URL:** http://localhost:8080/hello-servlet/hello
- **Expected:** "Hello Ahmad Lakkis" with styled HTML
- **Result:** ✅ Greeting displays correctly with purple gradient background

### Test 4: HTTP Response
- **Status Code:** 200 OK
- **Content-Type:** text/html;charset=UTF-8
- **Verified using:** Browser Developer Tools (F12 → Network tab)

## 🚧 Challenges & Solutions

### Challenge 1: Understanding Maven vs IntelliJ
**Issue:** Assignment mentioned IntelliJ Ultimate, but I don't have a license.
**Solution:** Used Maven command line instead, which works perfectly and helps understand the build process better.

### Challenge 2: Correct File Structure
**Issue:** Initially confused about Maven's `src/main/java` structure.
**Solution:** Followed Maven conventions: created package `com.example` and placed servlet there.

### Challenge 3: Windows Command Syntax
**Issue:** Most tutorials show Linux commands (`cp`, `ls`, etc.)
**Solution:** Adapted all commands to Windows (`copy`, `dir`, etc.)

## 📸 Documentation

Complete documentation with screenshots is available in:
- **Word Document:** `Lakkis_ServletProject.docx`
- **GitHub Repository:** https://github.com/YOUR-USERNAME/servlet-project/tree/servlet-implementation

## 🔗 Repository Contents

- ✅ All source code files
- ✅ Maven configuration (pom.xml)
- ✅ This README with complete instructions
- ✅ Screenshots of implementation (in separate folder)

## 🎓 Learning Outcomes

Through this project, I learned:
- Java Servlet API and HTTP request handling
- Maven build automation
- Web application deployment on Tomcat
- Dynamic HTML generation from server-side code
- URL mapping with annotations
- Troubleshooting deployment issues

## 📞 Additional Information

**Browser Compatibility:** Tested on Chrome and Edge
**Tomcat Version:** 9.0.115 chosen for stability and Java 21 compatibility
**Port Used:** 8080 (Tomcat default)

---

**End of README**

Created by Ahmad Lakkis for Applications Distribuees course, February 2026.


