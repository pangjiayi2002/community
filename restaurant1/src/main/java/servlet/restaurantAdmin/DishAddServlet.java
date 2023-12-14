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
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String foodtype = request.getParameter("foodtype");
        String priceStr = request.getParameter("price");
        String cover = "dish/" + request.getParameter("cover");
        String restaurantName = request.getParameter("restaurantName");
        // 检查菜品信息是否完整
        if (name != null && !name.isEmpty() &&
                foodtype != null && !foodtype.isEmpty() &&
                priceStr != null && !priceStr.isEmpty() &&
                cover != null && !cover.isEmpty() &&
                restaurantName != null && !restaurantName.isEmpty()) {
            try {
                // 解析价格
                Float price = Float.parseFloat(priceStr);
                // 创建菜品对象
                Dish dish = new Dish(name, foodtype, price, cover, restaurantName);
                System.out.println(dish.toString());
                resAdminSer.addDish(dish);
                request.getRequestDispatcher("dishList.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                // 处理价格无效的情况
                request.setAttribute("errorMessage", "价格无效，请输入有效的价格。");
                request.getRequestDispatcher("").forward(request, response);
            }
        } else {
            // 菜品信息不完整，显示错误消息
            request.setAttribute("errorMessage", "添加的菜品信息不能为空，请补全信息。");
            request.getRequestDispatcher("").forward(request, response);
        }
    }


}
