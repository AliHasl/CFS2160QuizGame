package Version2;

import javax.swing.*;
import java.awt.event.*;

public class PopUpAudience extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JProgressBar option1Bar;
    private JProgressBar option4Bar;
    private JProgressBar option2Bar;
    private JProgressBar option3Bar;
    private JLabel option1label;
    private JLabel option2Label;
    private JLabel option3Label;

    public PopUpAudience() {
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

    GeneralGUI questions = new GeneralGUI();
        option1Bar.setMaximum(100);
        option2Bar.setMaximum(100);
        option3Bar.setMaximum(100);
        option4Bar.setMaximum(100);
        //option1label.setText(questions);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        PopUpAudience dialog = new PopUpAudience();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
