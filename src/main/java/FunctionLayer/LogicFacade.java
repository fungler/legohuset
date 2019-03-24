package FunctionLayer;

import DBAccess.UserMapper;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

    public static ArrayList<Order> getAllOrders() {
        return UserMapper.getAllOrders();
    }
    
    public static void setShippedStatus(int orderid) throws ClassNotFoundException, SQLException {
        UserMapper.setShippedStatus(orderid);
    }
    
    public static void removeOrder(int orderID) throws ClassNotFoundException, SQLException {
        UserMapper.removeOrder(orderID);
    }
    
    public static ArrayList<Order> getUserOrders(int orderID) {
        return UserMapper.getUserOrders(orderID);
    }
    
    public static void addOrder(Order order) throws OrderException {
        UserMapper.addOrder(order);
    }
}
