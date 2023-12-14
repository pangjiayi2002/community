package servlet.manager;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.manage.MySQLJDBC;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateResturantManage", value = "/UpdateResturantManage")
public class UpdateResturantManage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String restaurant=request.getParameter("restaurant");
        int a=0;
        try {
            a=MySQLJDBC.updateResturantManage(id,username,password,restaurant);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(a==1){
            System.out.println("食堂管理员修改成功！");
        }else{
            System.out.println("食堂管理员修改失败！");
        }
    }
}
