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
    private Ground ground;
    private House house;
    private Tree tree;
    private PineTree pineTree1;
    private PineTree pineTree2;
    private PineTree pineTree3;
    private PineTree pineTree4;
    public DrawingCanvas(int width, int height) {
        this.width = width;
        this.height = height;
        sky = new Sky(0,0,1024,768,new Color(40, 100, 255));
        c1 = new Cloud(100,50,70,Color.WHITE);
        c2 = new Cloud(250,50,90,Color.WHITE);
        c3 = new Cloud(490,50,85,Color.WHITE);
        sun = new Sun(850,5,150,Color.YELLOW);
        mountain = new Mountain(width,height,new Color(0, 40, 0));
        ground = new Ground(width,height);
        house = new House(700,500,150,Color.orange);
        tree = new Tree(120,300,700);
        pineTree1 = new PineTree(50,500,400);
        pineTree2 = new PineTree(50,450,420);
        pineTree3 = new PineTree(50,400,350);
        pineTree4 = new PineTree(50,350,380);
        
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
        ground.drawGround(g2d);
        house.drawHouse(g2d);
        tree.drawTree(g2d);
        pineTree1.drawPineTree(g2d);
        pineTree2.drawPineTree(g2d);
        pineTree3.drawPineTree(g2d);
        pineTree4.drawPineTree(g2d);




    }
}
