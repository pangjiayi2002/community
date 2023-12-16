package servlet.dish;

import Pojo.Dish;
import Pojo.Evaluate;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.dish.DishService;
import service.dish.DishServiceImpl;
import service.manage.MySQLJDBC;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "dishDetailServlet", value = "/dishDetailServlet")
public class dishDetailServlet extends HttpServlet {
    DishService dishService=new DishServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dishName=request.getParameter("dishName");
        Dish dish=dishService.getDishByName(dishName);
        HttpSession session= request.getSession(true);
        session.setAttribute("dish",dish);
        ArrayList<Evaluate> es;
        try {
            es=MySQLJDBC.searchEvaluateAlluser();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("es",es);
        request.getRequestDispatcher("dishDetail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
