package Objects;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Zad2 extends Shape{
    private double Ax;
    private double Ay;
    private double Bx;
    private double By;
    private double midX;
    private double midY;
    private double leftX;
    private double leftY;
    private double rotateAngle = 0;
    private boolean fill;
    public void setFill(boolean fill) {
        this.fill = fill;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        Rectangle2D.Double r = new Rectangle2D.Double(Ax,Ay,Bx - Ax,By - Ay);
        graphics2D.rotate(Math.toRadians(rotateAngle), midX, midY);
        graphics2D.drawLine((int) leftX, (int) leftY, (int) midX, (int) midY);
        graphics2D.drawLine((int) midX, (int) midY, (int) Bx, (int) Ay);
        graphics2D.drawLine((int) midX, (int) midY, (int) Bx, (int) By);
        if(fill){
            graphics2D.fill(r);
        }else {
            graphics2D.draw(r);
        }
    }
    public void move(int currentX, int currentY){
        double deltaX = currentX - midX;
        double deltaY = currentY - midY;

        Ax += deltaX;
        Ay += deltaY;
        Bx += deltaX;
        By += deltaY;

        calculate();
    }
    public void increaseSize(int resize) {
        Bx += resize;
        By += resize;
        calculate();
    }

    @Override
    public void calculate() {
        midX = Ax + (Bx - Ax) / 2.0;
        midY = Ay + (By - Ay) / 2.0;

        leftX = Ax;
        leftY = Ay + (By - Ay) / 2.0;
    }

    public void decreaseSize(int resize){
        Bx -= resize;
        By -= resize;
        calculate();
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
