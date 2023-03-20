import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Sky {
    private double x;
    private double y;
    private double w;
    private double h;
    private Color color;

    public Sky(double x, double y, double w,double h, Color color) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }
    public void drawSky(Graphics2D g2d) {
        Rectangle2D.Double r = new Rectangle2D.Double(x,y,w,h);
        g2d.setColor(color);
        g2d.fill(r);
    }
}
