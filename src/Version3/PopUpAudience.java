package Version3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PopUpAudience extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private GameController gc;
    private JProgressBar option1Bar;
    private JProgressBar option4Bar;
    private JProgressBar option2Bar;
    private JProgressBar option3Bar;
    private JLabel option1label;
    private JLabel option2Label;
    private JLabel option3Label;
    private JLabel option4Label;
    private ArrayList<String> options;
    private JFrame thisFrame;
    private int difficulty;
    private String answer;
    private int[] correctPercent;
    private int[] wrongPercent;

    public PopUpAudience(GameController gameController) {
        GameController gc = gameController;

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);



        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


        option1Bar.setMaximum(100);
        option2Bar.setMaximum(100);
        option3Bar.setMaximum(100);
        option4Bar.setMaximum(100);
        option1Bar.setForeground(Color.RED);
        option2Bar.setForeground(Color.GREEN);
        option3Bar.setForeground(Color.BLUE);
        option4Bar.setForeground(Color.YELLOW);


        option1label.setText(gc.getOptions().get(0));
        option2Label.setText(gc.getOptions().get(1));
        option3Label.setText(gc.getOptions().get(2));
        option4Label.setText(gc.getOptions().get(3));

        difficulty = Integer.parseInt(gc.getCurrentQuestion()[1]);
        answer = gc.getCurrentQuestion()[3];

        correctPercent = new int[] {70,50,40};
        wrongPercent = new int[]{30,50,60};

        System.out.println(answer);

        if(option1label.getText().equals(answer)){
            option1Bar.setValue(correctPercent[difficulty]);
            option2Bar.setValue(wrongPercent[difficulty]/3);
            option3Bar.setValue(wrongPercent[difficulty]/3);
            option4Bar.setValue(wrongPercent[difficulty]/3);
        }
        else if(option2Label.getText().equals(answer)) {
            option1Bar.setValue(wrongPercent[difficulty]/3);
            option2Bar.setValue(correctPercent[difficulty]);
            option3Bar.setValue(wrongPercent[difficulty] / 3);
            option4Bar.setValue(wrongPercent[difficulty] / 3);
        }
        else if(option3Label.getText().equals(answer)) {
            option1Bar.setValue(wrongPercent[difficulty]/3);
            option2Bar.setValue(wrongPercent[difficulty] / 3);
            option3Bar.setValue(correctPercent[difficulty]);
            option4Bar.setValue(wrongPercent[difficulty] / 3);
        }
        else{
                option1Bar.setValue(wrongPercent[difficulty] /3 );
                option2Bar.setValue(wrongPercent[difficulty] / 3);
                option3Bar.setValue(wrongPercent[difficulty] / 3);
                option4Bar.setValue(correctPercent[difficulty]);
            }

    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
/*
    public static void main(String[] args) {
        PopUpAudience dialog = new PopUpAudience();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
    */
}
