package Objects;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Zad1 extends Shape{
    private double Ax;
    private double Ay;
    private double Bx;
    private double By;
    private double topLeftX;
    private double topLeftY;
    private double topRightX;
    private double topRightY;
    private double bottomLeftX;
    private double bottomLeftY;
    private double bottomRightX;
    private double bottomRightY;
    private double middleTopX;
    private double middleTopY;
    private double middleBottomX;
    private double middleBottomY;
    private double rotateAngle = 0;
    private boolean fill;
    @Override
    public void draw(Graphics2D graphics2D) {
        Ellipse2D.Double e = new Ellipse2D.Double(Ax, Ay, Bx - Ax, By - Ay);
        double centerX = Ax + (Bx - Ax) / 2.0;
        double centerY = Ay + (By - Ay) / 2.0;

        graphics2D.rotate(Math.toRadians(rotateAngle), centerX, centerY);
        graphics2D.drawLine((int) topLeftX, (int) topLeftY, (int) topRightX, (int) topRightY);
        graphics2D.drawLine((int) bottomLeftX, (int) bottomLeftY, (int) bottomRightX, (int) bottomRightY);
        graphics2D.drawLine((int) middleTopX, (int) middleTopY, (int) middleBottomX, (int) middleBottomY);
        if(fill){
            graphics2D.fill(e);
        }else {
            graphics2D.draw(e);
        }

    }
    public void move(int currentX, int currentY) {
        double centerX = Ax + (Bx - Ax) / 2.0;
        double centerY = Ay + (By - Ay) / 2.0;
        double deltaX = currentX - centerX;
        double deltaY = currentY - centerY;

        Ax += deltaX;
        Ay += deltaY;

        Bx += deltaX;
        By += deltaY;

        topLeftX += deltaX;
        topLeftY += deltaY;
        topRightX += deltaX;
        topRightY += deltaY;
        bottomLeftX += deltaX;
        bottomLeftY += deltaY;
        bottomRightX += deltaX;
        bottomRightY += deltaY;
        middleTopX += deltaX;
        middleTopY += deltaY;
        middleBottomX += deltaX;
        middleBottomY += deltaY;
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
        calculate();
    }

    @Override
    public void calculate() {
        topLeftX = Ax;
        topLeftY = Ay;
        topRightX = Bx;
        topRightY = Ay;
        bottomLeftX = Ax;
        bottomLeftY = By;
        bottomRightX = Bx;
        bottomRightY = By;
        middleTopX = (Ax + Bx) / 2.0;
        middleTopY = Ay;
        middleBottomX = (Ax + Bx) / 2.0;
        middleBottomY = By;
    }
    public void decreaseSize(int resize) {
        By -= resize;
        Bx -= resize;
        calculate();
    }
}
