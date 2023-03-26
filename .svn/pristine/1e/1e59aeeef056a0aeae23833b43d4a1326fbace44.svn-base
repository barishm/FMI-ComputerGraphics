import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class DrawingCanvas extends JComponent {
    private int width;
    private int height;
    private Sky sky;
    private Cloud c1;
    private Cloud c2;
    private Cloud c3;
    private Sun sun;
    private Mountain mountain;

    public DrawingCanvas(int width, int height) {
        this.width = width;
        this.height = height;
        sky = new Sky(0,0,1024,768,new Color(40, 100, 255));
        c1 = new Cloud(100,50,70,Color.WHITE);
        c2 = new Cloud(250,50,90,Color.WHITE);
        c3 = new Cloud(490,50,85,Color.WHITE);
        sun = new Sun(850,5,150,Color.YELLOW);
        mountain = new Mountain(width,height,new Color(0, 40, 0));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //ANTIALIASING
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING
                ,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);


        //DRAW RECTANGLE
        //Rectangle2D.Double r = new Rectangle2D.Double(50,75,100,250);
        //g2d.setColor(new Color(100,149,237));
        //g2d.fill(r);

        //DRAW CIRCLE
        //Ellipse2D.Double e = new Ellipse2D.Double(100,100,100,100);
        //g2d.setColor(Color.black);
        //g2d.fill(e);

        //DRAW LINE
        //Line2D.Double line = new Line2D.Double(100,200,300,400);
        //g2d.setColor(Color.black);
        //g2d.draw(line);
        sky.drawSky(g2d);
        c1.drawCloud(g2d);
        c2.drawCloud(g2d);
        c3.drawCloud(g2d);
        sun.drawSun(g2d);
        mountain.drawMountain(g2d);





    }
}
