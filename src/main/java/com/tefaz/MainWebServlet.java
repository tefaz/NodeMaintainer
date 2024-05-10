package com.tefaz;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class MainWebServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        // Load HTML content
        InputStream htmlStream = getServletContext().getResourceAsStream("/index.html");
        if (htmlStream != null) {
            String htmlContent = new String(htmlStream.readAllBytes(), StandardCharsets.UTF_8);

            // You can enrich the HTML content here if needed
            // For example, replace placeholders with dynamic data
            // htmlContent = htmlContent.replace("{dynamicData}", "Dynamic Value");

            // Send HTML response
            try (PrintWriter out = resp.getWriter()) {
                out.write(htmlContent);
            }
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
