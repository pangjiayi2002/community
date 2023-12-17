package servlet.user;

import Pojo.Evaluate;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.evaluate.EvaluateService;
import service.evaluate.EvaluateServiceImpl;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "unreadMessageServlet", value = "/unreadMessageServlet")
public class unreadMessageServlet extends HttpServlet {
    private EvaluateService evaluateService=new EvaluateServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession(true);
        String username=(String)session.getAttribute("userName");//获取用户名
        //未读列表
        ArrayList<Evaluate> unreadMessageList= (ArrayList<Evaluate>) evaluateService.getUnReadMessageList(username);
        //session.setAttribute("unreadMessageList",unreadMessageList);
        ServletContext context= request.getServletContext();
        context.setAttribute("unreadMessageList",unreadMessageList);
        System.out.println(unreadMessageList.size());
        if(unreadMessageList.size()==0){
            //无未读消息
            context.setAttribute("listMessage1","无未读消息");
        }else{
            context.setAttribute("unreadCount",unreadMessageList.size());
        }

        //已读列表
        ArrayList<Evaluate> readMessageList= (ArrayList<Evaluate>) evaluateService.getReadMessageList(username);
        context.setAttribute("readMessageList",readMessageList);
        request.getRequestDispatcher("messageList.jsp").forward(request,response);
        System.out.println(readMessageList.size());
        System.out.println(readMessageList.get(0).getSender());
        if(readMessageList.size()==0){
            context.setAttribute("listMessage2","无已读消息");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}