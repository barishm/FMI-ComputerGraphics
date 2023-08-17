import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

public class Tree {
    private double size;
    private double x;
    private double y;

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

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

    public Tree(double size, double x, double y) {
        this.size = size;
        this.x = x;
        this.y = y;
    }
    public void drawTree(Graphics2D g2d) {
        Path2D.Double p = new Path2D.Double();
        p.moveTo(x,y);
        p.lineTo(x,y-size);
        p.lineTo(x+(size*0.3),y-size);
        p.lineTo(x + (size*0.3),y);
        p.closePath();
        g2d.setColor(new Color(68,38,4));
        g2d.fill(p);
        g2d.setColor(new Color(0, 84, 0));
        Ellipse2D.Double el = new Ellipse2D.Double(x-size/3,y-size-size/2,size,size);
        g2d.fill(el);

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








