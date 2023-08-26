package Objects;

import java.awt.*;

public abstract class Shape {
    private double Ax;
    private double Ay;
    private double Bx;
    private double By;
    private double rotateAngle = 0;
    private boolean fill;


    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public abstract void draw(Graphics2D graphics2D);
    public abstract void move(int currentX, int currentY);
    public abstract void decreaseSize(int resize);
    public abstract void increaseSize(int resize);
    public abstract void calculate();


    public double getRotateAngle() {
        return rotateAngle;
    }

    public void setRotateAngle(double rotateAngle) {
        this.rotateAngle = rotateAngle;
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
}
