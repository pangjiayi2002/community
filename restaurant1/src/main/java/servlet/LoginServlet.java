package servlet;

import Pojo.RestaurantInfo;
import Pojo.User;
import Pojo.restaurantAdmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.User.UserService;
import service.User.UserServiceImpl;
import service.restaurant.RestaurantService;
import service.restaurant.RestaurantServiceImpl;
import service.restaurantAdmin.restaurantAdminService;
import service.restaurantAdmin.restaurantAdminServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    restaurantAdminService resAdminService=new restaurantAdminServiceImpl();
    UserService userService=new UserServiceImpl();
    RestaurantService restaurantService=new RestaurantServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户类型（系统管理员/食堂管理员/师生用户）
        String userType=request.getParameter("userType");
        String userCode=request.getParameter("userCode");
        String userPassword=request.getParameter("userPassword");
        //调用service方法，进行用户匹配
        if(userType!=null && userType.equals("restaurantAdmin")){
            restaurantAdmin resAdmin=resAdminService.login(userCode,userPassword);
                if(null !=resAdmin){
                    //登陆成功
                    //页面重定向至食堂管理员首页
                    response.sendRedirect("");
                }else{
                    //页面转发，携带提示信息至登录界面
                    request.setAttribute("error","用户名或密码不正确");
                    request.getRequestDispatcher("adminLogin.jsp").forward(request,response);
                }
            }
        else if(userType!=null && userType.equals("systemAdmin")){
            if(userCode.equals("admin") && userPassword.equals("admin")){
                //系统管理员端登录成功
                //页面重定向至系统管理员首页
                response.sendRedirect("");
            }
        }
        else{
            //师生端
            User user=userService.login(userCode,userPassword);
            if(null!=user){
                //食堂列表存在context中
                List<RestaurantInfo> RestaurantList=restaurantService.getRestaurantList();
                ServletContext context=getServletContext();
                context.setAttribute("RestaurantList",RestaurantList);
                //登陆成功
                //页面重定向
                response.sendRedirect("userHome.jsp");
            }else{
                //页面转发，带着提示信息转发
                request.setAttribute("error","用户名或密码不正确");
                request.getRequestDispatcher("userLogin.jsp").forward(request,response);
            }
        }

    }
}