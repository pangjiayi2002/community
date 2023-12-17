package servlet.user;

import Pojo.Evaluate;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.evaluate.EvaluateService;
import service.evaluate.EvaluateServiceImpl;

import java.io.IOException;

@WebServlet(name = "messageServlet", value = "/messageServlet")
public class messageServlet extends HttpServlet {
    private EvaluateService evaluateService=new EvaluateServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int messageId=Integer.parseInt(request.getParameter("messageId"));
        Evaluate evaluate=evaluateService.getEvaluateDetail(messageId);
        ServletContext context= request.getServletContext();
        context.setAttribute("evaluate",evaluate);
        request.getRequestDispatcher("messageDetail.jsp").forward(request,response);
        //要将isread改成1
        boolean flag= evaluateService.setIsread(messageId);
        System.out.println(flag);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}