package servlet;

import Pojo.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.User.UserService;
import service.User.UserServiceImpl;
import service.dish.DishService;
import service.dish.DishServiceImpl;
import service.evaluate.EvaluateService;
import service.evaluate.EvaluateServiceImpl;
import service.manage.MySQLJDBC;
import service.restaurant.RestaurantService;
import service.restaurant.RestaurantServiceImpl;
import service.restaurantAdmin.restaurantAdminService;
import service.restaurantAdmin.restaurantAdminServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    restaurantAdminService resAdminService=new restaurantAdminServiceImpl();
    UserService userService=new UserServiceImpl();
    RestaurantService restaurantService=new RestaurantServiceImpl();
    DishService dishService=new DishServiceImpl();
    EvaluateService evaluateService=new EvaluateServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户类型（系统管理员/食堂管理员/师生用户）
        String userType=request.getParameter("userType");
        String userCode=request.getParameter("userCode");
        String userPassword=request.getParameter("userPassword");
        HttpSession session=request.getSession();
        session.setAttribute("userRole",userType);
        //调用service方法，进行用户匹配
        if(userType!=null && userType.equals("restaurantAdmin")){
            restaurantAdmin resAdmin=resAdminService.login(userCode,userPassword);
                if(null !=resAdmin){
                    String RestaurantName= null;
                    try {
                        RestaurantName = resAdminService.getRestaurantName(userCode);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    session.setAttribute("restaurantName",RestaurantName);
                    session.setAttribute("username",userCode);
                    session.setAttribute("sender",userCode);
                    session.setAttribute("sendertype","admin");
                    session.setAttribute("restaurant",RestaurantName);
                    //登陆成功
                    //页面重定向至食堂管理员首页
                    response.sendRedirect("restaurantAdminHome.jsp");
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
                ArrayList<RestaurantManage> rms;
                ArrayList<RestaurantInfo> rs;
                ArrayList<Evaluate> es;
                try {
                    rms=MySQLJDBC.searchResturantManage();
                    rs=MySQLJDBC.searchResturant();
                    es=MySQLJDBC.searchEvaluate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                request.setAttribute("rms",rms);
                request.setAttribute("rs",rs);
                request.setAttribute("es",es);
                RequestDispatcher rd=request.getRequestDispatcher("/manageHomePage.jsp");
                rd.forward(request,response);
            }
            else{
                //页面转发，携带提示信息至登录界面
                request.setAttribute("error","用户名或密码不正确");
                request.getRequestDispatcher("adminLogin.jsp").forward(request,response);
            }
        }
        else{
            //师生端
            User user=userService.login(userCode,userPassword);
            session.setAttribute("userName",userCode);
            session.setAttribute("userRole","user");
            if(null!=user){
                //食堂列表存在context中
                List<RestaurantInfo> RestaurantList=restaurantService.getRestaurantList();
                //ServletContext context=getServletContext();
                session.setAttribute("RestaurantList",RestaurantList);
                //菜系列表存入
                List<String> foodTypeList=dishService.getFoodTypeList();
                session.setAttribute("foodTypeList",foodTypeList);
                //未读消息数量
                int unreadCount;
                unreadCount=evaluateService.getUnReadMessageList(userCode).size();
                session.setAttribute("unreadCount",unreadCount);
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
