import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class DrawingCanvas extends JComponent {
    private int width;
    private int height;
    private Ellipse ellipse;
    private int ellipseX;
    private int ellipseY;
    private boolean isDragging;

    public DrawingCanvas(int width, int height) {
        this.width = width;
        this.height = height;
        ellipse = new Ellipse(50, 50);
        ellipseX = 50;
        ellipseY = 50;
        isDragging = false;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                if (ellipse.contains(mouseX, mouseY)) {
                    isDragging = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isDragging = false;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isDragging) {
                    int mouseX = e.getX();
                    int mouseY = e.getY();
                    ellipseX = mouseX;
                    ellipseY = mouseY;
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double r = new Rectangle2D.Double(0, 0, width, height);

        g2d.setColor(Color.WHITE);
        g2d.fill(r);
        ellipse.setCenter(ellipseX, ellipseY);
        ellipse.drawEllipse(g2d);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing Canvas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawingCanvas canvas = new DrawingCanvas(1280, 960);
        frame.getContentPane().add(canvas);
        frame.setSize(1280, 960);
        frame.setVisible(true);
    }
}





