package Objects;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle implements Shape{

    private double x;
    private double y;
    private double width;
    private double height;
    private double rotateAngle = 0;
    private boolean fill;

    public Circle() {

    }


    @Override
    public void draw(Graphics2D graphics2D) {
        Ellipse2D.Double e = new Ellipse2D.Double(x,y,width,height);
        graphics2D.rotate(Math.toRadians(rotateAngle),x+ (width /2),y+( height /2));
        if(fill){
            graphics2D.fill(e);
        }else {
            graphics2D.draw(e);
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

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }
}
