package Sidebar_Programm.utilities;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Utilities {

    public static void openUrl(String urlString){
        try {
            Desktop.getDesktop().browse(new URL("https://" + urlString).toURI());
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"URL unbekannt");
            e.printStackTrace();
        }
    }

    public static void startProgram(String path){

        try {
            Process process = Runtime.getRuntime().exec(path);
            try {
                Thread.sleep(5000);
            } catch (Exception e){
                e.printStackTrace();
            }
            process.destroy();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Programmpfad nicht gefunden");
            e.printStackTrace();
        }

    }

}
