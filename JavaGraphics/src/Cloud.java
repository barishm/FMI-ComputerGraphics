import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Cloud {

    private  double x;
    private double y;


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Cloud(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void drawCloud(Graphics2D g2d) {
        Ellipse2D.Double e1 = new Ellipse2D.Double(x,y,80 ,80);
        Ellipse2D.Double e2 = new Ellipse2D.Double(x+80*.35,y-80*.2,80*1.75 ,80*1.4);
        Ellipse2D.Double e3 = new Ellipse2D.Double(x+80*1.5,y+80*.15,80*.9 ,80*.9);
        Ellipse2D.Double e4 = new Ellipse2D.Double(x+80*1.8,y+80*.05,80*.05 ,80*.3);
        g2d.setColor(Color.white);
        g2d.fill(e1);
        g2d.fill(e2);
        g2d.fill(e3);
        g2d.fill(e4);
    }
    public boolean contains(int x,int y){
        if(this.x < x && x < this.x + 100){
            if(this.y < y && y < this.y + 100){
                return true;
            }
        }
        return false;
    }
}
