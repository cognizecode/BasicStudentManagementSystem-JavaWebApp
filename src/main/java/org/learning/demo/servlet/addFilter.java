package org.learning.demo.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/addFilter")
public class addFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        PrintWriter out = servletResponse.getWriter();

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");

        if (id == 0 || name == null || id < 0) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else if(name.length() > 3) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            out.println("Name must be at least 3 characters");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
