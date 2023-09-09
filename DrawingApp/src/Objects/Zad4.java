package Objects;

import java.awt.*;

public class Zad4 extends Shape{
    private int Ax;
    private int Ay;
    private int Bx;
    private int By;
    private int Cx;
    private int Cy;
    private int Dx;
    private int Dy;
    private int Ex;
    private int Ey;
    private int Fx;
    private int Fy;
    private int Gx;
    private int Gy;
    private double rotateAngle = 0;
    private boolean fill;
    @Override
    public void draw(Graphics2D graphics2D) {
        Polygon polygon = new Polygon(new int[]{Ax, Cx, Bx, Dx},new int[]{Ay, Cy, By, Dy},4);
        graphics2D.rotate(Math.toRadians(rotateAngle),(Ax + Bx + Cx + Dx) / 4.0,(Ay + By + Cy + Dy) / 4.0);
        graphics2D.drawLine(Ex,Ey,Gx,Gy);
        graphics2D.drawLine(Fx,Fy,Gx,Gy);
        graphics2D.drawLine(Ax,Ay,Gx,Gy);
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
        Ex += deltaX;
        Ey += deltaY;
        Fx += deltaX;
        Fy += deltaY;
        Gx += deltaX;
        Gy += deltaY;
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
        Cx = Bx - ((Bx - Ax) / 5);
        Cy = Ay;

        Dx = Ax - ((Bx - Ax) / 5);
        Dy = By;

        Ex = Cx + (Bx - Cx) / 2;
        Ey = Ay + (By - Ay) / 2;

        Fx = Dx + (Bx - Dx) / 2;
        Fy = Dy;

        Gx = (int) (Ax + (Bx - Ax) / 2.5);
        Gy = Ay + (By - Ay) / 2;
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
