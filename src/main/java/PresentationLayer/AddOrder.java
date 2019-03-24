/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Martin
 */
public class AddOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int user_id = user.getId();
        try {
            int h = Integer.parseInt(request.getParameter("height"));
            int l = Integer.parseInt(request.getParameter("length"));
            int w = Integer.parseInt(request.getParameter("width"));            
            LogicFacade.addOrder(new Order(user_id, h, l, w));
        } catch (NumberFormatException | OrderException e) {
            return "customerpage";
        }
        return "orderadded";
    }
    
}
