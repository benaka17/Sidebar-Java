package Sidebar_Programm.elements;

import Sidebar_Programm.utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextFieldURLOpener {

    private JTextField jTextField;
    private JScrollPane jScrollPane;

    public TextFieldURLOpener(){

        jTextField = new JTextField("Type in a URL");
        jTextField.setFont(new Font("Arial", Font.ITALIC,14));

        jScrollPane = new JScrollPane(jTextField,
                                        ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
                                        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        jScrollPane.setPreferredSize(new Dimension(140,40));

        jTextField.addKeyListener(new KeyListener() {

            String urlString;

            @Override
            public void keyTyped(KeyEvent e) {

            }

            //if ENTER is pressed, the URL should open
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    if (jTextField.getText() != null){
                        urlString = jTextField.getText();
                        Utilities.openUrl(urlString);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

    public JTextField getjTextField() {
        return jTextField;
    }

    public void setjTextField(JTextField jTextField) {
        this.jTextField = jTextField;
    }

}
