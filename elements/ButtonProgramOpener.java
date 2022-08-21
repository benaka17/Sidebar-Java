package Sidebar_Programm.elements;

import Sidebar_Programm.utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonProgramOpener {

    private JButton jButton;

    public ButtonProgramOpener(){

        jButton = new JButton("Programm öffnen");
        jButton.setPreferredSize(new Dimension(140,40));

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Filechooser öffnen
                JFileChooser jFileChooser = new JFileChooser();
                int returnValue = jFileChooser.showOpenDialog(null);

                String pathString;

                //Pfad aus der Datei lesen
                if (returnValue == JFileChooser.CANCEL_OPTION){
                    pathString = jFileChooser.getSelectedFile().getAbsolutePath();
                    Utilities.startProgram(pathString);
                } else {
                    System.out.println("Guess not");
                }
            }
        });

    }

    public JButton getjButton() {
        return jButton;
    }

    public void setjButton(JButton jButton) {
        this.jButton = jButton;
    }

}
