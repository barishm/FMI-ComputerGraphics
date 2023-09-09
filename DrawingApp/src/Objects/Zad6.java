package Objects;

import java.awt.*;

public class Zad6 extends Shape{

    private int Ax;
    private int Ay;
    private int Bx;
    private int By;
    private int Cx;
    private int Cy;
    private int Dx;
    private int Dy;
    private double rotateAngle = 0;
    private boolean fill;
    @Override
    public void draw(Graphics2D graphics2D) {
        Polygon polygon = new Polygon(new int[]{Ax, Cx, Bx, Dx},new int[]{Ay, Cy, By, Dy},4);
        graphics2D.rotate(Math.toRadians(rotateAngle),(Ax + Bx + Cx + Dx) / 4.0,(Ay + By + Cy + Dy) / 4.0);
        graphics2D.drawLine(Ax,Ay,Bx,By);
        graphics2D.drawLine(Cx,Cy,Dx,Dy);
        if(fill){
            graphics2D.fill(polygon);
        }else {
            graphics2D.draw(polygon);
        }
    }

    @Override
    public void move(int currentX, int currentY) {
        int deltaX = currentX - (Ax + Bx + Cx + Dx) / 4;
        int deltaY = currentY - (Ay + By + Cy + Dy) / 4;

        Ax += deltaX;
        Ay += deltaY;
        Bx += deltaX;
        By += deltaY;
        Cx += deltaX;
        Cy += deltaY;
        Dx += deltaX;
        Dy += deltaY;

    }

    @Override
    public void decreaseSize(int resize) {
        double scaleFactor = 1 - (resize / 100.0);

        double centerX = (Ax + Bx + Cx + Dx) / 4.0;
        double centerY = (Ay + By + Cy + Dy) / 4.0;

        Ax = (int) ((Ax - centerX) * scaleFactor + centerX);
        Ay = (int) ((Ay - centerY) * scaleFactor + centerY);
        Bx = (int) ((Bx - centerX) * scaleFactor + centerX);
        By = (int) ((By - centerY) * scaleFactor + centerY);
        Cx = (int) ((Cx - centerX) * scaleFactor + centerX);
        Cy = (int) ((Cy - centerY) * scaleFactor + centerY);
        Dx = (int) ((Dx - centerX) * scaleFactor + centerX);
        Dy = (int) ((Dy - centerY) * scaleFactor + centerY);
        calculate();
    }

    @Override
    public void increaseSize(int resize) {
        double scaleFactor = 1 + (resize / 100.0);

        double centerX = (Ax + Bx + Cx + Dx) / 4.0;
        double centerY = (Ay + By + Cy + Dy) / 4.0;

        Ax = (int) ((Ax - centerX) * scaleFactor + centerX);
        Ay = (int) ((Ay - centerY) * scaleFactor + centerY);
        Bx = (int) ((Bx - centerX) * scaleFactor + centerX);
        By = (int) ((By - centerY) * scaleFactor + centerY);
        Cx = (int) ((Cx - centerX) * scaleFactor + centerX);
        Cy = (int) ((Cy - centerY) * scaleFactor + centerY);
        Dx = (int) ((Dx - centerX) * scaleFactor + centerX);
        Dy = (int) ((Dy - centerY) * scaleFactor + centerY);
        calculate();
    }

    @Override
    public void calculate() {
        Cx = Bx;
        Cy = Ay;

        Dx = Ax;
        Dy = By;

    }

    public void setAx(double ax) {
        Ax = (int) ax;
    }


    public void setAy(double ay) {
        Ay = (int) ay;
    }


    public void setBx(double bx) {
        Bx = (int) bx;
    }

    public void setBy(double by) {
        By = (int) by;
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
}
