
package dovlyash.bsuir.data.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name = "logoperator_service")
public class LogoperatorService implements Serializable{
    
    @Id @GeneratedValue
    @Column(name = "logoperator_serviceId")
    private int id;
    
    @ManyToOne
    @JoinColumn (name = "serviceId")
    private Service service;
    
    @ManyToOne
    @JoinColumn (name = "logoperatorId")
    private Logoperator logoperator;
    
     public LogoperatorService(){
    }
    
    public LogoperatorService(int id, Service service, Logoperator logoperator ){
        this.id = id;
        this.service = service;
        this.logoperator = logoperator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Logoperator getLogoperator() {
        return logoperator;
    }

    public void setLogoperator(Logoperator logoperator) {
        this.logoperator = logoperator;
    }
    
    
}
