/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Martin
 */
public class DeleteOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String send = "index";
        try {
        String order = request.getParameter( "order" );
        LogicFacade.removeOrder( Integer.parseInt(order) );
        send = "orderdeleted";
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        return send;
    }
    
}
