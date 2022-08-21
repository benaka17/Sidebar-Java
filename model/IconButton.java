package Sidebar_Programm.model;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class IconButton extends JButton {

    private final int BUTTON_WIDTH = 45;
    private final int BUTTON_HEIGHT = 45;

    public IconButton(String command, String imageFolder, String iconName){

        setupButton(command, imageFolder, iconName);

    }

    private void setupButton(String command, String imageFolder, String iconName){

        setActionCommand(command);
        setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        setToolTipText(command);

        URL imgUrl = getClass().getResource("/Sidebar_Programm/image" + imageFolder + "/" + iconName + ".png");

        if (imgUrl != null){
            ImageIcon icon = new ImageIcon(imgUrl);
            setIcon(icon);
        } else {
            setText(command);
            System.out.println("Bild konnte nicht geladen werden.");
        }

    }

}
