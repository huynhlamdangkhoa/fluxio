package dao;

import model.Order;
import java.util.Date;
import java.util.List;

public interface OrderDAO extends GenericDAO<Order, Long>{
    List<Order> findByDateRange(Date start, Date end);
    List<Order> findByStatus(String status);
}
package service;
import dao.OrderDAO;
import model.Order;
import java.util.Date;
import java.util.List;

public class OrderService{
    private final OrderDAO orderDAO;
    public OrderService(OrderDAO orderDAO){
        this.orderDAO = orderDAO;
    }
    public boolean addOrder(Order order){
        if (isValidOrder(order)) {
            orderDAO.insert(order);
            return true;
        }
        return false;
    }
    public boolean updateOrder(Order order){
        if(order != null && order.getId() != null){
            orderDAO.update(order);
            return true;
        }
        return false;
    }
    public boolean deleteOrder(Long id){
        return orderDAO.delete(id) > 0;
    }
    public List<Order> getAllOrders(){
        return orderDAO.findAll();
    }
    public Order getOrderById(Long id){
        return orderDAO.findById(id);
    }
    public List<Order> getOrdersByDateRange(Date start, Date end){
        return orderDAO.findByDateRange(start, end);
    }
    public List<Order> getOrdersByStatus(String status){
        return orderDAO.findByStatus(status);
    }
    private boolean isValidOrder(Order order){
        return order != null && order.getCustomerId() != null && !order.getItems().isEmpty();
    }
}
