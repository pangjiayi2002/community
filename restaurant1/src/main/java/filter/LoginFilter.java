//package filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
//@WebFilter(filterName = "LoginFilter", urlPatterns = {"*.jsp"})
//public class LoginFilter implements Filter {
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        // 获取当前用户的身份信息
//        HttpSession session = httpRequest.getSession();
//        String userRole = (String) session.getAttribute("userRole");
////        System.out.println(userRole);
//
//        // 根据用户身份进行页面访问控制
//        String requestURI = httpRequest.getRequestURI();
//
//        // 排除需要放行的页面
//        if (requestURI.endsWith("/home.jsp") || requestURI.endsWith("/adminLogin.jsp") || requestURI.endsWith("/userLogin.jsp") || requestURI.endsWith("/register.jsp") ) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        if (userRole == null) {
//            // 如果用户未登录，重定向到登录页面
//            httpResponse.sendRedirect(httpRequest.getContextPath() + "/home.jsp");
//            return;
//        }
//
//        // 根据不同的用户身份，控制页面访问
//        if (userRole.equals("restaurantAdmin") &&
//                !(
//                        requestURI.endsWith("/restaurantAdminHome.jsp") ||
//                                requestURI.endsWith("/restaurantList.jsp") ||
//                                requestURI.endsWith("/restaurantDetail.jsp") ||
//                                requestURI.endsWith("/restaurantModify.jsp") ||
//                                requestURI.endsWith("/dishList.jsp") ||
//                                requestURI.endsWith("/dishAdd.jsp") ||
//                                requestURI.endsWith("/dishModify.jsp")
//                )) {
//            httpResponse.sendRedirect(httpRequest.getContextPath() + "/home.jsp");
//            return;
//        }
//        else if (userRole.equals("user") &&
//                !(
//                        requestURI.endsWith("/userHome.jsp") ||
//                                requestURI.endsWith("/restaurantInfoDetail.jsp") ||
//                                requestURI.endsWith("/researchDishResult.jsp")
//                )) {
//            httpResponse.sendRedirect(httpRequest.getContextPath() + "/home.jsp");
//            return;
//        } else if (userRole.equals("systemAdmin") && !requestURI.endsWith("/manageHomePage.jsp")) {
//            httpResponse.sendRedirect(httpRequest.getContextPath() + "/home.jsp");
//            return;
//        }
//        // 用户身份匹配或访问首页，允许访问
//        chain.doFilter(request, response);
//    }
//
//    public void destroy() {
//    }
//}
