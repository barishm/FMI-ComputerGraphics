import javax.swing.*;
import java.awt.*;

public class ColorButton extends JButton {
    private final Color color;

    public ColorButton(Color color) {
        this.color = color;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setPreferredSize(new Dimension(20, 20));
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
