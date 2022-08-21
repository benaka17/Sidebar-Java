package Sidebar_Programm.elements;

import Sidebar_Programm.model.IconButton;
import Sidebar_Programm.listener.UrlOpenerListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ButtonPaneUrl extends JFrame {

    private JPanel buttonUrlPanel; //Container für Buttons

    private final String[] iconStrings = {"facebook","twitter","amazon","youtube"};

    public ButtonPaneUrl(){

        buttonUrlPanel = new JPanel();
        //BoxLayout boxLayout = new BoxLayout(buttonUrlPanel,BoxLayout.PAGE_AXIS);
        buttonUrlPanel.setLayout(new GridLayout(2,2,5,5));
        buttonUrlPanel.setBorder(new LineBorder(Color.BLACK));

        for (String iconName : iconStrings) {
            IconButton iconButton = new IconButton(iconName,"1",iconName);

            iconButton.addMouseListener(new UrlOpenerListener());

            buttonUrlPanel.add(iconButton);
        }

    }

    public JPanel getButtonUrlPanel() {
        return buttonUrlPanel;
    }

    public void setButtonUrlPanel(JPanel buttonUrlPanel) {
        this.buttonUrlPanel = buttonUrlPanel;
    }

    public String[] getIconStrings() {
        return iconStrings;
    }



}
