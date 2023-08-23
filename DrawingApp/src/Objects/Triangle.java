package Objects;

import java.awt.*;

public class Triangle implements Shape {
    private int Ax;
    private int Ay;
    private int Bx;
    private int By;
    private int Cx;
    private int Cy;
    private double rotateAngle = 0;
    private boolean fill;

    public Triangle() {
    }


    @Override
    public void draw(Graphics2D graphics2D) {
        Polygon polygon = new Polygon(new int[]{Ax, Bx, Cx},new int[]{Ay, By, Cy},3);
        graphics2D.rotate(Math.toRadians(rotateAngle),Ax,Ay + (double) By / 2);
        if(fill){
            graphics2D.fill(polygon);
        }else {
            graphics2D.draw(polygon);
        }
    }

    public int getAx() {
        return Ax;
    }

    public void setAx(int ax) {
        Ax = ax;
    }

    public int getAy() {
        return Ay;
    }

    public void setAy(int ay) {
        Ay = ay;
    }

    public int getBx() {
        return Bx;
    }

    public void setBx(int bx) {
        Bx = bx;
    }

    public int getBy() {
        return By;
    }

    public void setBy(int by) {
        By = by;
    }

    public int getCx() {
        return Cx;
    }

    public void setCx(int cx) {
        Cx = this.Ax - (this.Bx - this.Ax);
    }

    public int getCy() {
        return Cy;
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

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
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
}
