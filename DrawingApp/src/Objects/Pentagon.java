package Objects;

import java.awt.*;

public class Pentagon extends Shape{
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
    private double rotateAngle = 0;
    private boolean fill;


    public Pentagon() {
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        Polygon polygon = new Polygon(new int[]{Ax, Bx, Cx, Dx, Ex},new int[]{Ay, By, Cy, Dy, Ey},5);
        graphics2D.rotate(Math.toRadians(rotateAngle),(Ax + Bx + Cx + Dx + Ex) / 5.0,(Ay + By + Cy + Dy + Ey) / 5.0);
        if(fill){
            graphics2D.fill(polygon);
        }else {
            graphics2D.draw(polygon);
        }

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
    public void calculate(){
        Ex = this.Ax - (this.Bx - this.Ax);
        Ey = By;
        int width = Bx - Ex;

        Cx = (Bx - width / 5);
        Cy = By + (By - Ay);

        Dx = Ex + width / 5;
        Dy = By+  By - Ay;

    }
    public void move(int currentX,int currentY){
        int deltaX = currentX - (Ax + Bx + Cx + Dx + Ex) / 5;
        int deltaY = currentY - (Ay + By + Cy + Dy + Ey) / 5;

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

    }

    public void increaseSize(int resize) {
        double scaleFactor = 1 + (resize / 100.0);

        double centerX = (Ax + Bx + Cx + Dx + Ex) / 5.0;
        double centerY = (Ay + By + Cy + Dy + Ey) / 5.0;

        Ax = (int) ((Ax - centerX) * scaleFactor + centerX);
        Ay = (int) ((Ay - centerY) * scaleFactor + centerY);
        Bx = (int) ((Bx - centerX) * scaleFactor + centerX);
        By = (int) ((By - centerY) * scaleFactor + centerY);
        Cx = (int) ((Cx - centerX) * scaleFactor + centerX);
        Cy = (int) ((Cy - centerY) * scaleFactor + centerY);
        Dx = (int) ((Dx - centerX) * scaleFactor + centerX);
        Dy = (int) ((Dy - centerY) * scaleFactor + centerY);
        Ex = (int) ((Ex - centerX) * scaleFactor + centerX);
        Ey = (int) ((Ey - centerY) * scaleFactor + centerY);
    }

    public void decreaseSize(int resize) {
        double scaleFactor = 1 - (resize / 100.0);

        double centerX = (Ax + Bx + Cx + Dx + Ex) / 5.0;
        double centerY = (Ay + By + Cy + Dy + Ey) / 5.0;

        Ax = (int) ((Ax - centerX) * scaleFactor + centerX);
        Ay = (int) ((Ay - centerY) * scaleFactor + centerY);
        Bx = (int) ((Bx - centerX) * scaleFactor + centerX);
        By = (int) ((By - centerY) * scaleFactor + centerY);
        Cx = (int) ((Cx - centerX) * scaleFactor + centerX);
        Cy = (int) ((Cy - centerY) * scaleFactor + centerY);
        Dx = (int) ((Dx - centerX) * scaleFactor + centerX);
        Dy = (int) ((Dy - centerY) * scaleFactor + centerY);
        Ex = (int) ((Ex - centerX) * scaleFactor + centerX);
        Ey = (int) ((Ey - centerY) * scaleFactor + centerY);
    }
}
