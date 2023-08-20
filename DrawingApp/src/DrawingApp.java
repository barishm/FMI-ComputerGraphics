
import UI.ColorButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DrawingApp {
    public static void main(String[] args) {

        new DrawingApp().show();
    }

    JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magentaBtn;
    JRadioButton fillBn,penBn,lineBn,circleBn,triangleBn,rectBn;
    JSlider slider;
    DrawArea drawArea;
    ChangeListener changeListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            if(e.getSource() == slider){
                drawArea.setStroke(slider.getValue());
            }
        }
    };
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
            } else if (e.getSource() == penBn) {
                drawArea.setTool(penBn.getText());
            } else if (e.getSource() == lineBn) {
                drawArea.setTool(lineBn.getText());
            } else if (e.getSource() == circleBn) {
                drawArea.drawCircle();
            } else if (e.getSource() == triangleBn) {
                drawArea.drawTriangle();
            } else if (e.getSource() == rectBn) {
                drawArea.setTool(rectBn.getText());
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


        JPanel othersPanel = new JPanel();
        createOthersPanel(othersPanel);

        JPanel toolsPanel = new JPanel();
        createToolsPanel(toolsPanel);


        controls.add(othersPanel, BorderLayout.EAST);
        controls.add(toolsPanel,BorderLayout.CENTER);

        content.add(controls, BorderLayout.NORTH);
        content.add(colorsPanel, BorderLayout.WEST);

        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void createToolsPanel(JPanel objectsPanel) {
        objectsPanel.setLayout(new BorderLayout());
        JPanel topButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel bottomButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        slider = new JSlider(0,20,2);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(1);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(2);
        slider.setPaintLabels(true);
        slider.addChangeListener(changeListener);
        fillBn = new JRadioButton("Fill");
        fillBn.setForeground(Color.red);
        penBn = new JRadioButton("Pen",true);
        lineBn = new JRadioButton("Line");
        rectBn = new JRadioButton("Rectangle");
        circleBn = new JRadioButton("Circle");
        triangleBn = new JRadioButton("Triangle");
        fillBn.addActionListener(actionListener);
        penBn.addActionListener(actionListener);
        lineBn.addActionListener(actionListener);
        rectBn.addActionListener(actionListener);
        circleBn.addActionListener(actionListener);
        triangleBn.addActionListener(actionListener);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(penBn);
        buttonGroup.add(lineBn);
        buttonGroup.add(rectBn);
        buttonGroup.add(circleBn);
        buttonGroup.add(triangleBn);

        topButtonsPanel.add(fillBn);
        topButtonsPanel.add(penBn);
        topButtonsPanel.add(lineBn);

        bottomButtonsPanel.add(slider);
        topButtonsPanel.add(circleBn);
        topButtonsPanel.add(triangleBn);
        bottomButtonsPanel.add(rectBn);
        objectsPanel.add(topButtonsPanel, BorderLayout.NORTH);
        objectsPanel.add(bottomButtonsPanel, BorderLayout.SOUTH);
    }

    private void createOthersPanel(JPanel othersPanel) {
        othersPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(actionListener);
        othersPanel.add(clearBtn);

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
}
