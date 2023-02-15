package com.example.week6_day2_security.service;

import com.example.week6_day2_security.model.Order;
import com.example.week6_day2_security.model.Product;
import com.example.week6_day2_security.model.User;
import com.example.week6_day2_security.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrdersRepository orderRepository;
    private final ProductService productService;
    private final UserService userService;

    public Set<Order> getOrders(User user){
        return userService.getUserById(user, user.getId()).getOrders();
    }

    public void OrderAProduct(User user, String productName, int quantity){
        Product product = productService.findProductByName(productName);
        Order order = new Order(null,(quantity*product.getPrice()),new Date(),quantity,"new",user,product);
        Order order1 = new Order()
        orderRepository.save(order);
    }

    public void updateOrderStatus(UUID id, String status){
        Order order = orderRepository.findOrderById(id);
        if (order == null)
            throw new ApiException("ID not found");
        order.setStatus(status);
        orderRepository.save(order);
    }

    public void deleteOrder(User user, UUID order_id){
        Order order = orderRepository.findOrderById(order_id);
        if (order == null)
            throw new ApiException("ID not found");
        if (!(order.getUser().getId().equals(user.getId())))
            throw new ApiException("You are not authorized to delete this order");
        if (!(order.getStatus().equals("new")))
            throw new ApiException("you cannot delete the order because the order is " + order.getStatus());
        orderRepository.delete(order);
    }

    public Order getOrderById(User user,UUID id){
        Order order = orderRepository.findOrderById(id);
        if (order == null)
            throw new ApiException("ID not found");
        if (user.getRole().equals("ADMIN"))
            return order;
        if (!(order.getUser().getId().equals(user.getId())))
            throw new ApiException("You are not authorized to view this order");
        return order;
    }
}
