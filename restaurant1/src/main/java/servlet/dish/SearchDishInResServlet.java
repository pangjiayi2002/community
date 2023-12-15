package servlet.dish;

import Pojo.Dish;
import Pojo.RestaurantInfo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.dish.DishService;
import service.dish.DishServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchDishInResServlet", value = "/SearchDishInResServlet")
public class SearchDishInResServlet extends HttpServlet {
    DishService dishService=new DishServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //食堂内部菜品检索
        String foodName=request.getParameter("queryDish");
        //食堂名
        if(!foodName.isEmpty()){
            HttpSession session= request.getSession(true);
            RestaurantInfo restaurantInfo =(RestaurantInfo) session.getAttribute("restaurantInfo");
            String restaurantName=restaurantInfo.getName();
            List<Dish> dishList;
            dishList=dishService.getDishByNameAndRes(foodName,restaurantName);
            session.setAttribute("dishList",dishList);
            request.getRequestDispatcher("researchDishResult.jsp").forward(request,response);
        }
    }
}