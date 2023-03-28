package ua.levelup.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.levelup.entity.Order;
import java.util.Date;
import java.util.List;
@Repository
@Transactional
public class OrderRepository extends AbstractRepository{
    public List<Order> findOrders(Date dateFrom, Date dateTo, Integer room) {
        try {
            return entityManager.createQuery("SELECT o FROM Order o WHERE o.room=:room and o.dateTo>:dateFrom").setParameter("room", room).setParameter("dateFrom", dateFrom).getResultList();
        }catch (Exception e){
            return null;
        }
    }
    public Order saveOrder(Order order) {
        entityManager.persist(order);
        return order;
    }
}
