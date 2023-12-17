package servlet.restaurantAdmin;

import Pojo.Evaluate;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.restaurantAdmin.restaurantAdminService;
import service.restaurantAdmin.restaurantAdminServiceImpl;

import java.io.IOException;

@WebServlet(name = "ReplyServlet", value = "/ReplyServlet")
public class ReplyServlet extends HttpServlet {
    private restaurantAdminService resAdminSer=new restaurantAdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        String title=request.getParameter("replyTitle");
        String content=request.getParameter("replyContent");
        String sender= (String) session.getAttribute("sender");
        String sendertype= (String) session.getAttribute("sendertype");
        String restaurant= (String) session.getAttribute("restaurant");
        String food= (String) session.getAttribute("food");
        String receiver= (String) session.getAttribute("receiver");
        int isread=1;
        String evaluateIDStr = (String) session.getAttribute("id");
        int evaluateID = Integer.parseInt(evaluateIDStr);
        Evaluate replyEvaluate=new Evaluate(title,content,sender,sendertype,restaurant,food,receiver,isread,evaluateID);
        System.out.println(replyEvaluate.toString());
        resAdminSer.addReply(replyEvaluate);
        request.getRequestDispatcher("evaluateList.jsp").forward(request, response);
    }
}
