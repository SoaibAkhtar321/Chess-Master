package com.application.servlets; // Updated package name

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userRegistration")
public class UserRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET request to display the registration form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Welcome to User Registration Page</h1>");
        response.getWriter().println("<form method='POST' action='userRegistration'>");
        response.getWriter().println("Username: <input type='text' name='username'><br>");
        response.getWriter().println("Email: <input type='text' name='email'><br>");
        response.getWriter().println("<input type='submit' value='Register'>");
        response.getWriter().println("</form>");
        response.getWriter().println("</body></html>");
    }

    // Handle POST request to process the form submission
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        // Process the data (for now, just display it on the page)
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Registration Successful</h1>");
        response.getWriter().println("<p>Username: " + username + "</p>");
        response.getWriter().println("<p>Email: " + email + "</p>");
        response.getWriter().println("</body></html>");
    }
}
