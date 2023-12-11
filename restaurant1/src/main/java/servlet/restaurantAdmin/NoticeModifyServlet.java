package servlet.restaurantAdmin;

import Pojo.RestaurantInfo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.restaurantAdmin.restaurantAdminService;
import service.restaurantAdmin.restaurantAdminServiceImpl;

import java.io.IOException;

@WebServlet(name = "NoticeModifyServlet", value = "/NoticeModifyServlet")
public class NoticeModifyServlet extends HttpServlet {
    private restaurantAdminService resAdminSer=new restaurantAdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String introduction = request.getParameter("introduction");
        String cover = request.getParameter("cover");
        String location = request.getParameter("location");
        String time=request.getParameter("time");
        RestaurantInfo info=new RestaurantInfo(id,name,introduction,cover,location,time);
        System.out.println(info.toString());
        resAdminSer.modify(info);
        request.getRequestDispatcher("restaurantList.jsp").forward(request,response);
    }
}
