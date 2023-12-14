package servlet.dish;

import Pojo.Dish;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.dish.DishService;
import service.dish.DishServiceImpl;

import java.io.IOException;

@WebServlet(name = "dishDetailServlet", value = "/dishDetailServlet")
public class dishDetailServlet extends HttpServlet {
    DishService dishService=new DishServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dishName=request.getParameter("dishName");
        Dish dish=dishService.getDishByName(dishName);
        HttpSession session= request.getSession(true);
        session.setAttribute("dish",dish);
        request.getRequestDispatcher("dishDetail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}