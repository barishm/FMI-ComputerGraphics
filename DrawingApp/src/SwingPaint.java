
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SwingPaint {

    JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magentaBtn,incStroke,decStroke,penBtn,lineBtn;
    JLabel strokeLabel,strokeText;
    int strokeWidth = 1;
    DrawArea drawArea;
    ActionListener actionListener = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {
                drawArea.clear();
            } else if (e.getSource() == blackBtn) {
                drawArea.black();
            } else if (e.getSource() == blueBtn) {
                drawArea.blue();
            } else if (e.getSource() == greenBtn) {
                drawArea.green();
            } else if (e.getSource() == redBtn) {
                drawArea.red();
            } else if (e.getSource() == magentaBtn) {
                drawArea.magenta();
            } else if(e.getSource() == incStroke){
                strokeWidth++;
                updateStrokeLabel();
                drawArea.incStroke(strokeWidth);
            } else if(e.getSource() == decStroke && strokeWidth > 1){
                strokeWidth--;
                updateStrokeLabel();
                drawArea.decStroke(strokeWidth);
            } else if (e.getSource() == penBtn) {
                drawArea.setTool(penBtn.getText());
            } else if (e.getSource() == lineBtn) {
                drawArea.setTool(lineBtn.getText());
            }
        }
    };


    public void show() {
        JFrame frame = new JFrame("Swing Paint");
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        drawArea = new DrawArea();

        content.add(drawArea, BorderLayout.CENTER);

        JPanel controls = new JPanel();
        controls.setLayout(new BorderLayout());

        JPanel colorButtonsPanel = new JPanel();
        colorButtonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        blackBtn = new ColorButton(Color.BLACK);
        blackBtn.addActionListener(actionListener);
        blueBtn = new ColorButton(Color.BLUE);
        blueBtn.addActionListener(actionListener);
        greenBtn = new ColorButton(Color.GREEN);
        greenBtn.addActionListener(actionListener);
        redBtn = new ColorButton(Color.RED);
        redBtn.addActionListener(actionListener);
        magentaBtn = new ColorButton(Color.MAGENTA);
        magentaBtn.addActionListener(actionListener);
        colorButtonsPanel.add(blackBtn);
        colorButtonsPanel.add(blueBtn);
        colorButtonsPanel.add(greenBtn);
        colorButtonsPanel.add(redBtn);
        colorButtonsPanel.add(magentaBtn);

        JPanel toolsButtonsPanel = new JPanel();
        toolsButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        incStroke = new JButton("+");
        incStroke.addActionListener(actionListener);
        decStroke = new JButton("-");
        decStroke.addActionListener(actionListener);
        strokeLabel = new JLabel("1");
        strokeText = new JLabel("Width:");
        penBtn = new JButton("Pen");
        penBtn.addActionListener(actionListener);
        lineBtn = new JButton("Line");
        lineBtn.addActionListener(actionListener);
        toolsButtonsPanel.add(penBtn);
        toolsButtonsPanel.add(lineBtn);
        toolsButtonsPanel.add(incStroke);
        toolsButtonsPanel.add(strokeText);
        toolsButtonsPanel.add(strokeLabel);
        toolsButtonsPanel.add(decStroke);

        JPanel clearButtonPanel = new JPanel();
        clearButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(actionListener);
        clearButtonPanel.add(clearBtn);

        controls.add(colorButtonsPanel, BorderLayout.WEST);
        controls.add(toolsButtonsPanel, BorderLayout.CENTER);
        controls.add(clearButtonPanel, BorderLayout.EAST);

        content.add(controls, BorderLayout.NORTH);

        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private void updateStrokeLabel() {
        strokeLabel.setText(String.valueOf(strokeWidth));
    }

}
