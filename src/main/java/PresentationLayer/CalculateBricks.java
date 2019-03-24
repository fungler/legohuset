/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.House;
import FunctionLayer.HouseBuilder;
import FunctionLayer.LoginSampleException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Martin
 */
public class CalculateBricks extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        House h = HouseBuilder.generateBricks(Integer.parseInt(request.getParameter("height")), Integer.parseInt(request.getParameter("width")), Integer.parseInt(request.getParameter("length")));
        request.setAttribute("house", h);
        return "calcbricks";
    }
    
}
