package servlet.restaurantAdmin;

import Pojo.Dish;
import Pojo.RestaurantInfo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.restaurantAdmin.restaurantAdminService;
import service.restaurantAdmin.restaurantAdminServiceImpl;

import java.io.IOException;

@WebServlet(name = "DishModifyServlet", value = "/DishModifyServlet")
public class DishModifyServlet extends HttpServlet {
    private restaurantAdminService resAdminSer=new restaurantAdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String foodtype = request.getParameter("foodtype");
        Float price = Float.valueOf(request.getParameter("price"));
        String cover = "dish/"+request.getParameter("cover");
        String restaurantName=request.getParameter("restaurantName");
        Dish dish=new Dish(id,name,foodtype,price,cover,restaurantName);
        System.out.println(dish.toString());
        try {
            resAdminSer.modifyDish(dish);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("dishList.jsp").forward(request,response);

    }
}
