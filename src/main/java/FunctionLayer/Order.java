package FunctionLayer;

public class Order {
    private int orderID;
    private int userID;
    private int h;
    private int l;
    private int w;
    private boolean shipped;

    public Order(int orderID, int userID, int h, int l, int w, boolean shipped) {
        this.orderID = orderID;
        this.userID = userID;
        this.h = h;
        this.l = l;
        this.w = w;
        this.shipped = shipped;
    }

    public Order(int userID, int h, int l, int w) {
        this.userID = userID;
        this.h = h;
        this.l = l;
        this.w = w;
    }
    
    public int getOrderID() {
        return orderID;
    }

    public int getUserID() {
        return userID;
    }

    public int getH() {
        return h;
    }

    public int getL() {
        return l;
    }

    public int getW() {
        return w;
    }

    public boolean isShipped() {
        return shipped;
    }
    
}
