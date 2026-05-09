package com.example.shop.order;

import com.example.shop.order.dto.OrderCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    //@Transtional
    public long createOrder(OrderCreateRequest request){
        Order existingOrder=orderRepository.findByOrderId(request.getOrderId());
        if( existingOrder!=null){
            throw new RuntimeException("이미 존재하는 주문입니다: "+request.getOrderId());
        }
        Order order=new Order(
                request.getOrderId(),
                request.getTotal_price(),
                request.getPoint_used(),
                request.getCash_amount()
        );
        orderRepository.save(order);

        return order.getId();
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        Order order =orderRepository.findById(id);
        if (order==null){
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }
        return order;
    }
    public void deleteOrder(Long id){
        Order order=orderRepository.findById(id);
        if (order==null){
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }
        orderRepository.deleteById(id);
    }
}
