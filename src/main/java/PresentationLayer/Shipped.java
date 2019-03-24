package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Shipped extends Command {
    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        
        String send = "index";
        String order = request.getParameter( "order" );
        
        try {
            LogicFacade.setShippedStatus( Integer.parseInt(order) );
            send = "shippedChanged";
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return send;
    }}

