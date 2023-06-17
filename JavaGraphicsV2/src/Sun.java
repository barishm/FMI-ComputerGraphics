import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

public class Sun {
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

    public Sun(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void drawSun(Graphics2D g2d) {
        Ellipse2D.Double sun = new Ellipse2D.Double(x,y,100 ,100);
        g2d.setColor(Color.YELLOW);
        g2d.fill(sun);
        Path2D.Double ray = new Path2D.Double();






        ray.moveTo((x+100/2)-70,(y+100/2)-70);
        ray.lineTo((x+100/2)-120,(y+100/2)-120);


        ray.moveTo((x+100/2),(y+100/2)-90);
        ray.lineTo((x+100/2),(y+100/2)-140);

        ray.moveTo((x+100/2)-90,(y+100/2));
        ray.lineTo((x+100/2)-140,(y+100/2));

        ray.moveTo((x+100/2)-70,(y+100/2)+70);
        ray.lineTo((x+100/2)-120,(y+100/2)+120);

        ray.moveTo((x+100/2),(y+100/2)+90);
        ray.lineTo((x+100/2),(y+100/2)+140);

        ray.moveTo((x+100/2)+70,(y+100/2)+70);
        ray.lineTo((x+100/2)+120,(y+100/2)+120);

        ray.moveTo((x+100/2)+90,(y+100/2));
        ray.lineTo((x+100/2)+140,(y+100/2));

        ray.moveTo((x+100/2)+70,(y+100/2)-70);
        ray.lineTo((x+100/2)+120,(y+100/2)-120);

        // rays width
        g2d.setStroke(new BasicStroke(7));

        g2d.draw(ray);

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

