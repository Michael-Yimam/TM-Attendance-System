package edu.mum.tmattendancesystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Set;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

   /* @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Configuration
    @Order(1)
    public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.
                    authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/registration").permitAll()
                    .antMatchers("/admin/**", "/h2-console/**").hasAuthority("ADMIN").anyRequest()
                    .authenticated().and().csrf().disable().formLogin()
                    .loginPage("/login").failureUrl("/login?error=true")
                    .defaultSuccessUrl("/admin/home")
                    .usernameParameter("userName")
                    .passwordParameter("password")
                    .and().logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .deleteCookies("JSESSIONID")
                    .and().exceptionHandling()
                    .accessDeniedPage("/403")
                    .and()
                    .headers().frameOptions().sameOrigin();

            //.accessDeniedPage("/access-denied");
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring()
                    .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
            //, "/h2-console/**"
        }
    }


    @Configuration
    @Order(2)
    public static class FacultySecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.
                    authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/registration").permitAll()
                    .antMatchers("/faculty/**").hasAuthority("FACULTY").anyRequest()
                    .authenticated().and().csrf().disable().formLogin()
                    .loginPage("/login").failureUrl("/login?error=true")
                    .defaultSuccessUrl("/faculty/home")
                    .usernameParameter("userName")
                    .passwordParameter("password")
                    .and().logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .deleteCookies("JSESSIONID")
                    .and().exceptionHandling()
                    .accessDeniedPage("/403")
                    .and()
                    .headers().frameOptions().sameOrigin();

            //.accessDeniedPage("/access-denied");
        }
        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring()
                    .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
            //, "/h2-console/**"
        }
    }

    @Configuration
    @Order(3)
    public static class StudentSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.
                    authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/registration").permitAll()
                    .antMatchers("/student/**").hasAuthority("STUDENT").anyRequest()
                    .authenticated().and().csrf().disable().formLogin()
                    .loginPage("/login").failureUrl("/login?error=true")
                    .defaultSuccessUrl("/student/home")
                    .usernameParameter("userName")
                    .passwordParameter("password")
                    .and().logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .deleteCookies("JSESSIONID")
                    .and().exceptionHandling()
                    .accessDeniedPage("/403")
                    .and()
                    .headers().frameOptions().sameOrigin();

            //.accessDeniedPage("/access-denied");
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring()
                    .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
            //, "/h2-console/**"
        }
    }


*//*    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("password")
                .roles("USER");
    }*//*
*/
}
