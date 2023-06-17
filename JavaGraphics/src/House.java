import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public class House {
    private double x;
    private double y;
    private double size;
    private Color color;

    public House(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }
    public void drawHouse(Graphics2D g2d){
        Rectangle2D.Double h = new Rectangle2D.Double(x,y,size,size);
        Rectangle2D.Double d = new Rectangle2D.Double(x + (size*0.4),y+(size * 0.7),size * 0.2,size * 0.3);
        Rectangle2D.Double w1 = new Rectangle2D.Double(x + (size * 0.1),y + (size * 0.2),size * 0.25,size * 0.25);
        Rectangle2D.Double w2 = new Rectangle2D.Double(x + (size * 0.62),y + (size * 0.2),size * 0.25,size * 0.25);
        Path2D.Double r = new Path2D.Double();
        g2d.setColor(color);
        g2d.fill(h);
        g2d.setColor(Color.BLACK);
        g2d.fill(d);
        g2d.setColor(Color.BLUE);
        g2d.fill(w1);
        g2d.fill(w2);
        g2d.setColor(Color.PINK);
        r.moveTo(x,y);
        r.lineTo(x+size/2,y-size/2);
        r.lineTo(x+size,y);
        r.closePath();
        g2d.fill(r);

        g2d.draw(r);
    }
}
