import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse {
    private int x;
    private int y;

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

    public Ellipse(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawEllipse(Graphics2D g2d){
        Ellipse2D.Double e = new Ellipse2D.Double(x,y,100,100);
        g2d.setColor(Color.black);
        g2d.draw(e);
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
