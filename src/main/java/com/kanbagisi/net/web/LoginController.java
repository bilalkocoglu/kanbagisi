package com.kanbagisi.net.web;

import com.kanbagisi.net.entity.User;
import com.kanbagisi.net.services.SessionService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.*;
import java.io.IOException;

@ManagedBean(name = "login")
@RequestScoped
public class LoginController implements Filter {
    private String username;
    private String pass;

    private UIComponent loginForm;

    SessionService sessionService;

    public LoginController() {
        sessionService = new SessionService();
    }

    public String login(){
        FacesContext context = FacesContext.getCurrentInstance();
        User user = sessionService.userControl(getUsername(), getUsername());
        if (user == null){
            FacesMessage facesMessage = new FacesMessage("Kullanıcı adı veya şifre hatalı. Lütfen tekrar deneyiniz.");
            context.addMessage(loginForm.getClientId(context),facesMessage);
            return null;
        }else {
            context.getExternalContext().getSessionMap().put("onlineUser",user);
            return "admin?faces-redirect=true";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public UIComponent getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(UIComponent loginForm) {
        this.loginForm = loginForm;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
