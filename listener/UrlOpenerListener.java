package Sidebar_Programm.listener;

import Sidebar_Programm.utilities.Utilities;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UrlOpenerListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        JButton jButton = (JButton) e.getSource();
        String textString = jButton.getActionCommand();

        String urlString;

        switch (textString){
            case "facebook":
                urlString = "www.facebook.com";
                Utilities.openUrl(urlString);
                break;
            case "amazon":
                urlString = "www.amazon.de";
                Utilities.openUrl(urlString);
                break;
            case "twitter":
                urlString = "www.twitter.com";
                Utilities.openUrl(urlString);
                break;
            case "youtube":
                urlString = "www.youtube.com";
                Utilities.openUrl(urlString);
                break;
            default:
                urlString = "www.google.ch";
                Utilities.openUrl(urlString);
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
