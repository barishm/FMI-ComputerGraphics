package Objects;

import java.awt.*;

public class RightTriangle implements Shape{
    private int Ax;
    private int Ay;
    private int Bx;
    private int By;
    private int Cx;
    private int Cy;
    private double rotateAngle = 0;
    private boolean fill;

    public RightTriangle() {
    }


    @Override
    public void draw(Graphics2D graphics2D) {
        Polygon polygon = new Polygon(new int[]{Ax, Bx, Cx},new int[]{Ay, By, Cy},3);
        graphics2D.rotate(Math.toRadians(rotateAngle),Ax + (double) (Bx - Ax) / 3,Ay + (double) (By - Ay)/1.5);
        if(fill){
            graphics2D.fill(polygon);
        }else {
            graphics2D.draw(polygon);
        }
    }
    public void move(int currentX, int currentY){
        int centerX = (this.Ax + this.Bx + this.Cx) / 3;
        int centerY = (this.Ay + this.By + this.Cy) / 3;

        int deltaX = currentX - centerX;
        int deltaY = currentY - centerY;

        this.Ax += deltaX;
        this.Ay += deltaY;
        this.Bx += deltaX;
        this.By += deltaY;
        this.Cx += deltaX;
        this.Cy += deltaY;
    }
    public void increaseSize(int resize) {
        int vectorABx = Bx - Ax;
        int vectorABy = By - Ay;
        int vectorACx = Cx - Ax;
        int vectorACy = Cy - Ay;

        vectorABx *= 1 + resize / 100.0;
        vectorABy *= 1 + resize / 100.0;
        vectorACx *= 1 + resize / 100.0;
        vectorACy *= 1 + resize / 100.0;

        Bx = Ax + vectorABx;
        By = Ay + vectorABy;
        Cx = Ax + vectorACx;
        Cy = Ay + vectorACy;
    }
    public void decreaseSize(int resize) {
        int vectorABx = Bx - Ax;
        int vectorABy = By - Ay;
        int vectorACx = Cx - Ax;
        int vectorACy = Cy - Ay;

        vectorABx *= 1 - resize / 100.0;
        vectorABy *= 1 - resize / 100.0;
        vectorACx *= 1 - resize / 100.0;
        vectorACy *= 1 - resize / 100.0;

        Bx = Ax + vectorABx;
        By = Ay + vectorABy;
        Cx = Ax + vectorACx;
        Cy = Ay + vectorACy;
    }


    public void setAx(int ax) {
        Ax = ax;
    }


    public void setAy(int ay) {
        Ay = ay;
    }


    public void setBx(int bx) {
        Bx = bx;
    }


    public void setBy(int by) {
        By = by;
    }


    public void setCx(int cx) {
        Cx = this.Ax;
    }


    public void setCy(int cy) {
        Cy = cy;
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
