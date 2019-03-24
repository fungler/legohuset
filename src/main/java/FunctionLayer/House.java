/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Martin
 */
public class House {

    private int lx8 = 0;
    private int lx4 = 0;
    private int lx1 = 0;
    
    private int wx8 = 0;
    private int wx4 = 0;
    private int wx1 = 0;
    
    private int height = 0;
    
    public House(int height) {
        this.height = height;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void addLX8(int amount){
        lx8 = lx8 + amount;
    }
    
    public void addLX4(int amount){
        lx4 = lx4 + amount;
    }
    
    public void addLX1(int amount){
        lx1 = lx1 + amount;
    }
    
    public void addWX8(int amount){
        wx8 = wx8 + amount;
    }
    
    public void addWX4(int amount){
        wx4 = wx4 + amount;
    }
    
    public void addWX1(int amount){
        wx1 = wx1 + amount;
    }
    
    public int getLx8() {
        return lx8;
    }

    public int getLx4() {
        return lx4;
    }

    public int getLx1() {
        return lx1;
    }

    public int getWx8() {
        return wx8;
    }

    public int getWx4() {
        return wx4;
    }

    public int getWx1() {
        return wx1;
    }

    public void setLx8(int lx8) {
        this.lx8 = lx8;
    }

    public void setLx4(int lx4) {
        this.lx4 = lx4;
    }

    public void setLx1(int lx1) {
        this.lx1 = lx1;
    }

    public void setWx8(int wx8) {
        this.wx8 = wx8;
    }

    public void setWx4(int wx4) {
        this.wx4 = wx4;
    }

    public void setWx1(int wx1) {
        this.wx1 = wx1;
    }



    
}
