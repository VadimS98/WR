package auth.domain;

import auth.domain.Admin;
import auth.domain.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Credentials {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public auth.domain.User getUser() {
        return User;
    }

    public void setUser(auth.domain.User user) {
        User = user;
    }

    @Id
    private String email;
    private String password;


    @OneToOne
    private Admin admin;
    @OneToOne
    private User User;
}