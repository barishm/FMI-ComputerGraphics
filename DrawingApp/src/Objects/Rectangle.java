package Objects;


import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle implements Shape{
    public Rectangle() {
    }

    private double x;
    private double y;
    private double width;
    private double height;
    private double rotateAngle = 0;
    private boolean fill;

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public Rectangle(double x, double y, double width, double height, double rotateAngle) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rotateAngle = rotateAngle;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        Rectangle2D.Double r = new Rectangle2D.Double(x,y,width,height);
        graphics2D.rotate(Math.toRadians(rotateAngle),x+ (width /2),y+( height /2));
        if(fill){
            graphics2D.fill(r);
        }else {
            graphics2D.draw(r);
        }
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
}
