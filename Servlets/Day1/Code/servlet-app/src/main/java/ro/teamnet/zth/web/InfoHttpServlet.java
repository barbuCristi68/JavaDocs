package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Cristian.Barbu on 7/18/2017.
 */
public class InfoHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> elements = req.getHeaderNames();
        resp.setContentType("text/html");
        String out = null;
        out+="<table>";
        out+="<th>Name</th>";
        out+="<th>Values</th>";

        while(elements.hasMoreElements()){
            String element = elements.nextElement();
            out +="<tr>";
            out +="<td>";
            out += element;
            out +="</td>";
            Enumeration<String> headers = req.getHeaders(element);
            while(headers.hasMoreElements()){
                String header = headers.nextElement();
                out +="<td>";
                out += header;
                out +="</td>";
            }
            out+="</tr>";
        }
        out+="</table>";

        resp.getWriter().write(out);
    }
}
