import java.awt.*;
import java.awt.geom.Path2D;

public class PineTree {
    private double size;
    private double x;
    private double y;

    public PineTree(double size, double x, double y) {
        this.size = size;
        this.x = x;
        this.y = y;
    }

    public void drawPineTree(Graphics2D g2d) {
        g2d.setColor(new Color(102, 63, 10));
        Path2D.Double t = new Path2D.Double();
        t.moveTo(x,y);
        t.lineTo(x,y-size);
        g2d.setStroke(new BasicStroke(8));
        g2d.draw(t);
        g2d.setColor(new Color(0, 25, 0));
        Path2D.Double p1 = new Path2D.Double();
        Path2D.Double p2 = new Path2D.Double();
        Path2D.Double p3 = new Path2D.Double();
        p1.moveTo(x-size*0.5,y-size*0.3);
        p1.lineTo(x,y-size*0.8);
        p1.lineTo(x+size*0.5,y-size*0.3);
        p1.closePath();
        g2d.fill(p1);
        p2.moveTo(x-size*0.4,y-size*0.5);
        p2.lineTo(x,y-size);
        p2.lineTo(x+size*0.4,y-size*0.5);
        p2.closePath();
        g2d.fill(p2);
        p3.moveTo(x-size*0.3,y-size*0.7);
        p3.lineTo(x,y-size*1.2);
        p3.lineTo(x+size*0.3,y-size*0.7);
        p3.closePath();
        g2d.fill(p3);
    }
}
