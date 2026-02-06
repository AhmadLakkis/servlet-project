import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HelloServlet - A simple servlet that displays a greeting message
 * @author Your Name
 * @version 1.0
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Handles GET requests
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html;charset=UTF-8");
        
        // Get the PrintWriter to write HTML response
        PrintWriter out = response.getWriter();
        
        try {
            // Generate HTML response
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello Servlet</title>");
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: Arial, sans-serif;");
            out.println("    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);");
            out.println("    display: flex;");
            out.println("    justify-content: center;");
            out.println("    align-items: center;");
            out.println("    height: 100vh;");
            out.println("    margin: 0;");
            out.println("}");
            out.println(".container {");
            out.println("    background: white;");
            out.println("    padding: 40px;");
            out.println("    border-radius: 10px;");
            out.println("    box-shadow: 0 10px 25px rgba(0,0,0,0.2);");
            out.println("    text-align: center;");
            out.println("}");
            out.println("h1 {");
            out.println("    color: #667eea;");
            out.println("    margin-bottom: 20px;");
            out.println("}");
            out.println("p {");
            out.println("    color: #666;");
            out.println("    font-size: 16px;");
            out.println("}");
            out.println("a {");
            out.println("    display: inline-block;");
            out.println("    margin-top: 20px;");
            out.println("    padding: 10px 20px;");
            out.println("    background: #667eea;");
            out.println("    color: white;");
            out.println("    text-decoration: none;");
            out.println("    border-radius: 5px;");
            out.println("    transition: background 0.3s;");
            out.println("}");
            out.println("a:hover {");
            out.println("    background: #764ba2;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Hello Ahmad Lakkis</h1>");
            out.println("<p>Welcome to my first servlet!</p>");
            out.println("<p>This servlet is running on Apache Tomcat</p>");
            out.println("<a href='index.html'>Back to Home</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    /**
     * Handles POST requests (calls doGet)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns servlet description
     */
    @Override
    public String getServletInfo() {
        return "HelloServlet - Displays a greeting message";
    }
}
