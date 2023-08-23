
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

    JButton clearBtn, saveBtn, applyBtn, cancelBtn,sizePlusBtn,sizeMinusBtn,rBtn,lBtn, blackBtn, blueBtn, greenBtn, redBtn, customBtn;
    JRadioButton fillBn,penBn,lineBn,circleBn,triangleBn, rightTriangleBn, rectBn, pentagonBn, hexagonBn, houseBn, zadBn;
    JSlider strokeSlider, opacitySlider;
    JColorChooser jColorChooser;
    Color color;
    DrawArea drawArea;
    ChangeListener changeListener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            if(e.getSource() == strokeSlider){
                drawArea.setStroke(strokeSlider.getValue());
            }
            if (e.getSource() == opacitySlider) {
                drawArea.setOpacity(opacitySlider.getValue());
            }
        }
    };
    ActionListener actionListener = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {
                drawArea.clear();
            } else if (e.getSource() == saveBtn) {
                System.out.println("TODO");
            } else if (e.getSource() == sizePlusBtn) {
                drawArea.increaseSize();
            } else if (e.getSource() == sizeMinusBtn) {
                drawArea.decreaseSize();
            } else if (e.getSource() == lBtn) {
                drawArea.rotateLeft();
            } else if (e.getSource() == rBtn) {
                drawArea.rotateRight();
            } else if (e.getSource() == applyBtn) {
                drawArea.apply();
            } else if (e.getSource() == cancelBtn) {
                drawArea.cancel();
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
                drawArea.setTool(circleBn.getText());
            } else if (e.getSource() == triangleBn) {
                drawArea.setTool(triangleBn.getText());
            } else if (e.getSource() == rectBn) {
                drawArea.setTool(rectBn.getText());
            }
            if(e.getSource() == fillBn){
                drawArea.setFill(fillBn.isSelected());
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

        frame.setSize(1440, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.requestFocus();
        drawArea.requestFocus();
    }

    private void createToolsPanel(JPanel toolsPanel) {
        toolsPanel.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        strokeSlider = new JSlider(0,30,2);
        strokeSlider.setPaintTicks(true);
        strokeSlider.setMinorTickSpacing(2);
        strokeSlider.setPaintTrack(true);
        strokeSlider.setMajorTickSpacing(4);
        strokeSlider.setPaintLabels(true);
        strokeSlider.addChangeListener(changeListener);
        opacitySlider = new JSlider(0,255,255);

        opacitySlider.setPaintTicks(true);
        opacitySlider.setMinorTickSpacing(17);
        opacitySlider.setPaintTrack(true);
        opacitySlider.setMajorTickSpacing(85);
        opacitySlider.setPaintLabels(true);
        opacitySlider.addChangeListener(changeListener);

        fillBn = new JRadioButton("Fill");
        fillBn.setForeground(Color.red);
        Font customFont = fillBn.getFont().deriveFont(Font.BOLD, 14f);
        fillBn.setFont(customFont);
        sizePlusBtn = new JButton("+");
        sizeMinusBtn = new JButton("-");
        lBtn = new JButton("<<");
        rBtn = new JButton(">>");
        applyBtn = new JButton(" Apply ");
        applyBtn.addActionListener(actionListener);
        cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(actionListener);
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
        sizePlusBtn.addActionListener(actionListener);
        sizeMinusBtn.addActionListener(actionListener);
        lBtn.addActionListener(actionListener);
        rBtn.addActionListener(actionListener);
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

        topPanel.add(penBn);
        topPanel.add(lineBn);
        topPanel.add(circleBn);
        topPanel.add(triangleBn);
        topPanel.add(rightTriangleBn);
        topPanel.add(rectBn);
        topPanel.add(pentagonBn);
        topPanel.add(hexagonBn);
        topPanel.add(zadBn);
        topPanel.add(houseBn);

        bottomPanel.add(new JLabel("Width:"));
        bottomPanel.add(strokeSlider);
        bottomPanel.add(new JLabel("Opacity:"));
        bottomPanel.add(opacitySlider);
        bottomPanel.add(fillBn);
        bottomPanel.add(sizePlusBtn);
        bottomPanel.add(sizeMinusBtn);
        bottomPanel.add(lBtn);
        bottomPanel.add(rBtn);
        bottomPanel.add(applyBtn);
        bottomPanel.add(cancelBtn);

        toolsPanel.add(topPanel, BorderLayout.NORTH);
        toolsPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void createOthersPanel(JPanel othersPanel) {
        othersPanel.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(actionListener);
        saveBtn = new JButton("Save");
        saveBtn.addActionListener(actionListener);


        topPanel.add(saveBtn);
        bottomPanel.add(clearBtn);

        othersPanel.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        othersPanel.add(topPanel, BorderLayout.NORTH);
        othersPanel.add(bottomPanel,BorderLayout.SOUTH);
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

        colorsPanel.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        colorsPanel.add(topPanel, BorderLayout.NORTH);
        colorsPanel.add(bottomPanel, BorderLayout.SOUTH);
    }
}
