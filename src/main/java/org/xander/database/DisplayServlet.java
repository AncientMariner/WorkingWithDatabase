package org.xander.database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DisplayServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JDBCConnector jdbcConnector = new JDBCConnector();
        try {
            request.setAttribute("groups", jdbcConnector.obtainGroupsFromDb());
            request.setAttribute("products", jdbcConnector.obtainProductsFromDb());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html");

        RequestDispatcher view = request.getRequestDispatcher("/result");
        try {
            view.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}