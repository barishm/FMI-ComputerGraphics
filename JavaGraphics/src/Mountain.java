import java.awt.*;
import java.awt.geom.Path2D;

public class Mountain {

    private double width;
    private double height;
    private Color color;

    public Mountain(double width, double height,Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void drawMountain(Graphics2D g2d){
        Path2D.Double m = new Path2D.Double();

        m.moveTo(0,height/2);
        m.curveTo(width/3,height/3,width/2,height/3,width,height/2);
        m.lineTo(width,height);
        m.lineTo(0,height);
        m.closePath();

        g2d.setColor(color);
        g2d.fill(m);
        g2d.draw(m);
    }
}
