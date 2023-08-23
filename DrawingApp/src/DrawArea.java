import Objects.Circle;
import Objects.Rectangle;
import Objects.ShapeFactory;
import Objects.Triangle;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import javax.swing.JComponent;


public class DrawArea extends JComponent {

    private Image image;
    private Graphics2D g2;
    private Graphics2D tempG;
    private int currentX, currentY, oldX, oldY,stroke = 2;
    private String tool = "Pen";
    private Color color = Color.BLACK;
    private Color color2;
    private boolean fill = false;
    private boolean rotateResizeMode = false;
    private boolean drawn = true;
    private final double rotateAngle = 2;
    private final int resizeWidth = 5;
    private final int resizeHeight = 5;
    private Rectangle rectangle;
    private Circle circle;
    private Triangle triangle;



    public DrawArea() {
        setDoubleBuffered(false);

        addMouseWheelListener(e -> {
            if(e.getWheelRotation() < 0 && rotateResizeMode) {
                rotateRight();
            } else if(e.getWheelRotation() > 0 && rotateResizeMode){
                rotateLeft();
            }
        });
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(rotateResizeMode){
                    int keyCode = e.getKeyCode();
                    switch (keyCode) {
                        case KeyEvent.VK_W -> increaseSize();
                        case KeyEvent.VK_S -> decreaseSize();
                        case KeyEvent.VK_A -> rotateLeft();
                        case KeyEvent.VK_D -> rotateRight();
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
                drawn = false;
                startDrawing();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();
                if(rotateResizeMode){
                    reposition();
                }else {
                    drawing();
                }
            }


        });
        addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();
                if ("Line".equals(tool)) {
                    if (g2 != null) {
                        g2.drawLine(oldX, oldY, currentX, currentY);
                        repaint();
                        oldX = currentX;
                        oldY = currentY;
                    }
                }
                if(!"Pen".equals(tool)){
                    if(g2 != null){
                        rotateResizeMode = true;
                        requestFocus();
                        repaint();
                    }
                }
            }
        });
    }
    protected void paintComponent(Graphics g) {
        tempG = (Graphics2D) g;
        tempG.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        tempG.setPaint(color);
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
            clear();
        }
        AffineTransform reset = new AffineTransform();
        g2.setTransform(reset);
        tempG.drawImage(image, 0, 0, null);
        if("Line".equals(tool) && !drawn){
            tempG.drawLine(oldX,oldY,currentX,currentY);
        } else if("Rectangle".equals(tool) && !drawn){
            rectangle.draw(tempG);
        } else if ("Circle".equals(tool) && !drawn) {
            circle.draw(tempG);
        } else if ("Triangle".equals(tool) && !drawn){
            triangle.draw(tempG);
        }
    }
    private void startDrawing() {
        if("Rectangle".equals(tool)){
            rectangle.setX(oldX);
            rectangle.setY(oldY);
        } else if ("Circle".equals(tool)) {
            circle.setX(oldX);
            circle.setY(oldY);
        } else if ("Triangle".equals(tool) && !rotateResizeMode) {
            triangle.setAx(oldX);
            triangle.setAy(oldY);
        }
    }
    private void drawing() {
        if("Pen".equals(tool)) {
            if (g2 != null) {
                g2.drawLine(oldX, oldY, currentX, currentY);
                repaint();
                oldX = currentX;
                oldY = currentY;
            }
        } else if ("Line".equals(tool)) {
            repaint();
        } else if ("Rectangle".equals(tool)) {
            rectangle.setWidth(currentX - oldX);
            rectangle.setHeight(currentY - oldY);
            repaint();
        } else if ("Circle".equals(tool)) {
            circle.setWidth(currentX - oldX);
            circle.setHeight(currentY - oldY);
            repaint();
        } else if ("Triangle".equals(tool)) {
            triangle.setBx(currentX);
            triangle.setBy(currentY);
            triangle.setCx(currentX);
            triangle.setCy(currentY);
            repaint();
        }
    }
    private void reposition() {
        if("Rectangle".equals(tool)){
            rectangle.setX(currentX -  rectangle.getWidth() / 2);
            rectangle.setY(currentY - rectangle.getHeight() / 2);
        } else if ("Circle".equals(tool)) {
            circle.setX(currentX - circle.getWidth() / 2);
            circle.setY(currentY - circle.getHeight() / 2);
        } else if ("Triangle".equals(tool)) {
            triangle.move(currentX,currentY);
        }
        repaint();
    }

    public void setTool(String name) {
        tool = name;
        rotateResizeMode = false;
        ShapeFactory shapeFactory = new ShapeFactory();
        if ("Rectangle".equals(tool)) {
            rectangle = (Rectangle) shapeFactory.getShape(tool);
        } else if ("Circle".equals(tool)) {
            circle = (Circle) shapeFactory.getShape(tool);
        } else if ("Triangle".equals(tool)) {
            triangle = (Triangle) shapeFactory.getShape(tool);
        }
    }

    public void apply() {
        tempG.drawLine(0,0,0,0);
        drawn = true;
        if("Rectangle".equals(tool)){
            rectangle.draw(g2);
            cancel();
        } else if ("Circle".equals(tool)) {
            circle.draw(g2);
            cancel();
        } else if ("Triangle".equals(tool)) {
            triangle.draw(g2);
            cancel();
        }
    }


    public void increaseSize() {
        if("Rectangle".equals(tool)){
            rectangle.setWidth(rectangle.getWidth() + resizeWidth);
            rectangle.setHeight(rectangle.getHeight() + resizeHeight);
        } else if ("Circle".equals(tool)) {
            circle.setWidth(circle.getWidth() + resizeWidth);
            circle.setHeight(circle.getHeight() + resizeHeight);
        }
        repaint();
    }

    public void decreaseSize() {
        if("Rectangle".equals(tool)){
            rectangle.setWidth(rectangle.getWidth() - resizeWidth);
            rectangle.setHeight(rectangle.getHeight() - resizeHeight);
        } else if ("Circle".equals(tool)) {
            circle.setWidth(circle.getWidth() - resizeWidth);
            circle.setHeight(circle.getHeight() - resizeHeight);
        }
        repaint();
    }

    public void rotateLeft() {
        if("Rectangle".equals(tool)){
            rectangle.setRotateAngle(rectangle.getRotateAngle() - rotateAngle);
        } else if ("Circle".equals(tool)) {
            circle.setRotateAngle(circle.getRotateAngle() - rotateAngle);
        } else if ("Triangle".equals(tool)) {
            triangle.setRotateAngle(triangle.getRotateAngle() - rotateAngle);
        }
        repaint();
    }

    public void rotateRight() {
        if("Rectangle".equals(tool)){
            rectangle.setRotateAngle(rectangle.getRotateAngle() + rotateAngle);
        } else if ("Circle".equals(tool)) {
            circle.setRotateAngle(circle.getRotateAngle() + rotateAngle);
        } else if ("Triangle".equals(tool)) {
            triangle.setRotateAngle(triangle.getRotateAngle() + rotateAngle);
        }
        repaint();
    }
    public void setFill(boolean selected) {
        fill = selected;
        if("Rectangle".equals(tool)){
            rectangle.setFill(selected);
        } else if ("Circle".equals(tool)) {
            circle.setFill(selected);
        } else if ("Triangle".equals(tool)) {
            triangle.setFill(selected);
        }
        repaint();
    }
    public void setOpacity(int value) {
        color2 = new Color(color.getRed(),color.getGreen(),color.getBlue(),value);
        color = color2;
        g2.setColor(color);
        repaint();
    }
    public void clear() {
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(color);
        rotateResizeMode = false;
        drawn = true;
        repaint();
    }
    public void cancel() {
        tempG.drawLine(0,0,0,0);
        if("Rectangle".equals(tool)){
            rectangle.setRotateAngle(0);
        } else if ("Circle".equals(tool)){
            circle.setRotateAngle(0);
        } else if("Triangle".equals(tool)){
            triangle.setRotateAngle(0);
        }
        rotateResizeMode = false;
        drawn = true;
        repaint();
    }
    public void setStroke(int value) {
        stroke = value;
        g2.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        tempG.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        repaint();
    }
    public void setColor(Color colour){
        color = colour;
        g2.setColor(color);
        repaint();
    }
}

