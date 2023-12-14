package servlet.dish;

import Pojo.Dish;
import Pojo.RestaurantInfo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.dish.DishService;
import service.dish.DishServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchDishServlet", value = "/SearchDishServlet")
public class SearchDishServlet extends HttpServlet {
    DishService dishService=new DishServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //菜品综合检索
        String foodType=request.getParameter("foodtype");
        String min= request.getParameter("min");
        String max=request.getParameter("max");
        String restaurant=request.getParameter("restaurant");
        System.out.println(min+" "+max);
        System.out.println(foodType+" "+restaurant);
        if(!min.isEmpty() && !max.isEmpty() && Integer.parseInt(min)>Integer.parseInt(max)){
            request.setAttribute("priceError","最低价格不能大于最高价格！");
            request.getRequestDispatcher("userHome.jsp").forward(request,response);
        }else{
            List<Dish> dishList;
            dishList=dishService.getDishList(foodType,min,max,restaurant);
            if(dishList.isEmpty()){
                request.setAttribute("dishMessage","未检索到符合条件的菜品！");
                request.getRequestDispatcher("userHome.jsp").forward(request,response);
            }else{
                HttpSession session= request.getSession(true);
                session.setAttribute("dishList",dishList);
                request.getRequestDispatcher("researchDishResult.jsp").forward(request,response);
            }
        }

    }
}