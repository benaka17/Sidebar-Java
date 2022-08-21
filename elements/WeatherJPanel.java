package Sidebar_Programm.elements;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WeatherJPanel {

    //Panel
    JPanel weatherJPanel;

    //GUI Elemente:
    private JLabel tempJLabel;
    private JLabel weatherIconJLabel;
    private JLabel locationJLabel;
    private JButton updateJButton;

    //Variablen:
    private final String ID = "4b46d1fef83f3457391d6c82127a6b38";
    private final String LOCATION = "Zürich, CH";
    private final String LANGUAGE = "de";

    //Wetterdaten:
    private String weatherIconIDString;
    private String weatherDescription;
    private double weatherTemp;

    //URL:
    private String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + ID + "&units=Metric" + "&lang=de";

    // Daten in eine Map umwandeln
    private Map<String, Object> jsonToMap(String string) {

        Map<String, Object> map = new Gson().fromJson(string, new TypeToken<HashMap<String, Object>>(){
        }.getType());

        return map;
    }

    //Konstruktor
    public WeatherJPanel(){

        //JPanel erstellen
        weatherJPanel = new JPanel();
        weatherJPanel.setPreferredSize(new Dimension(150,150));
        BoxLayout boxLayout = new BoxLayout(weatherJPanel,BoxLayout.Y_AXIS);
        weatherJPanel.setLayout(boxLayout);

        //Wetter Daten laden:
        getWeatherData();

        //GUI
        setGUI();

        //Update Button
        setUpdateButton();

        //Add to Panel = alles ins Panel einfügen
        addToJPanel();

    }

    private void getWeatherData(){

        try {

            //Verbindung aufbauen
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();

            //Reader erstellen zum Daten auslesen, aus Java.io (input/output library)
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String lString;

            //Daten auslesen
            while ((lString = bufferedReader.readLine()) != null){ //solange Daten vorhanden sind, die Daten einlesen
                result.append(lString); //die Daten in result Variable hineinladen
            }

            System.out.println("Ergebnis: " + result);

            bufferedReader.close();

            //Wetter aus result auslesen und strukturieren
            Map<String, Object> resultMap = jsonToMap(result.toString());
            Map<String, Object> mainMap = jsonToMap(resultMap.get("main").toString());
            Map<String, Object> windMap = jsonToMap(resultMap.get("wind").toString());


            System.out.println(mainMap);
            System.out.println(mainMap.get("temp"));
            System.out.println(mainMap.get("pressure"));
            System.out.println(windMap.get("speed"));


            ArrayList<Map<String, Object>> weather = (ArrayList<Map<String, Object>>) resultMap.get("weather");
            Map<String, Object> weatherMap = weather.get(0);


            System.out.println(weatherMap.get("id"));
            System.out.println(weatherMap.get("description"));


            weatherIconIDString = String.valueOf(weatherMap.get("id"));
            weatherDescription = (String) weatherMap.get("description");
            weatherTemp = (double) mainMap.get("temp");

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private void setGUI(){

        //Um die Bilder von der Website zu holen
        ImageIcon imageIcon = new ImageIcon();
        try {
            imageIcon = new ImageIcon(new URL("http://openweathermap.org/img/w/" + weatherIconIDString + ".png"));
        } catch (Exception e){
            e.printStackTrace();
        }

        //Die Temperatur in °C anzeigen
        tempJLabel = new JLabel(weatherTemp + "°C");
        tempJLabel.setFont(new Font("Arial",Font.BOLD,14));
        tempJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tempJLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

        //Das Wetter mit einem kleinen Bild anzeigen
        weatherIconJLabel = new JLabel(weatherDescription);
        weatherIconJLabel.setFont(new Font("Arial",Font.PLAIN,10));
        weatherIconJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        weatherIconJLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        weatherIconJLabel.setIcon(imageIcon);

        //Die Stadt anzeigen
        locationJLabel = new JLabel(LOCATION);
        locationJLabel.setFont(new Font("Arial",Font.PLAIN,10));
        locationJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        locationJLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

    }

    private void setUpdateButton(){

        //Button initialisieren
        updateJButton = new JButton("Update");
        updateJButton.setFont(new Font("Arial",Font.PLAIN,10));
        updateJButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateJButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        updateJButton.setPreferredSize(new Dimension(100,20));

        //ActionListener durch Lambda hinzufügen
        updateJButton.addActionListener(e -> {
            getWeatherData();
            setGUI();
        });

    }

    private void addToJPanel(){

        //Alle Elemente in ein (einziges) Panel einfügen
        weatherJPanel.add(tempJLabel);
        weatherJPanel.add(weatherIconJLabel);
        weatherJPanel.add(locationJLabel);
        weatherJPanel.add(updateJButton);

    }

    //Getter Setter für das Panel, um es zur Sidebar hinzufügen zu können
    public JPanel getWeatherJPanel() {
        return weatherJPanel;
    }
    public void setWeatherJPanel(JPanel weatherJPanel) {
        this.weatherJPanel = weatherJPanel;
    }

}