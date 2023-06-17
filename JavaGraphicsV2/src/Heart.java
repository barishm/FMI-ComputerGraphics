import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

public class Heart {
    private int x;
    private int y;

    public Heart(int x, int y) {
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
    public void drawHeart(Graphics2D g2d) {
        Ellipse2D.Double e = new Ellipse2D.Double(x,y,50,50);
        Ellipse2D.Double e2 = new Ellipse2D.Double(x+48,y,50,50);
        g2d.setColor(Color.RED);
        //g2d.fillArc(x,y,50,50,0,180);
        //g2d.fillArc(x+50,y,50,50,0,180);
        g2d.fill(e);
        g2d.fill(e2);
        Path2D.Double p = new Path2D.Double();
        p.moveTo(x-1,y+32);
        p.lineTo(x+50,y+100);
        p.lineTo(x+98,y+32);
        p.closePath();
        g2d.fill(p);
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
