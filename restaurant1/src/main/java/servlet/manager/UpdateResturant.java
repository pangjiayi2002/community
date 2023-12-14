package servlet.manager;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.manage.MySQLJDBC;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateResturant", value = "/UpdateResturant")
public class UpdateResturant extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        String username=request.getParameter("name");
        String introduction=request.getParameter("introduction");
        String cover=request.getParameter("cover");
        String location=request.getParameter("location");
        String time=request.getParameter("time");
        int a=0;
        try {
            a= MySQLJDBC.updateResturant(id,username,introduction,cover,location,time);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(a==1){
            System.out.println("食堂修改成功！");
        }else{
            System.out.println("食堂修改失败！");
        }
    }
}
