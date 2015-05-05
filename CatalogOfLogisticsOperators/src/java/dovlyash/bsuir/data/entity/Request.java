
package dovlyash.bsuir.data.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

@Entity
@Table (name = "request")
public class Request implements Serializable{
    
    @Id @GeneratedValue
    @Column(name = "requestId")
    private int id;
    
    @Column(name = "requestDate")
    private Date date;
    
    @OneToOne
    @JoinColumn (name = "goodsId")
    private Goods goods;
    
    @ManyToOne
    @JoinColumn (name = "logoperatorId")
    private Logoperator logoperator;
    
    @ManyToOne
    @JoinColumn (name = "serviceId")
    private Service service;
    
    public Request(){
        
    }

    public Request(int id, Date date, Goods goods, Logoperator logoperator, Service service) {
        this.id = id;
        this.date = date;
        this.goods = goods;
        this.logoperator = logoperator;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Logoperator getLogoperator() {
        return logoperator;
    }

    public void setLogoperator(Logoperator logoperator) {
        this.logoperator = logoperator;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

   
}

