package filters;

import models.Singltone;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MyFilter implements Filter {

    private Singltone setIds;

    public void init(FilterConfig config) throws ServletException {
        setIds = Singltone.getInstance();
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) resp;

        String uuid = null;
        Cookie[] cookies = httpReq.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies)
                if ((cookie.getName()).equals("sessionId"))
                    uuid = cookie.getValue();

        String[] addr = httpReq.getRequestURI().split("/");

        if (setIds.containsSessionId(uuid)) {
            if (!addr[addr.length - 1].equals("hello_inside.html") && addr[addr.length - 1].equals("count_to_get_in.jsp"))
                httpReq.getRequestDispatcher("/hello_inside.html").forward(req, resp);
            else
                chain.doFilter(req, resp);
        } else {
            if (!addr[addr.length - 1].equals("count_to_get_in.jsp") && addr[addr.length - 1].equals("hello_inside.html"))
               // httpRes.sendRedirect(httpReq.getContextPath() + "/servlets.MainServlet/count_to_get_in.jsp");
                httpReq.getRequestDispatcher("/servlets.MainServlet").forward(req, resp);
            else
                chain.doFilter(req, resp);
        }
        RequestDispatcher dispatcher = httpReq.getRequestDispatcher("/servlets.MainServlet");
        dispatcher.forward(httpReq,httpRes);
    }
}