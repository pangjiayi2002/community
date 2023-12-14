package servlet.manager;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.manage.MySQLJDBC;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateEvaluate", value = "/UpdateEvaluate")
public class UpdateEvaluate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        String sender=request.getParameter("sender");
        String sendertype=request.getParameter("sendertype");
        String restuarant=request.getParameter("restuarant");
        String food=request.getParameter("food");
        String receiver=request.getParameter("receiver");
        int a=0;
        try {
            a= MySQLJDBC.updateEvaluate(id,title,content,sender,sendertype,restuarant,food,receiver);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(a==1){
            System.out.println("评价修改成功！");
        }else{
            System.out.println("评价修改失败！");
        }
    }
}
