package com.ks.baseball.intercepter;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

    private static final String urlCheck          = "/fmsys/login";
    private static final String urlCheckResources = "/fmsys/resources";
    private static final String urlPwReissue      = "/fmsys/pwReissue";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object Handler) throws Exception {
        HttpSession session = request.getSession(false);

        if (request.getRequestURI().toString().equals(urlCheck)
            || request.getRequestURI().toString().equals(urlPwReissue)
            || request.getRequestURI().toString().startsWith(urlCheckResources)) {
            return true;
        }

        if (session == null) {
            alertAndRedirect(response);
            return false;
        }

        String memberNumber = (String) session.getAttribute("memberNumber");

        if (memberNumber == null) {
            alertAndRedirect(response);
            return false;
        }

        return true;
    }

    private void alertAndRedirect(HttpServletResponse response) throws Exception {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter printwriter = response.getWriter();
        printwriter.print("<script>alert('???'); location.href='/fmsys/login';</script>");
        printwriter.flush();
        printwriter.close();
    }
}