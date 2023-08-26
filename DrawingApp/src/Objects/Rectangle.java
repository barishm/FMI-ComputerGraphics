package Objects;


import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Shape{
    public Rectangle() {
    }

    private double Ax;
    private double Ay;
    private double Bx;
    private double By;
    private double rotateAngle = 0;
    private boolean fill;

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        Rectangle2D.Double r = new Rectangle2D.Double(Ax,Ay,Bx,By);
        graphics2D.rotate(Math.toRadians(rotateAngle),Ax+ (Bx /2),Ay+( By /2));
        if(fill){
            graphics2D.fill(r);
        }else {
            graphics2D.draw(r);
        }
    }
    public void move(int currentX, int currentY){
        Ax = currentX - Bx / 2;
        Ay = currentY - By / 2;
    }
    public void increaseSize(int resize) {
        Bx += resize;
        By += resize;
    }

    @Override
    public void calculate() {
        Bx = Bx - Ax;
        By = By - Ay;
    }

    public void decreaseSize(int resize){
        Bx -= resize;
        By -= resize;
    }

    public void setAx(double ax) {
        Ax = ax;
    }

    public void setAy(double ay) {
        Ay = ay;
    }

    public void setBx(double bx) {
        Bx = bx;
    }

    public void setBy(double by) {
        By = by;
    }

    public double getRotateAngle() {
        return rotateAngle;
    }

    public void setRotateAngle(double rotateAngle) {
        this.rotateAngle = rotateAngle;
    }
}
