package controller;

import model.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;


public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("register.jsp").include(request, response);
        String username = (String) request.getAttribute("uname");
        String password = (String) request.getAttribute("pwd");
        Model model = new Model();
        try {
            model.createUser(username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        try {
            Map<String, Integer> map = model.getResults("username");
            HttpSession session = request.getSession(false);
            session.removeAttribute("map");
            session.setAttribute("map", map);
            request.getRequestDispatcher("inventory.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
