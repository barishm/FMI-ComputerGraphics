import Objects.*;
import Objects.Shape;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class DrawArea extends JComponent {

    private Image image;
    private Graphics2D g2;
    private Graphics2D tempG;
    private int currentX, currentY, oldX, oldY,stroke = 4;
    private String tool = "Pen";
    private Color color = Color.BLACK;
    private boolean fill = false;
    private boolean rotateResizeMode = false;
    private boolean drawn = true;
    private final double rotateAngle = 2;
    private final int resize = 5;
    private Shape shape;



    public DrawArea() {

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
                } else if(!"Pen".equals(tool)){
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
        } else if(!"Pen".equals(tool) && !drawn){
            shape.draw(tempG);
        }
    }
    private void startDrawing() {
        if(shape != null && !rotateResizeMode) {
            shape.setAx(oldX);
            shape.setAy(oldY);
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
        } else  {
            shape.setBx(currentX);
            shape.setBy(currentY);
            shape.calculate();
            repaint();
        }
    }
    private void reposition() {
        shape.move(currentX,currentY);
        repaint();
    }

    public void setTool(String name) {
        tool = name;
        rotateResizeMode = false;
        ShapeFactory shapeFactory = new ShapeFactory();
        if ("Rectangle".equals(tool)) {
            shape = shapeFactory.getShape(tool);
        } else if ("Circle".equals(tool)) {
            shape = shapeFactory.getShape(tool);
        } else if ("Triangle".equals(tool)) {
            shape = shapeFactory.getShape(tool);
        } else if ("Right Triangle".equals(tool)) {
            shape = shapeFactory.getShape(tool);
        } else if ("Pentagon".equals(tool)) {
            shape = shapeFactory.getShape(tool);
        } else if ("Hexagon".equals(tool)) {
            shape = shapeFactory.getShape(tool);
        } else if ("Zad".equals(tool)) {
            shape = shapeFactory.getShape(tool);
        }
        if(shape != null){
            shape.setFill(fill);
        }

    }

    public void apply() {
        tempG.drawLine(0,0,0,0);
        drawn = true;
        if(shape != null){
            shape.draw(g2);
        }
        cancel();
    }


    public void increaseSize() {
        shape.increaseSize(resize);
        repaint();
    }

    public void decreaseSize() {
        shape.decreaseSize(resize);
        repaint();
    }

    public void rotateLeft() {
        shape.setRotateAngle(shape.getRotateAngle() - rotateAngle);
        repaint();
    }

    public void rotateRight() {
        shape.setRotateAngle(shape.getRotateAngle() + rotateAngle);
        repaint();
    }
    public void setFill(boolean selected) {
        fill = selected;
        if(shape != null){
            shape.setFill(selected);
        }
        repaint();
    }
    public void setOpacity(int value) {
        color = new Color(color.getRed(), color.getGreen(), color.getBlue(), value);
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
        if(shape != null) {
            shape.setRotateAngle(0);
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

    public void save(String path) throws IOException {
        File file = new File(path);
        ImageIO.write((RenderedImage) image,"png",file);
    }

}

