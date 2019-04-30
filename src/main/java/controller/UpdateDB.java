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

public class UpdateDB extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("updatedb.jsp").include(request, response);
        HttpSession session = request.getSession(false);
        Model model = new Model();
        String item = (String) session.getAttribute("itemKey");
        System.out.println(item);
        int qty = Integer.parseInt(request.getParameter("value"));
        System.out.println(qty + "qty");
        try {
            Map<String, Integer> map  = model.updateDB(item, qty);
            session.removeAttribute("map");
            session.setAttribute("map", map);
            System.out.println("It got till here.");
            request.getRequestDispatcher("inventory.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
