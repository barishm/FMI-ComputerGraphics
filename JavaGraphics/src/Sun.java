import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

public class Sun {
    private  double x;
    private double y;
    private double size;
    private Color color;

    public Sun(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }
    public void drawSun(Graphics2D g2d) {
        Ellipse2D.Double sun = new Ellipse2D.Double(x,y,size ,size);
        g2d.setColor(color);
        g2d.fill(sun);
        Path2D.Double ray = new Path2D.Double();






        ray.moveTo((x+size/2)-70,(y+size/2)-70);
        ray.lineTo((x+size/2)-120,(y+size/2)-120);


        ray.moveTo((x+size/2),(y+size/2)-90);
        ray.lineTo((x+size/2),(y+size/2)-140);

        ray.moveTo((x+size/2)-90,(y+size/2));
        ray.lineTo((x+size/2)-140,(y+size/2));

        ray.moveTo((x+size/2)-70,(y+size/2)+70);
        ray.lineTo((x+size/2)-120,(y+size/2)+120);

        ray.moveTo((x+size/2),(y+size/2)+90);
        ray.lineTo((x+size/2),(y+size/2)+140);

        ray.moveTo((x+size/2)+70,(y+size/2)+70);
        ray.lineTo((x+size/2)+120,(y+size/2)+120);

        ray.moveTo((x+size/2)+90,(y+size/2));
        ray.lineTo((x+size/2)+140,(y+size/2));

        ray.moveTo((x+size/2)+70,(y+size/2)-70);
        ray.lineTo((x+size/2)+120,(y+size/2)-120);

        // rays width
        g2d.setStroke(new BasicStroke(7));

        g2d.draw(ray);




    }
}
