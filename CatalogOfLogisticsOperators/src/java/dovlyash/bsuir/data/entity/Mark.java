
package dovlyash.bsuir.data.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name = "mark")
public class Mark implements Serializable{
    
    @Id @GeneratedValue
    @Column(name = "markId")
    private int id;
    
    @Column(name = "markValue")
    private int value;
    
    @ManyToOne
    @JoinColumn (name = "clientId")
    private Client client;
    
    @ManyToOne
    @JoinColumn (name = "logoperatorId")
    private Logoperator logoperator;
    
    public Mark(){
        
    }
    
    public Mark(int id, int value, Client client, Logoperator logoperator){
        this.id = id;
        this.value = value;
        this.client = client;
        this.logoperator = logoperator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Logoperator getLogoperator() {
        return logoperator;
    }

    public void setLogoperator(Logoperator logoperator) {
        this.logoperator = logoperator;
    }
    
    
}
