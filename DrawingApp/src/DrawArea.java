import Objects.Rectangle;

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
    private boolean drawingLine = false;
    private boolean drawingRectangle = false;
    private boolean rotateResizeMode = false;
    private final double rotateAngle = 2;
    private final int resizeWidth = 5;
    private final int resizeHeight = 5;
    private final Rectangle rectangle;



    public DrawArea() {
        setDoubleBuffered(false);
        this.rectangle = new Rectangle();

        addMouseWheelListener(e -> {
            if(e.getWheelRotation() < 0 && rotateResizeMode){
                rectangle.setRotateAngle(rectangle.getRotateAngle() + rotateAngle);
                repaint();
            }else if(e.getWheelRotation() > 0 && rotateResizeMode){
                rectangle.setRotateAngle(rectangle.getRotateAngle() - rotateAngle);
                repaint();
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
                        case KeyEvent.VK_W -> {
                            rectangle.setWidth(rectangle.getWidth() + resizeWidth);
                            rectangle.setHeight(rectangle.getHeight() + resizeHeight);
                            repaint();
                        }
                        case KeyEvent.VK_S -> {
                            rectangle.setWidth(rectangle.getWidth() - resizeWidth);
                            rectangle.setHeight(rectangle.getHeight() - resizeHeight);
                            repaint();
                        }
                        case KeyEvent.VK_A -> {
                            rectangle.setRotateAngle(rectangle.getRotateAngle() - rotateAngle);
                            repaint();
                        }
                        case KeyEvent.VK_D -> {
                            rectangle.setRotateAngle(rectangle.getRotateAngle() + rotateAngle);
                            repaint();
                        }
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
                if("Line".equals(tool)){
                    drawingLine = true;
                }
                if("Rectangle".equals(tool)){
                    rectangle.setX(oldX);
                    rectangle.setY(oldY);
                    drawingRectangle = true;
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();
                if(rotateResizeMode){
                    rectangle.setX(currentX -  rectangle.getWidth() / 2);
                    rectangle.setY(currentY - rectangle.getHeight() / 2);
                    repaint();
                }
                else if("Pen".equals(tool)) {
                    if (g2 != null) {
                        g2.drawLine(oldX, oldY, currentX, currentY);
                        repaint();
                        oldX = currentX;
                        oldY = currentY;
                    }
                } else if ("Line".equals(tool) && drawingLine) {
                    repaint();
                } else if ("Rectangle".equals(tool) && drawingRectangle) {
                    rectangle.setWidth(currentX - oldX);
                    rectangle.setHeight(currentY - oldY);
                    repaint();
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
                        drawingLine = false;
                    }
                }
                if("Rectangle".equals(tool)){
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
        if(drawingLine){
            tempG.drawLine(oldX,oldY,currentX,currentY);
        }
        if(drawingRectangle){
            rectangle.drawRectangle(tempG);
        }
    }

    public void clear() {
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(color);
        drawingLine = false;
        drawingRectangle = false;
        repaint();
    }
    public void setColor(Color colour){
        color = colour;
        g2.setColor(color);
        repaint();
    }

    public void setTool(String name) {
        tool = name;
    }

    public void setStroke(int value) {
        stroke = value;
        g2.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        tempG.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        repaint();
    }

    public void apply() {
        if(drawingRectangle){
            rectangle.drawRectangle(g2);
            cancel();
        }
    }

    public void cancel() {
        drawingRectangle = false;
        tempG.drawLine(0,0,0,0);
        rectangle.setRotateAngle(0);
        rotateResizeMode = false;
        repaint();
    }
}

