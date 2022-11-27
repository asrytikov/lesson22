package lesson222.model;

import lesson222.services.LoggedUserManagementService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private final LoggedUserManagementService loggedUserManagementService;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService){
        this.loggedUserManagementService = loggedUserManagementService;
    }

    private String username;
    private String password;
    public boolean login(){
        String username = this.getUsername();
        String password = this.getPassword();
        if ("admin".equals(username) && "admin".equals(password)){
            loggedUserManagementService.setUsername(username);
            return true;
        }else{
            return false;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
