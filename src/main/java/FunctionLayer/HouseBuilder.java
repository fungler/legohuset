/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.List;

/**
 *
 * @author Martin
 */
public class HouseBuilder {
    
    public static House generateBricks(int h, int w, int l) {

            House house = new House(h);
        
            int lx8 = l / 4;
            int lx8r = l % 4;

            house.addLX8(lx8 * 2);

            int lx4 = lx8r / 2;
            int lx4r = lx8r % 2;

            house.addLX4(lx4 * 2);

            int lx2 = lx4r / 1;

            house.addLX1(lx2 * 2);

            int nW = w - 4;

            int wx8 = nW / 4;
            int wx8r = nW % 4;

            house.addWX8(wx8 * 2);

            int wx4 = wx8r / 2;
            int wx4r = wx8r % 2;

            house.addWX4(wx4 * 2);

            int wx2 = wx4r / 1;
            int wx2r = wx4r % 1;     

            house.addWX1(wx2* 2);  
       

        return house;
    }
}
