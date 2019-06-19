package edu.mum.tmattendancesystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Configuration
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        System.out.println("Roles authenticated: " + roles.toString());
        try{
            if (roles.contains("ADMIN")) {
                httpServletResponse.sendRedirect("/admin/home");
            } else if(roles.contains("STUDENT")) {
                httpServletResponse.sendRedirect("/studentAttendance");
            }else if (roles.contains("FACULTY"))
                httpServletResponse.sendRedirect("/faculty/home");
        } catch(Exception ex){
            httpServletResponse.sendRedirect("/access-error");
        }
    }
}
