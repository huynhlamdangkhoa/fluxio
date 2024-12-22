package service;

import DAO.OrderDAO;
import model.Order;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class OrderService {
    private final OrderDAO orderDAO;

    public OrderService() {
        this.orderDAO = OrderDAO.getInstance();
    }

    public boolean addOrder(Order order) {
        if (isValidOrder(order)) {
            return orderDAO.insert(order) > 0;
        }
        return false;
    }

    public boolean updateOrder(Order order) {
        if (order != null && order.getOrderId() > 0) {
            return orderDAO.update(order) > 0;
        }
        return false;
    }

    public boolean deleteOrder(Order order) {
        if (order != null && order.getOrderId() > 0) {
            return orderDAO.delete(order) > 0;
        }
        return false;
    }

    public ArrayList<Order> getAllOrders() {
        return orderDAO.selectAll();
    }

    public Order getOrderById(int orderId) {
        if (orderId > 0) {
            Order order = new Order(orderId, 0.0, null, null, null, null); // Assuming other fields can be null or default
            return orderDAO.selectById(order);
        }
        return null; 
    }

    private boolean isValidOrder(Order order) {
        return order != null
                && order.getTotalAmount() > 0
                && order.getOrderDate() != null
                && order.getShippingAddress() != null && !order.getShippingAddress().isEmpty()
                && order.getPaymentMethod() != null && !order.getPaymentMethod().isEmpty();
    }
}
