import javax.swing.*;

public class main {
    public static void main(String[] args) {
        int w = 1280;
        int h = 960;
        JFrame f = new JFrame();
        DrawingCanvas dc = new DrawingCanvas(w,h);
        f.setSize(w,h);
        f.setTitle("Drawing in Java");
        f.add(dc);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
