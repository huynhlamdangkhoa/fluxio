package service;

import DAO.OrderDAO;
import model.Order;
import java.time.LocalDateTime;
import java.util.List;

public class OrderService {
    private final OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public boolean addOrder(Order order) {
        if (isValidOrder(order)) {
            orderDAO.insert(order);
            return true;
        }
        return false;
    }

    public boolean updateOrder(Order order) {
        if (order != null && order.getOrderId() > 0) {
            orderDAO.update(order);
            return true;
        }
        return false;
    }

    public boolean deleteOrder(int orderId) {
        return orderDAO.delete(orderId) > 0;
    }

    public List<Order> getAllOrders() {
        return orderDAO.findAll();
    }

    public Order getOrderById(int orderId) {
        return orderDAO.findById(orderId);
    }

    public List<Order> getOrdersByDateRange(LocalDateTime start, LocalDateTime end) {
        return orderDAO.findByDateRange(start, end);
    }

    public List<Order> getOrdersByStatus(String status) {
        return orderDAO.findByStatus(status);
    }

    private boolean isValidOrder(Order order) {
        return order != null
                && order.getTotalAmount() > 0
                && order.getOrderDate() != null
                && order.getShippingAddress() != null && !order.getShippingAddress().isEmpty()
                && order.getPaymentMethod() != null && !order.getPaymentMethod().isEmpty();
    }
}