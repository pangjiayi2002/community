package servlet.user;

import Pojo.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.User.UserService;
import service.User.UserServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> userList=userService.getUserNameList();
        String userCode=request.getParameter("userCode");
        String userPassword=request.getParameter("userPassword");
        User user=new User();
        user.setUsername(userCode);
        user.setPassword(userPassword);
        if(userList.contains(userCode)){
            request.setAttribute("error","用户名重复");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }else{
            userService.add(user);
            request.getRequestDispatcher("userLogin.jsp").forward(request,response);
        }
    }
}