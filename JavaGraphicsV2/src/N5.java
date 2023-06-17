import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

public class N5 {
    private int x;
    private int y;

    public N5(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void drawN5(Graphics2D g2d){
        Ellipse2D.Double e = new Ellipse2D.Double(x,y,250,250);
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(e);
        Path2D.Double p = new Path2D.Double();
        p.moveTo(x+125,y);
        p.lineTo(x+125,y+250);
        p.moveTo(x,y+125);
        p.lineTo(x+250,y+125);
        p.moveTo(x+35,y+37);
        p.lineTo(x+215,y+37);
        p.moveTo(x+35,y+213);
        p.lineTo(x+215,y+213);
        g2d.draw(p);
    }
    public boolean contains(int x,int y){
        if(this.x < x && x < this.x + 250){
            if(this.y < y && y < this.y + 250){
                return true;
            }
        }
        return false;
    }
}
