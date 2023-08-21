package Objects;


import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle {
    public Rectangle() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getRotateAngle() {
        return rotateAngle;
    }

    public void setRotateAngle(double rotateAngle) {
        this.rotateAngle = rotateAngle;
    }



    private double x;
    private double y;
    private double width;
    private double height;
    private double rotateAngle = 0;

    public Rectangle(double x, double y, double width, double height, double rotateAngle) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rotateAngle = rotateAngle;
    }
    public void drawRectangle(Graphics2D graphics2D){
        Rectangle2D.Double r = new Rectangle2D.Double(x,y,width,height);
        graphics2D.rotate(Math.toRadians(rotateAngle),x+ (width /2),y+( height /2));
        graphics2D.draw(r);

    }
}
