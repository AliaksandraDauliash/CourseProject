
package dovlyash.bsuir.data.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name = "recall")
public class Recall implements Serializable{
    
    @Id @GeneratedValue
    @Column(name = "recallId")
    private int id;
    
    @Column(name = "recallText")
    private String text;
    
    @ManyToOne
    @JoinColumn (name = "clientId")
    private Client client;
    
    @ManyToOne
    @JoinColumn (name = "logoperatorId")
    private Logoperator logoperator;
    
    public Recall(){
        
    }
    
    public Recall(int id, String text, Client client, Logoperator logoperator){
        this.id = id;
        this.text = text;
        this.client = client;
        this.logoperator = logoperator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
