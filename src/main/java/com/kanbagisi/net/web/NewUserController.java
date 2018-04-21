package com.kanbagisi.net.web;

import com.kanbagisi.net.entity.User;
import com.kanbagisi.net.services.NewUserService;
import com.kanbagisi.net.services.PagesLoadService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ManagedBean(name = "newUser")
public class NewUserController {
    private String newUserName,newUserSurname,newUserSystemName,newUserTel,newSystemPas,newSystemPassAgain,newUserCityId;

    private Map<String,Integer> allCityMap = PagesLoadService.allCityMap;

    private NewUserService newUserService = new NewUserService();

    private UIComponent messageForm;

    FacesMessage facesMessage;

    public String hello(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        User user = new User(getNewUserName(),getNewUserSurname(),getNewUserTel(),getNewUserSystemName(),getNewSystemPas());
        if (newUserService.createNewUser(user, Integer.parseInt(newUserCityId))){
            System.out.println("kullanıcı oluşturuldu");
            facesMessage = new FacesMessage("Kullanıcı Ouşturuldu. Artık sisteme giriş yapabilirsiniz.");
            facesContext.addMessage(messageForm.getClientId(facesContext), facesMessage);
            return null;
        }else {
            System.out.println("error");
            facesMessage = new FacesMessage("Belirlenemeyen bir sebepten dolayı kullanıcı oluşturulamadı, üzgünüz.");
            facesContext.addMessage(messageForm.getClientId(facesContext), facesMessage);
            return "deneme?faces-redirect=true";
        }
    }

    public void validatePassword(ComponentSystemEvent event){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIComponent components = event.getComponent();

        UIInput uiInputName = (UIInput) components.findComponent("newUserName");
        String name = uiInputName.getLocalValue() == null ? "" : uiInputName.getLocalValue().toString();

        UIInput uiInputSurname = (UIInput) components.findComponent("newUserSurname");
        String surname = uiInputSurname.getLocalValue() == null ? "" : uiInputSurname.getLocalValue().toString();

        UIInput uiInputSystemName = (UIInput) components.findComponent("newUserSystemName");
        String systemName = uiInputSystemName.getLocalValue() == null ? "" : uiInputSystemName.getLocalValue().toString();

        UIInput uiInputTel = (UIInput) components.findComponent("newUserTel");
        String telephone = uiInputTel.getLocalValue() == null ? "" : uiInputTel.getLocalValue().toString();

        UIInput uiInputPass = (UIInput) components.findComponent("newSystemPas");
        String password = uiInputPass.getLocalValue() == null ? "" : uiInputPass.getLocalValue().toString();

        UIInput uiInputPassAgain = (UIInput) components.findComponent("newSystemPassAgain");
        String passwordAgain = uiInputPassAgain.getLocalValue() == null ? "" : uiInputPassAgain.getLocalValue().toString();

        UIComponent newUserForm = components.findComponent("newUserForm");      //mesajların verilecegi bilesen
        String newUserFormID = newUserForm.getClientId();

        if (name.equals("") || surname.equals("") || systemName.equals("") || telephone.equals("") || password.equals("") || passwordAgain.equals("")){
            facesMessage = new FacesMessage("Kayıt oluşturabilmek için tüm alanları doldurmanız gerekir.");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(newUserFormID,facesMessage);
            facesContext.renderResponse();
        }
        String telNoPattern = "^(05)[0-9][0-9][1-9]([0-9]){6}$";
        Pattern patternObject = Pattern.compile(telNoPattern);
        Matcher matcherObject = patternObject.matcher(telephone);
        if (!matcherObject.matches()){
            facesMessage = new FacesMessage("Hatalı bir telefon numarası girdiniz.(05xxxxxxxxx şeklinde girmeniz gerekir.)");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(newUserFormID,facesMessage);
            facesContext.renderResponse();
        }
        if (!password.equals(passwordAgain)){
            facesMessage = new FacesMessage("Girdiğiniz şifreler uyuşmamakta lütfen tekrar deneyiniz.");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(newUserFormID,facesMessage);
            facesContext.renderResponse();
        }
    }

    public String getNewSystemPas() {
        return newSystemPas;
    }

    public void setNewSystemPas(String newSystemPas) {
        this.newSystemPas = newSystemPas;
    }

    public String getNewSystemPassAgain() {
        return newSystemPassAgain;
    }

    public void setNewSystemPassAgain(String newSystemPassAgain) {
        this.newSystemPassAgain = newSystemPassAgain;
    }

    public Map<String, Integer> getAllCityMap() {
        return allCityMap;
    }

    public void setAllCityMap(Map<String, Integer> allCityMap) {
        this.allCityMap = allCityMap;
    }


    public String getNewUserName() {
        return newUserName;
    }

    public void setNewUserName(String newUserName) {
        this.newUserName = newUserName;
    }

    public String getNewUserSurname() {
        return newUserSurname;
    }

    public void setNewUserSurname(String newUserSurname) {
        this.newUserSurname = newUserSurname;
    }

    public String getNewUserSystemName() {
        return newUserSystemName;
    }

    public void setNewUserSystemName(String newUserSystemName) {
        this.newUserSystemName = newUserSystemName;
    }

    public String getNewUserTel() {
        return newUserTel;
    }

    public void setNewUserTel(String newUserTel) {
        this.newUserTel = newUserTel;
    }

    public String getNewUserCityId() {
        return newUserCityId;
    }

    public void setNewUserCityId(String newUserCityId) {
        this.newUserCityId = newUserCityId;
    }

    public UIComponent getMessageForm() {
        return messageForm;
    }

    public void setMessageForm(UIComponent messageForm) {
        this.messageForm = messageForm;
    }
}
