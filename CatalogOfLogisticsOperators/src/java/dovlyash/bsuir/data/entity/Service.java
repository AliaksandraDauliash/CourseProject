
package dovlyash.bsuir.data.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name = "service")
public class Service implements Serializable{
    
  @Id @GeneratedValue
  @Column(name = "serviceId")
  private int id;
  @Column(name = "serviceName")
  private String name;
  
   public Service(){
    }
    
    public Service(int id, String name){
        this.id = id;
        this.name = name;
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
    
    
}
