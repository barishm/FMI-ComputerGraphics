package Objects;

import java.awt.*;

public class Hexagon implements Shape {
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
    private double rotateAngle = 0;
    private boolean fill;

    @Override
    public void draw(Graphics2D graphics2D) {
        Polygon polygon = new Polygon(new int[]{Ax, Bx, Cx, Dx, Ex, Fx},new int[]{Ay, By, Cy, Dy, Ey, Fy},6);
        graphics2D.rotate(Math.toRadians(rotateAngle),(Ax + Bx + Cx + Dx + Ex) / 5.0,(Ay + By + Cy + Dy + Ey) / 5.0);
        if(fill){
            graphics2D.fill(polygon);
        }else {
            graphics2D.draw(polygon);
        }

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

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public double getRotateAngle() {
        return rotateAngle;
    }

    public void setRotateAngle(double rotateAngle) {
        this.rotateAngle = rotateAngle;
    }

    public void calculate(){
        Cx = Bx;
        Cy = By + (By - Ay);

        Dx = Ax;
        Dy = Cy + (By - Ay);

        Ex = Ax - (Bx - Ax);
        Ey = Cy;


        Fx = Ax - (Bx - Ax);
        Fy = By;

    }

    public void increaseSize(int resize) {
        double scaleFactor = 1 + (resize / 100.0); // Convert resize percentage to a scale factor

        // Calculate the center of the hexagon
        double centerX = (Ax + Bx + Cx + Dx + Ex + Fx) / 6.0;
        double centerY = (Ay + By + Cy + Dy + Ey + Fy) / 6.0;

        // Update the positions of the vertices based on the scale factor and the center
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
        Fx = (int) ((Fx - centerX) * scaleFactor + centerX);
        Fy = (int) ((Fy - centerY) * scaleFactor + centerY);
    }

    public void decreaseSize(int resize) {
        double scaleFactor = 1 - (resize / 100.0); // Convert resize percentage to a scale factor

        // Calculate the center of the hexagon
        double centerX = (Ax + Bx + Cx + Dx + Ex + Fx) / 6.0;
        double centerY = (Ay + By + Cy + Dy + Ey + Fy) / 6.0;

        // Update the positions of the vertices based on the scale factor and the center
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
        Fx = (int) ((Fx - centerX) * scaleFactor + centerX);
        Fy = (int) ((Fy - centerY) * scaleFactor + centerY);
    }

    public void move(int currentX, int currentY) {
        int deltaX = currentX - (Ax + Bx + Cx + Dx + Ex + Fx) / 6;
        int deltaY = currentY - (Ay + By + Cy + Dy + Ey + Fy) / 6;

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
    }
}
