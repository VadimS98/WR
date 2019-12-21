package auth.ejb;

import auth.domain.Admin;
import auth.domain.Credentials;
import auth.domain.User;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@LocalBean
@Stateless
public class AuthenticationManager {

    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public boolean loginAsUser(String email, String password) {

        if((StringUtils.isEmpty(email)) || StringUtils.isEmpty(password)){
            return false;
        }

        Credentials credentials = entityManager.find(Credentials.class , email);
        if(credentials == null)
            return false;


        if(!password.equals(credentials.getPassword())) return false;


        User user = credentials.getUser();
        if(user == null) return false;

        return true;
    }

    public boolean loginAsAdmin(String email, String password) {
        if((StringUtils.isEmpty(email)) || StringUtils.isEmpty(password)){
            return false;
        }

        Credentials credentials = entityManager.find(Credentials.class , email);
        if(credentials == null)
            return false;


        if(!password.equals(credentials.getPassword())) return false;

        Admin admin = credentials.getAdmin();
        if(admin == null) return false;

        return true;
    }
}