package Version4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PopUpAudience extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JProgressBar option1Bar;
    private JProgressBar option4Bar;
    private JProgressBar option2Bar;
    private JProgressBar option3Bar;
    private JLabel option1label;
    private JLabel option2Label;
    private JLabel option3Label;
    private JLabel option4Label;
    private int difficulty;
    private String answer;
    private int[] correctPercent;
    private int[] wrongPercent;

    public PopUpAudience(GameController gameController) {
        GameController gc = gameController;

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.setFont(gameController.getTeletext());
        buttonOK.setForeground(Color.WHITE);
        option1label.setFont(gameController.getTeletext());
        option2Label.setFont(gameController.getTeletext());
        option3Label.setFont(gameController.getTeletext());
        option4Label.setFont(gameController.getTeletext());

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

        correctPercent = new int[] {70,50,30};
        wrongPercent = new int[]{30,50,70};

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

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

    }

    private void onOK() {
        // add your code here
        dispose();
    }

}
