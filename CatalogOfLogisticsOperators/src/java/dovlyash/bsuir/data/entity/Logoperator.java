package dovlyash.bsuir.data.entity;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table (name = "logoperator")
public class Logoperator implements Serializable{
    @Id @GeneratedValue
    @Column(name = "logoperatorId")
    private int id;
    @Column(name = "logoperatorName")
    private String name;
    @Column(name = "logoperatorAdress")
    private String adress;
    @Column(name = "logoperatorPhone")
    private String phone;
    @Column(name = "logoperatorEmail")
    private String email;
    @Column(name = "logoperatorContactName")
    private String contactName;
    @Column(name = "logoperatorDescription")
    private String description;
    @Column(name = "logoperatorLogin")
    private String login;
    @Column(name = "logoperatorPassword")
    private String password;
    
    public Logoperator(){
    }
    
    public Logoperator(int id, String name, String adress, String phone, String email, String contactName, String description, String login, String password){
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
        this.contactName = contactName;
        this.description = description;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    
}
