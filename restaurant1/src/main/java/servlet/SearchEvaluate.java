package servlet;

import Pojo.Evaluate;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.manage.MySQLJDBC;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SearchEvaluate", value = "/SearchEvaluate")
public class SearchEvaluate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        System.out.println("id:"+id);
        Evaluate e;
        try {
            e=MySQLJDBC.searchEvaluateManager(id);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        request.setAttribute("e",e);
        RequestDispatcher rd=request.getRequestDispatcher("/dishDetail2.jsp");
        rd.forward(request,response);
    }
}
