package servlet.manager;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.manage.MySQLJDBC;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteResturantManage", value = "/DeleteResturantManage")
public class DeleteResturantManage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        int a=0;
        try {
            a=MySQLJDBC.deleteResturantManage(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(a==1){
            System.out.println("食堂管理员删除成功！");
        }else{
            System.out.println("食堂管理员删除失败！");
        }
    }
}
