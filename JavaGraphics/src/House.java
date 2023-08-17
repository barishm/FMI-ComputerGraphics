import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public class House {
    private double x;
    private double y;

    private Color color;

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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public House(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public void drawHouse(Graphics2D g2d){
        Rectangle2D.Double h = new Rectangle2D.Double(x,y,150,150);
        Rectangle2D.Double d = new Rectangle2D.Double(x + (150*0.4),y+(150 * 0.7),150 * 0.2,150 * 0.3);
        Rectangle2D.Double w1 = new Rectangle2D.Double(x + (150 * 0.1),y + (150 * 0.2),150 * 0.25,150 * 0.25);
        Rectangle2D.Double w2 = new Rectangle2D.Double(x + (150 * 0.62),y + (150 * 0.2),150 * 0.25,150 * 0.25);
        Path2D.Double r = new Path2D.Double();
        g2d.setColor(color);
        g2d.fill(h);
        g2d.setColor(Color.BLACK);
        g2d.fill(d);
        g2d.setColor(Color.BLUE);
        g2d.fill(w1);
        g2d.fill(w2);
        g2d.setColor(Color.RED);
        r.moveTo(x,y);
        r.lineTo(x+150/2,y-150/2);
        r.lineTo(x+150,y);
        r.closePath();
        g2d.fill(r);

        g2d.draw(r);
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