package warehouse.domain;

import warehouse.domain.ThingInOrder;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "thing")
    private List<ThingInOrder> thingInOrders;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ThingInOrder> getThingInOrders() {
        return thingInOrders;
    }

    public void setThingInOrders(List<ThingInOrder> thingInOrders) {
        this.thingInOrders = thingInOrders;
    }
}
