
import UI.ColorButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DrawingApp {

    JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magentaBtn,
            incStroke,decStroke,penBtn,lineBtn,circleBtn,triangleBtn,rectBtn;
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
            } else if (e.getSource() == circleBtn) {
                drawArea.drawCircle();
            } else if (e.getSource() == triangleBtn) {
                drawArea.drawTriangle();
            } else if (e.getSource() == rectBtn) {
                drawArea.setTool(rectBtn.getText());
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

        JPanel colorsPanel = new JPanel();
        createColorsPanel(colorsPanel);

        JPanel toolsPanel = new JPanel();
        createToolsPanel(toolsPanel);

        JPanel othersPanel = new JPanel();
        createOthersPanel(othersPanel);

        JPanel objectsPanel = new JPanel();
        createObjectsPanel(objectsPanel);


        controls.add(toolsPanel, BorderLayout.WEST);
        controls.add(othersPanel, BorderLayout.EAST);
        controls.add(objectsPanel,BorderLayout.CENTER);

        content.add(controls, BorderLayout.NORTH);
        content.add(colorsPanel, BorderLayout.WEST);

        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void createObjectsPanel(JPanel objectsPanel) {
        objectsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        circleBtn = new JButton("Circle");
        circleBtn.addActionListener(actionListener);
        triangleBtn = new JButton("Triangle");
        triangleBtn.addActionListener(actionListener);
        rectBtn = new JButton("Rectangle");
        rectBtn.addActionListener(actionListener);
        objectsPanel.add(circleBtn);
        objectsPanel.add(triangleBtn);
        objectsPanel.add(rectBtn);

    }

    private void createOthersPanel(JPanel othersPanel) {
        othersPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(actionListener);
        othersPanel.add(clearBtn);

    }

    private void createToolsPanel(JPanel toolsPanel) {
        toolsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
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
        toolsPanel.add(penBtn);
        toolsPanel.add(lineBtn);
        toolsPanel.add(incStroke);
        toolsPanel.add(strokeText);
        toolsPanel.add(strokeLabel);
        toolsPanel.add(decStroke);

    }

    private void createColorsPanel(JPanel colorsPanel) {
        colorsPanel.setLayout(new BoxLayout(colorsPanel, BoxLayout.Y_AXIS));
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
        colorsPanel.add(blackBtn);
        colorsPanel.add(blueBtn);
        colorsPanel.add(greenBtn);
        colorsPanel.add(redBtn);
        colorsPanel.add(magentaBtn);
    }

    private void updateStrokeLabel() {
        strokeLabel.setText(String.valueOf(strokeWidth));
    }

}
