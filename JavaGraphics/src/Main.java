import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int w = 1024;
        int h = 768;
        JFrame f = new JFrame();
        // JFrame e window-based interface koyto idva ot paketa javax.swing.

        DrawingCanvas dc = new DrawingCanvas(w,h);
        // tuk suzdavame instanciq zadavayki shirina i visochina na poleto koeto shte risuvame.

        f.setSize(w,h);
        //tuk setvame shirina i visochina na JFrame.

        f.setTitle("Drawing in Java");
        // tuk zadavame imeto na prozoreca

        f.add(dc);
        // tuk dobavqme narisuvanoto v instanciqta DrawingCanvas.

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // tuk zadavame che iskame programa da spre sled kato zatvorim prozoreca JFrame.

        f.setVisible(true);
        // tuk zadavame che iskame prozoreca da e vidim sled startiraneto na programata.
    }
}