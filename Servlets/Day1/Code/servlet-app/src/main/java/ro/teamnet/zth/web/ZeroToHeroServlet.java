package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Cristian.Barbu on 7/18/2017.
 */
public class ZeroToHeroServlet extends HttpServlet{
    private String handleRequest(HttpServletRequest req){

        String firstName="";
        firstName = req.getParameter("firstName");
        String lastName="";
        lastName = req.getParameter("lastName");

        String response = "Hello <b>" + firstName + " "  + lastName + " </b>! Enjoy Zero To Hero!!!";

        return response;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        resp.getWriter().write(handleRequest(req));
    }
}
