package dovlyash.bsuir.data.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name = "client")
public class Client implements Serializable{
    
    @Id @GeneratedValue
    @Column(name = "clientId")
    private int id;
    @Column(name = "clientName")
    private String name;
    @Column(name = "clientPhone")
    private String phone;
    @Column(name = "clientEmail")
    private String email;
    @Column(name = "clientLogin")
    private String login;
    @Column(name = "clientPassword")
    private String password;
    
    public Client(){
    }
    
    public Client(int id, String name, String phone, String email, String login, String password){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    
    @Override
    public String toString() {
        return "Client{" + "name=" + name + ", phone=" + phone + ", email=" + email + '}';
    }
    
}