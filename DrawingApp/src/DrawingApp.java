
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

    JButton clearBtn, saveBtn, blackBtn, blueBtn, greenBtn, redBtn, customBtn;
    JRadioButton fillBn,penBn,lineBn,circleBn,triangleBn, rightTriangleBn, rectBn, pentagonBn, hexagonBn, houseBn, zadBn;
    JSlider slider;
    JColorChooser jColorChooser;
    Color color;
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
            } else if (e.getSource() == saveBtn) {
                System.out.println("TODO");
            } else if (e.getSource() == customBtn) {
                jColorChooser = new JColorChooser();
                color = JColorChooser.showDialog(null,"Pick a color",Color.black);
                drawArea.setColor(color);
            } else if (e.getSource() == blackBtn) {
                drawArea.setColor(Color.BLACK);
            } else if (e.getSource() == blueBtn) {
                drawArea.setColor(Color.blue);
            } else if (e.getSource() == greenBtn) {
                drawArea.setColor(Color.green);
            } else if (e.getSource() == redBtn) {
                drawArea.setColor(Color.red);
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
        controls.add(colorsPanel,BorderLayout.WEST);

        content.add(controls, BorderLayout.NORTH);

        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void createToolsPanel(JPanel toolsPanel) {
        toolsPanel.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

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
        rightTriangleBn = new JRadioButton("Right Triangle");
        pentagonBn = new JRadioButton("Pentagon");
        hexagonBn = new JRadioButton("Hexagon");
        houseBn = new JRadioButton("House");
        zadBn = new JRadioButton("Zad");
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
        buttonGroup.add(rightTriangleBn);
        buttonGroup.add(pentagonBn);
        buttonGroup.add(hexagonBn);
        buttonGroup.add(houseBn);
        buttonGroup.add(zadBn);

        topPanel.add(fillBn);
        topPanel.add(penBn);
        topPanel.add(lineBn);
        topPanel.add(circleBn);
        topPanel.add(triangleBn);
        topPanel.add(rightTriangleBn);
        topPanel.add(zadBn);

        bottomPanel.add(slider);
        bottomPanel.add(rectBn);
        bottomPanel.add(pentagonBn);
        bottomPanel.add(hexagonBn);
        bottomPanel.add(houseBn);


        toolsPanel.add(topPanel, BorderLayout.NORTH);
        toolsPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void createOthersPanel(JPanel othersPanel) {
        othersPanel.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(actionListener);
        saveBtn = new JButton("Save");
        saveBtn.addActionListener(actionListener);

        buttonPanel.add(Box.createVerticalStrut(8));
        buttonPanel.add(saveBtn);
        buttonPanel.add(Box.createVerticalStrut(13));
        buttonPanel.add(clearBtn);
        buttonPanel.add(Box.createVerticalStrut(2));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        othersPanel.add(buttonPanel, BorderLayout.CENTER);
    }


    private void createColorsPanel(JPanel colorsPanel) {
        colorsPanel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        blackBtn = new ColorButton(Color.BLACK);
        blackBtn.addActionListener(actionListener);
        blueBtn = new ColorButton(Color.BLUE);
        blueBtn.addActionListener(actionListener);
        greenBtn = new ColorButton(Color.GREEN);
        greenBtn.addActionListener(actionListener);
        redBtn = new ColorButton(Color.RED);
        redBtn.addActionListener(actionListener);
        customBtn = new JButton("Custom");
        customBtn.addActionListener(actionListener);

        topPanel.add(blackBtn);
        topPanel.add(blueBtn);
        topPanel.add(greenBtn);
        topPanel.add(redBtn);
        bottomPanel.add(customBtn);

        colorsPanel.setBorder(BorderFactory.createEmptyBorder(8, 10, 7, 10));
        colorsPanel.add(topPanel, BorderLayout.NORTH);
        colorsPanel.add(bottomPanel, BorderLayout.SOUTH);
    }
}
