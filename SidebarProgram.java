package Sidebar_Programm;

import Sidebar_Programm.elements.*;

import javax.swing.*;
import java.awt.*;

public class SidebarProgram extends JFrame {

    //Elemente der Sidebar:
    private DigitalClock digitalClock;
    private ButtonPaneUrl buttonPaneUrl;
    private TextFieldURLOpener textFieldURLOpener;
    private ButtonPanelProgramOpener buttonPanelProgramOpener;
    private ButtonProgramOpener buttonProgramOpener;
    private WeatherJPanel weatherJPanel;

    //Spezifikationen für die Höhe und Breite der Applikation
    private final int SIDEBARWIDTH = 150;
    private final int SIDEBARHEIGHT = 600;

    private Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); //Bildschirmgrösse

    public SidebarProgram(){

        setTitle("Sidebar");
        setSize(new Dimension(SIDEBARWIDTH,SIDEBARHEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        digitalClock = new DigitalClock();
        buttonPaneUrl = new ButtonPaneUrl();
        textFieldURLOpener = new TextFieldURLOpener();
        buttonPanelProgramOpener = new ButtonPanelProgramOpener();
        buttonProgramOpener = new ButtonProgramOpener();
        weatherJPanel = new WeatherJPanel();

        setLayout();

        setVisible(true);
    }

    private void setLayout(){

        /* Für feste Positionierung
        int screenWidth = dimension.width;
        int screenHeight = dimension.height;
        setLocation(screenWidth - SIDEBARWIDTH - 40, 0);
        setAlwaysOnTop(true);
         */

        //Für die Uhr
        System.out.println("Bildschirmbreite ist: " + dimension.width +
                            "\nBildschirmhöhe ist: " + dimension.height);
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
        getContentPane().add(digitalClock.getTimeLabel());

        //Für die Links zu den Websiten
        getContentPane().add(buttonPaneUrl.getButtonUrlPanel());

        //Für den URL Opener
        createLabel("URL eingeben: ");
        getContentPane().add(textFieldURLOpener.getjTextField());

        //Für den Program Opener
        getContentPane().add(buttonPanelProgramOpener.getjPanelProgramOpener());

        //Für den Program Opener über den Button
        createLabel("Programm auswählen");
        getContentPane().add(buttonProgramOpener.getjButton());

        //Für das Wetter-Panel
        createLabel("Wetter Übersicht");
        getContentPane().add(weatherJPanel.getWeatherJPanel());

    }

    private void createLabel(String text){

        JLabel jLabel = new JLabel(text);
        jLabel.setFont(new Font("Arial", Font.PLAIN,12));
        getContentPane().add(jLabel);

    }

    public static void main(String[] args) {

        new SidebarProgram();

    }

}