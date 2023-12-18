package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.manage.MySQLJDBC;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddEvaluate", value = "/AddEvaluate")
public class AddEvaluate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        String sender= (String) session.getAttribute("username");
        String restaurant=request.getParameter("restaurant");
        String food=request.getParameter("food");
        String receiver= "";
        int a;
        try {
            receiver=MySQLJDBC.searchResM(restaurant);
            a=MySQLJDBC.insertUserEvaluate(title,content,sender,restaurant,food,receiver);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
