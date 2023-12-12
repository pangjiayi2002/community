package servlet.restaurantAdmin;

import Pojo.Dish;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.restaurantAdmin.restaurantAdminService;
import service.restaurantAdmin.restaurantAdminServiceImpl;

import java.io.IOException;

@WebServlet(name = "DishAddServlet", value = "/DishAddServlet")
public class DishAddServlet extends HttpServlet {
    private restaurantAdminService resAdminSer=new restaurantAdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String foodtype = request.getParameter("foodtype");
        Float price= Float.valueOf(request.getParameter("price"));
        String cover= "dish/" +request.getParameter("cover");
        String restaurantName=request.getParameter("restaurantName");
        Dish dish=new Dish(name,foodtype,price,cover,restaurantName);
        System.out.println(dish.toString());;
        resAdminSer.addDish(dish);
        request.getRequestDispatcher("dishList.jsp").forward(request,response);
    }
}
