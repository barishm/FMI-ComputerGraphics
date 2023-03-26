import java.awt.*;
import java.awt.geom.Path2D;

public class Ground {
    private double width;
    private double height;

    public Ground(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void drawGround(Graphics2D g2d){
        Path2D.Double g = new Path2D.Double();
        g.moveTo(0,height * 0.8);
        g.lineTo(width,height * 0.8);
        g.lineTo(width,height);
        g.lineTo(0,height);
        g.closePath();
        g2d.setColor(Color.DARK_GRAY);
        g2d.fill(g);


    }
}
