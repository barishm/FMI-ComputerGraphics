import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public class DrawingCanvas extends JComponent {
    private int width;
    private int height;
    private Ellipse ellipse;

    private boolean isDraggingEllipse;
    private Rectangle rectangle;
    private boolean isDraggingRectangle;
    private Heart heart;
    private boolean isDraggingHeart;
    private Cloud cloud;
    private boolean isDraggingCloud;
    private PineTree pineTree;
    private boolean isDraggingPineTree;
    private Sun sun;
    private boolean isDraggingSun;
    private House house;
    private boolean isDraggingHouse;
    private Tree tree;
    private boolean isDraggingTree;
    private N5 n5;
    private boolean isDraggingN5;


    public DrawingCanvas(int width, int height) {
        this.width = width;
        this.height = height;
        ellipse = new Ellipse(1000, 400);
        rectangle = new Rectangle(50,300);
        heart = new Heart(140,50);
        cloud = new Cloud(500,50);
        pineTree = new PineTree(950,850);
        sun = new Sun(950,100);
        house = new House(50,700,Color.PINK);
        tree = new Tree(100,500,850);
        n5 = new N5(400,300);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();
                isDraggingHeart = false;
                isDraggingRectangle = false;
                isDraggingEllipse = false;
                isDraggingCloud = false;
                isDraggingPineTree = false;
                isDraggingSun = false;
                isDraggingHouse = false;
                isDraggingTree = false;
                isDraggingN5 = false;
                if (ellipse.contains(mouseX, mouseY)) {
                    isDraggingEllipse = true;
                } else if(rectangle.contains(mouseX,mouseY)){
                    isDraggingRectangle = true;
                }else if(heart.contains(mouseX,mouseY)){
                    isDraggingHeart = true;
                }else if(cloud.contains(mouseX,mouseY)){
                    isDraggingCloud = true;
                }else if(pineTree.contains(mouseX,mouseY)){
                    isDraggingPineTree = true;
                }else if(sun.contains(mouseX,mouseY)){
                    isDraggingSun = true;
                }else if(house.contains(mouseX,mouseY)){
                    isDraggingHouse = true;
                }else if(tree.contains(mouseX,mouseY)){
                    isDraggingTree = true;
                }else if(n5.contains(mouseX,mouseY)){
                    isDraggingN5 = true;
                }
            }


        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();
                if (isDraggingEllipse) {
                    ellipse.setX(mouseX);
                    ellipse.setY(mouseY);
                    repaint();
                } else if(isDraggingRectangle){
                    rectangle.setX(mouseX);
                    rectangle.setY(mouseY);
                    repaint();
                } else if (isDraggingHeart) {
                    heart.setX(mouseX);
                    heart.setY(mouseY);
                    repaint();
                } else if(isDraggingCloud){
                    cloud.setX(mouseX);
                    cloud.setY(mouseY);
                    repaint();
                }else if(isDraggingPineTree){
                    pineTree.setX(mouseX);
                    pineTree.setY(mouseY);
                    repaint();
                }else if(isDraggingSun){
                    sun.setX(mouseX);
                    sun.setY(mouseY);
                    repaint();
                }else if(isDraggingHouse){
                    house.setX(mouseX);
                    house.setY(mouseY);
                    repaint();
                }else if(isDraggingTree){
                    tree.setX(mouseX);
                    tree.setY(mouseY);
                    repaint();
                }else if(isDraggingN5){
                    n5.setX(mouseX);
                    n5.setY(mouseY);
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double r = new Rectangle2D.Double(0,0,1280,960);

        g2d.setColor(new Color(0,150,240));
        g2d.fill(r);
        g2d.setColor(new Color(0, 46, 0));

        Path2D.Double m1 = new Path2D.Double();
        Path2D.Double m2 = new Path2D.Double();
        m1.moveTo(0,800);
        m1.curveTo(-300,900,450,400,700,800);
        m1.lineTo(700,height);
        m1.lineTo(0,height);
        m1.closePath();
        g2d.fill(m1);
        m2.moveTo(400,800);
        m2.curveTo(200,900,1000,400,this.width,800);
        m2.lineTo(this.width,this.height);
        m2.lineTo(400,this.height);
        m2.closePath();
        g2d.fill(m2);


        ellipse.drawEllipse(g2d);
        rectangle.drawRectangle(g2d);
        heart.drawHeart(g2d);
        cloud.drawCloud(g2d);
        pineTree.drawPineTree(g2d);
        sun.drawSun(g2d);
        house.drawHouse(g2d);
        tree.drawTree(g2d);
        n5.drawN5(g2d);



    }

}
