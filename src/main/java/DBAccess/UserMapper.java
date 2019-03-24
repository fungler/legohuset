package DBAccess;

import FunctionLayer.Order;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.getConnection();
            String SQL = "INSERT INTO `user` (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.getConnection();
            String SQL = "SELECT id, role FROM User "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    public static ArrayList<Order> getAllOrders() {
        
        ArrayList<Order> allOrders = null;
        
        try {
            
            allOrders = new ArrayList();
            
            Connection con = Connector.getConnection();
            String SQL = "SELECT * FROM `order`;";
            PreparedStatement ps = con.prepareStatement( SQL );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                Order order = new Order(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("h"), rs.getInt("l"), rs.getInt("w"), rs.getBoolean("shipped"));
                allOrders.add(order);
            } 
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Could not get orders: ");
            e.printStackTrace();
        }
        
        return allOrders;
    }
    
    public static void setShippedStatus(int orderID) throws ClassNotFoundException, SQLException {
            Connection con = Connector.getConnection();
            String SQL = "UPDATE `order` SET "
		+ "`order`.shipped = ? WHERE `order`.id = ?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setBoolean( 1, true );
            ps.setInt(2, orderID);
            ps.executeUpdate();
    }
    
    public static void removeOrder(int orderID) throws ClassNotFoundException, SQLException {
            Connection con = Connector.getConnection();
            String SQL = "DELETE FROM `order` WHERE "
		+ "`order`.id = ?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt( 1, orderID );
            ps.executeUpdate();
    }
    
    public static ArrayList<Order> getUserOrders(int userID) {
        
        ArrayList<Order> userOrders = null;
        
        try {
            
            userOrders = new ArrayList();
            
            Connection con = Connector.getConnection();
            String SQL = "SELECT * FROM `order` WHERE `order`.user_id = ?;";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                Order order = new Order(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("h"), rs.getInt("l"), rs.getInt("w"), rs.getBoolean("shipped"));
                userOrders.add(order);
            } 
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Could not get orders: ");
            e.printStackTrace();
        }
        
        return userOrders;
    }

    public static void addOrder( Order order ) throws OrderException {
        try {
            Connection con = Connector.getConnection();
            String SQL = "INSERT INTO `order` (`user_id`, `h`, `l`, `w`) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt( 1, order.getUserID());
            ps.setInt( 2, order.getH() );
            ps.setInt( 3, order.getL() );
            ps.setInt( 4, order.getW() );
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            System.out.println("Could not add order to database.");
        }
    }
}
