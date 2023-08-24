package Objects;

import java.awt.*;

public class Pentagon implements Shape{
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
    private int width;
    private int height;

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
        Cx = cx;
    }

    public int getCy() {
        return Cy;
    }

    public void setCy(int cy) {
        Cy = cy;
    }

    public int getDx() {
        return Dx;
    }

    public void setDx(int dx) {
        Dx = dx;
    }

    public int getDy() {
        return Dy;
    }

    public void setDy(int dy) {
        Dy = dy;
    }

    public int getEx() {
        return Ex;
    }

    public void setEx(int ex) {
        Ex = ex;
    }

    public int getEy() {
        return Ey;
    }

    public void setEy(int ey) {
        Ey = ey;
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
    public void calculate(){
        Ex = this.Ax - (this.Bx - this.Ax);
        Ey = By;
        int width = Bx - Ex;

        Cx = (Bx - width / 5); // todo
        Cy = By + (By - Ay);

        Dx = Ex + width / 5; // todo
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
