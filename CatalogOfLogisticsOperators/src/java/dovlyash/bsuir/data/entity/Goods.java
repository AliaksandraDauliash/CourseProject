package dovlyash.bsuir.data.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name = "goods")
public class Goods implements Serializable{
    
    @Id @GeneratedValue
    @Column(name = "goodsId")
    private int id;
    @Column(name = "goodsName")
    private String name;
    @Column(name = "goodsWeight")
    private double weight;
    @Column(name = "goodsVolume")
    private double volume;
    
    @ManyToOne
    @JoinColumn (name = "clientId")
    private Client client;
    
    public Goods(){
    }
    
    public Goods(int id, String name, double weight, double volume, Client client ){
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.volume = volume;
        this.client = client;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
