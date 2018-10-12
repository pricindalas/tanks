package ktu.tanks.ui.components;

import ktu.tanks.MainCommands;

import javax.swing.*;
import java.awt.event.*;

public class UserLoginDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField usernameTextField;
    private JLabel usernameLabel;
    private JLabel errorLabel;

    private final MainCommands mainActivity;

    public UserLoginDialog(MainCommands mainAcitivty) {
        this.mainActivity = mainAcitivty;

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> {
            String username = usernameTextField.getText();
            if (username.length() > 1) {

                mainAcitivty.usernameEntered(usernameTextField.getText());
            }
        });

        buttonCancel.addActionListener(e -> mainActivity.usernameCanceled());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> dispose(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }
}
