package warehouse.auth;

import auth.ejb.AuthenticationManager;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class AuthBean implements Serializable {
    private boolean loggedIn;

    private String login;

    public String getRequestedPage() {
        return requestedPage;
    }

    public void setRequestedPage(String requestedPage) {
        this.requestedPage = requestedPage;
    }

    String requestedPage;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    private String password;



    @EJB
    private AuthenticationManager authenticationManager;


    public void doLogin() {
        if ((StringUtils.isEmpty(login)) || (StringUtils.isEmpty(password))) {
        loggedIn = false;
        return;
        }
            loggedIn = authenticationManager.loginAsUser(login, password);

    }
}