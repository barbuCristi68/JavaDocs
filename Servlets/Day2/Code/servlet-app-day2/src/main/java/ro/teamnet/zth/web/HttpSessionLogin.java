package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Cristian.Barbu on 7/19/2017.
 */
public class HttpSessionLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String resp="";
        Cookie[] c = request.getCookies();
        if(username.equals("admin") && password.equals("admin"))
       {
                resp = "Welcome back " + username + " ";
                resp += request.getSession();
                response.getWriter().write(resp);
                for (Cookie cookie : c) {
                    response.getWriter().write(cookie.getName() + " " + cookie.getValue());
                }
            }
        else{

            request.getSession().setAttribute("user", username);
            request.getSession().setAttribute("session", request.getSession());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/loginFail.jsp");
                requestDispatcher.forward(request,response);

            }
    }




}
