package Objects;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape{

    private double Ax;
    private double Ay;
    private double Bx;
    private double By;
    private double rotateAngle = 0;
    private boolean fill;
    public Circle() {

    }
    @Override
    public void draw(Graphics2D graphics2D) {
        Ellipse2D.Double e = new Ellipse2D.Double(Ax,Ay,Bx,By);
        graphics2D.rotate(Math.toRadians(rotateAngle),Ax+ (Bx /2),Ay+( By /2));
        if(fill){
            graphics2D.fill(e);
        }else {
            graphics2D.draw(e);
        }

    }
    public void move(int currentX, int currentY){
        Ax = currentX - Bx / 2;
        Ay = currentY - By / 2;
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
    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public void increaseSize(int resize) {
        By += resize;
        Bx += resize;
    }

    @Override
    public void calculate() {
        Bx = Bx - Ax;
        By = By - Ay;
    }

    public void decreaseSize(int resize) {
        By -= resize;
        Bx -= resize;
    }
}
