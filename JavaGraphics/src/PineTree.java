import java.awt.*;
import java.awt.geom.Path2D;

public class PineTree {
    private double x;
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

    public PineTree(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void drawPineTree(Graphics2D g2d) {
        g2d.setColor(new Color(102, 63, 10));
        Path2D.Double t = new Path2D.Double();
        t.moveTo(x,y);
        t.lineTo(x,y-90);
        g2d.setStroke(new BasicStroke(8));
        g2d.draw(t);
        g2d.setColor(new Color(0, 25, 0));
        Path2D.Double p1 = new Path2D.Double();
        Path2D.Double p2 = new Path2D.Double();
        Path2D.Double p3 = new Path2D.Double();
        p1.moveTo(x-90*0.5,y-90*0.3);
        p1.lineTo(x,y-90*0.8);
        p1.lineTo(x+90*0.5,y-90*0.3);
        p1.closePath();
        g2d.fill(p1);
        p2.moveTo(x-90*0.4,y-90*0.5);
        p2.lineTo(x,y-90);
        p2.lineTo(x+90*0.4,y-90*0.5);
        p2.closePath();
        g2d.fill(p2);
        p3.moveTo(x-90*0.3,y-90*0.7);
        p3.lineTo(x,y-90*1.2);
        p3.lineTo(x+90*0.3,y-90*0.7);
        p3.closePath();
        g2d.fill(p3);
    }
    public boolean contains(int x,int y){
        if(this.x - 70 < x && x < this.x + 70){
            if(this.y - 70 < y && y < this.y){
                return true;
            }
        }
        return false;
    }
}
