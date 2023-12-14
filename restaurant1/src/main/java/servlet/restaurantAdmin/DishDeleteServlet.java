package servlet.restaurantAdmin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.restaurantAdmin.restaurantAdminService;
import service.restaurantAdmin.restaurantAdminServiceImpl;

import java.io.IOException;

@WebServlet(name = "DishDeleteServlet", value = "/DishDeleteServlet")
public class DishDeleteServlet extends HttpServlet {
    private restaurantAdminService resAdminSer=new restaurantAdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id");
        System.out.println(id);
        resAdminSer.deleteById(id);
        request.getRequestDispatcher("dishList.jsp").forward(request,response);

    }
}
