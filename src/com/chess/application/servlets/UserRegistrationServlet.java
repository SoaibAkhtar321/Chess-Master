package com.application.servlets;

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
        response.getWriter().println("Username: <input type='text' name='username' required><br>");
        response.getWriter().println("Email: <input type='email' name='email' required><br>");
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

        // Simple validation (ensure both fields are not empty)
        if (username == null || username.isEmpty() || email == null || email.isEmpty()) {
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>Registration Failed</h1>");
            response.getWriter().println("<p>Please fill in all fields.</p>");
            response.getWriter().println("<a href='userRegistration'>Go back to Registration</a>");
            response.getWriter().println("</body></html>");
            return;
        }

        // Store the data (this can be extended to save to a database or session)
        // For now, we just display the data as a confirmation message
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Registration Successful</h1>");
        response.getWriter().println("<p>Username: " + username + "</p>");
        response.getWriter().println("<p>Email: " + email + "</p>");
        response.getWriter().println("</body></html>");
    }
}
