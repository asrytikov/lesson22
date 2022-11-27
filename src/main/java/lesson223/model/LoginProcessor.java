package lesson223.model;

import lesson223.services.LoggedUserManagementService;
import lesson223.services.LoginCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService){
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    private String username;
    private String password;
    public boolean login(){
        loginCountService.increment();
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
