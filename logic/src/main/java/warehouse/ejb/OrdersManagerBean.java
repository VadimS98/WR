package warehouse.ejb;

import warehouse.domain.Order;
import warehouse.domain.Thing;
import warehouse.domain.ThingInOrder;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class OrdersManagerBean {

    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;


    public Order createOrder(){
        Order order = new Order();
        entityManager.persist(order);

        return order;
    }



    public boolean addToOrder(long thingID, long orderID, int quantity){
        Thing thing = entityManager.find(Thing.class, thingID);
        if(thing == null){
            return false;
        }

        Order order = entityManager.find(Order.class, orderID);
        if(order == null){
            return false;
        }

        ThingInOrder thingInOrder = new ThingInOrder();
        thingInOrder.setOrder(order);
        thingInOrder.setThing(thing);
        thingInOrder.setQuantity(quantity);
        entityManager.persist(thingInOrder);

        return true;
    }
}
