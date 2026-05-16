package com.example.shop.order.repository;

import com.example.shop.order.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaOrderRepository implements OrderRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Order findById(Long id){
        return em.find(Order.class,id);
    }

    @Override
    public List<Order> findAll(){
        return em.createQuery("SELECT o FROM Order o",Order.class).getResultList();
    }

    @Override
    public Order findByOrderId(String orderId){
        List<Order> result=em.createQuery(
                "SELECT o FROM Order o WHERE o.orderId=:orderId",Order.class
        ).setParameter("orderId",orderId).getResultList();

        return result.isEmpty() ? null:result.get(0);
    }

    @Override
    public void save(Order order){
        em.persist(order);
    }

    @Override
    public void deleteById(Long id){
        Order order=em.find(Order.class,id);
        em.remove(order);
    }
}
