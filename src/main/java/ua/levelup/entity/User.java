package ua.levelup.entity;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "hotel_hanna")
public class User {
    @Id
    @GeneratedValue(generator = "native")
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;


    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getLogin() {
        return login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }


}
