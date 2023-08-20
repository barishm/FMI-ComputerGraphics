
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComponent;


public class DrawArea extends JComponent {

    private Image image;
    private Graphics2D g2;
    private int currentX, currentY, oldX, oldY,stroke = 2;
    private String tool = "Pen";
    private Color color = Color.BLACK;
    private boolean drawingLine = false;
    private boolean drawingRectangle = false;



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
                g2.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
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
                        g2.drawRect(oldX,oldY,currentX - oldX,currentY - oldY);
                        repaint();
                        drawingRectangle = false;
                    }
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        Graphics2D tempG = (Graphics2D) g;
        tempG.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        tempG.setPaint(color);
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        tempG.drawImage(image, 0, 0, null);
        if(drawingLine){
            tempG.drawLine(oldX,oldY,currentX,currentY);
        }
        if(drawingRectangle){
            if(oldX < currentX && oldY < currentY){
                tempG.drawRect(oldX,oldY,currentX - oldX,currentY - oldY);
            }
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
    }

    public void setTool(String name) {
        tool = name;
    }

    public void setStroke(int value) {
        stroke = value;
        g2.setStroke(new BasicStroke(stroke, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
    }
}
