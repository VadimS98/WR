package warehouse.domain;

import warehouse.domain.Order;
import warehouse.domain.Thing;

import javax.persistence.*;

@Entity
public class ThingInOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private warehouse.domain.Thing thing;
    @ManyToOne
    private warehouse.domain.Order order;

    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public warehouse.domain.Thing getThing() {
        return thing;
    }

    public void setThing(Thing thing) {
        this.thing = thing;
    }

    public warehouse.domain.Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}