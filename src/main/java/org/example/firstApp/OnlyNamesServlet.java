package org.example.firstApp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@WebServlet(urlPatterns = "/only_names")
public class OnlyNamesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain; charset=UTF-8");

        List<String> params = (List<String>) req.getParameterNames();
        PrintWriter writer = resp.getWriter();
        for (String param: params) {
            if (param.contains("_")){
                writer.write(req.getParameter(param));
            }
        }

    }
}
