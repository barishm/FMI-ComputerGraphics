
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;


public class DrawArea extends JComponent {

    private Image image;
    private Graphics2D g2;
    private int currentX, currentY, oldX, oldY,stroke;
    private String tool = "Rectangle";
    private Color color;
    private boolean drawingLine = false;
    private boolean drawingRectangle = false;
    private Rectangle2D.Double r;



    public DrawArea() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
                if("Line".equals(tool)){
                    drawingLine = true;
                }
                if("Rectangle".equals(tool)){
                    drawingRectangle = true;
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();
                if("Pen".equals(tool)) {
                    if (g2 != null) {
                        g2.drawLine(oldX, oldY, currentX, currentY);
                        repaint();
                        oldX = currentX;
                        oldY = currentY;
                    }
                } else if ("Line".equals(tool) && drawingLine) {
                    repaint();
                } else if ("Rectangle".equals(tool) && drawingRectangle) {
                    repaint();
                }
            }


        });
        addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if ("Line".equals(tool)) {
                    if (g2 != null) {
                        g2.drawLine(oldX, oldY, currentX, currentY);
                        repaint();
                        drawingLine = false;
                    }
                }
                if("Rectangle".equals(tool)){
                    if(g2 != null){
                        r = new Rectangle2D.Double(oldX,oldY,currentX - oldX,currentY - oldY);
                        g2.draw(r);
                        repaint();
                        drawingRectangle = false;
                    }
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        g2d.setPaint(color);
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g2d.drawImage(image, 0, 0, null);
        if(drawingLine){
            g2d.drawLine(oldX,oldY,currentX,currentY);
        }
        if(drawingRectangle){
            if(oldX < currentX && oldY < currentY){
                Rectangle2D.Double r = new Rectangle2D.Double(oldX,oldY,currentX - oldX,currentY - oldY);
                g2d.draw(r);
            }

        }
    }

    public void clear() {
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        drawingLine = false;
        drawingRectangle = false;
        repaint();
    }

    public void red() {
        color = Color.red;
        g2.setPaint(color);
    }
    public void black() {
        color = Color.BLACK;
        g2.setPaint(color);
    }
    public void magenta() {
        color = Color.magenta;
        g2.setPaint(color);
    }
    public void green() {
        color = Color.green;
        g2.setPaint(color);
    }
    public void blue() {
        color = Color.blue;
        g2.setPaint(color);
    }
    public void incStroke(int strokeWidth) {
        stroke = strokeWidth;
        g2.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
    }
    public void decStroke(int strokeWidth) {
        stroke = strokeWidth;
        g2.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
    }
    public void setTool(String name) {
        tool = name;
    }

    public void drawCircle() {
    }

    public void drawTriangle() {
    }

    public void drawRectangle() {

    }
}
