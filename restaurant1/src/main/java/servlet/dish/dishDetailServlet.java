package servlet.dish;

import Pojo.Dish;
import Pojo.Evaluate;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.dish.DishService;
import service.dish.DishServiceImpl;
import service.evaluate.EvaluateService;
import service.evaluate.EvaluateServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "dishDetailServlet", value = "/dishDetailServlet")
public class dishDetailServlet extends HttpServlet {
    DishService dishService=new DishServiceImpl();
    EvaluateService evaluateService=new EvaluateServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dishName=request.getParameter("dishName");
        Dish dish=dishService.getDishByName(dishName);
        List<Evaluate> evaluateList=evaluateService.getEvaluateListByDishName(dishName);
        HttpSession session= request.getSession(true);
        if(evaluateList==null){
            String evaluateMessage="-该菜品还没有任何评价-";
            session.setAttribute("evaluateMessage",evaluateMessage);
        }else{
            session.setAttribute("evaluateList",evaluateList);
        }
        session.setAttribute("dish",dish);
        request.getRequestDispatcher("dishDetail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}