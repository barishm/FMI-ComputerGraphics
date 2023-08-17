import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle {
    private int x;
    private int y;

    public Rectangle(int x, int y) {
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

    public void drawRectangle(Graphics2D g2d){
        Rectangle2D.Double r = new Rectangle2D.Double(x,y,100,100);
        g2d.setColor(Color.YELLOW);
        g2d.fill(r);
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
