package controller;

import model.Model;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Controller extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<String> items = new ArrayList<>();
//        List<Integer> qty = new ArrayList<>();
        // Get the values from the index.jsp
        response.setContentType("text/html");
        request.getRequestDispatcher("index.jsp").include(request, response);
        String username = request.getParameter("uname");
        String password = request.getParameter("pwd");
        boolean flag;

        Model model = new Model();
        try {
            flag = model.authenticate(username, password);
            System.out.println("Login succesful");
            if (flag) {
                /*
                If the credentials are valid, forward the control to inventory.
                 */
                HttpSession session = request.getSession();
                Map<String, Integer> values = model.getResults(username);
//                for (String item : values.keySet()) {
//                    items.add(item);
//                }
//                for (Integer i : values.values()) {
//                    qty.add(i);
//                }
//                session.setAttribute("items", items);
//                session.setAttribute("qty", qty);
                session.setAttribute("map", values);
                request.getRequestDispatcher("inventory.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("failure.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("This s where it went wrong.");
            request.getRequestDispatcher("failure.jsp").forward(request, response);
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
