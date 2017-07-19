package ro.teamnet.zth.web;

import ro.teamnet.zth.file.LogFileWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Cristian.Barbu on 7/19/2017.
 */
public class HeadersLogFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        LogFileWriter log = new LogFileWriter();

        HttpServletRequest request = (HttpServletRequest) req;
        Enumeration names = request.getHeaderNames();
        while(names.hasMoreElements()){
            String name = (String) names.nextElement();
            log.logHeader(name, request.getHeader(name));
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
