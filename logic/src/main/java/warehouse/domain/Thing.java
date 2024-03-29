package warehouse.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Thing {
    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private int quantity;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;

    @OneToMany(mappedBy = "order")
    private List<ThingInOrder> thingInOrders;

    public List<ThingInOrder> getThingInOrders() {
        return thingInOrders;
    }

    public void setThingInOrders(List<ThingInOrder> thingInOrders) {
        this.thingInOrders = thingInOrders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
