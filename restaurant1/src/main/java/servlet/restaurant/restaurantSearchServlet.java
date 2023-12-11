package servlet.restaurant;

import Pojo.RestaurantInfo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.restaurant.RestaurantService;
import service.restaurant.RestaurantServiceImpl;

import java.io.IOException;

@WebServlet(name = "restaurantSearchServlet", value = "/restaurantSearchServlet")
public class restaurantSearchServlet extends HttpServlet {
    RestaurantService restaurantService=new RestaurantServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String restaurantName=request.getParameter("restaurantName");//查找的食堂名
        System.out.println(restaurantName);

        RestaurantInfo restaurantInfo=restaurantService.getRestaurantByName(restaurantName);
        if(restaurantInfo!=null){
            //查到了食堂
            HttpSession session=request.getSession(true);
            session.setAttribute("restaurantInfo",restaurantInfo);
            //跳转到食堂详情页
            request.getRequestDispatcher("restaurantInfoDisplay.jsp").forward(request,response);
        }else
        {
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}