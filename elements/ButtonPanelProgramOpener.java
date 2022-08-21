package Sidebar_Programm.elements;

import Sidebar_Programm.listener.ProgramOpenerListener;
import Sidebar_Programm.listener.UrlOpenerListener;
import Sidebar_Programm.model.IconButton;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ButtonPanelProgramOpener {

    private JPanel jPanelProgramOpener;

    private final String[] iconStrings = {"eclipse","firefox","mail","textedit"};

    public ButtonPanelProgramOpener(){

        jPanelProgramOpener = new JPanel();
        jPanelProgramOpener.setLayout(new GridLayout(2,2,5,5));

        for (String iconName : iconStrings) {
            IconButton iconButton = new IconButton(iconName,"2",iconName);
            iconButton.setBorder(new LineBorder(Color.BLACK));

            //Listener
            iconButton.addMouseListener(new ProgramOpenerListener());

            jPanelProgramOpener.add(iconButton);
        }

    }

    public JPanel getjPanelProgramOpener() {
        return jPanelProgramOpener;
    }

    public void setjPanelProgramOpener(JPanel jPanelProgramOpener) {
        this.jPanelProgramOpener = jPanelProgramOpener;
    }

}