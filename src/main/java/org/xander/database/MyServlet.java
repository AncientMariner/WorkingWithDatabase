package org.xander.database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class MyServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JDBCConnector jdbcConnector = new JDBCConnector();
        try {
            jdbcConnector.obtainDataFromDb();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println(request.getRequestURL());
        out.println("</body>");
        out.println("</html>");

        String groups = jdbcConnector.groupNames.toString();
        String products = jdbcConnector.productNames.toString();

        request.setAttribute("groups", groups);
        request.setAttribute("products", products);
        response.setContentType("text/html");

        RequestDispatcher view = request.getRequestDispatcher("in  dex.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }


//        String c = request.getParameter("color");

//        PrintWriter out = response.getWriter();


    }
}