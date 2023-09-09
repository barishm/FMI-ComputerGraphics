package Objects;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Zad5 extends Shape{
    private double Ax;
    private double Ay;
    private double Bx;
    private double By;
    private double topX;
    private double topY;
    private double botX;
    private double botY;
    private double rightX;
    private double rightY;
    private double leftX;
    private double leftY;
    private double topLeftX;
    private double topLeftY;
    private double topRightX;
    private double topRightY;
    private double botLeftX;
    private double botLeftY;
    private double botRightX;
    private double botRightY;
    private double width;
    private double height;
    private double rotateAngle = 0;
    private boolean fill;
    @Override
    public void draw(Graphics2D graphics2D) {
        Ellipse2D.Double e = new Ellipse2D.Double(Ax, Ay, width, height);

        graphics2D.rotate(Math.toRadians(rotateAngle), Ax + width / 2, Ay + height / 2);

        graphics2D.drawLine((int) topLeftX, (int) topLeftY, (int) topRightX, (int) topRightY);
        graphics2D.drawLine((int) botRightX, (int) botRightY, (int) botLeftX, (int) botLeftY);
        graphics2D.drawLine((int) leftX, (int) leftY, (int) rightX, (int) rightY);

        graphics2D.drawLine((int) topX, (int) topY, (int) botX, (int) botY);
        if(fill){
            graphics2D.fill(e);
        }else {
            graphics2D.draw(e);
        }

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


    @Override
    public void calculate() {
        width = Bx - Ax;
        height = By - Ay;

        double h = Ax + width / 2;
        double k = Ay + height / 2;

        double a = width / 2;
        double b = height / 2;

        leftX = Ax;
        leftY = k;

        rightX = Bx;
        rightY = k;

        topX = h;
        topY = k - b;

        botX = h;
        botY = k + b;

        topLeftX = h + a * Math.cos(5 * Math.PI / 4);
        topLeftY = k + b * Math.sin(5 * Math.PI / 4);

        topRightX = h + a * Math.cos(7 * Math.PI / 4);
        topRightY = k + b * Math.sin(7 * Math.PI / 4);

        botLeftX = h + a * Math.cos(3 * Math.PI / 4);
        botLeftY = k + b * Math.sin(3 * Math.PI / 4);

        botRightX = h + a * Math.cos(Math.PI / 4);
        botRightY = k + b * Math.sin(Math.PI / 4);

    }

    public void move(int currentX, int currentY){
        double centerX = Ax + width / 2;
        double centerY = Ay + height / 2;

        double deltaX = currentX - centerX;
        double deltaY = currentY - centerY;

        Ax += deltaX;
        Ay += deltaY;

        Bx = Ax + width;
        By = Ay + height;

        calculate();
    }

    public void increaseSize(int resize) {
        Bx += resize;
        By += resize;
        calculate();
    }

    public void decreaseSize(int resize) {
        if (width > resize && height > resize) {
            Bx -= resize;
            By -= resize;
            calculate();
        }
    }
}
