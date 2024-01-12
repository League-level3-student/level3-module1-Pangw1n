package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a temperature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton searchCity = new JButton();
    JButton searchWeather = new JButton();
    JButton searchTemp = new JButton();
    
    HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
    
    void start() {
        
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(searchCity);
        panel.add(searchWeather);
        panel.add(searchTemp);
        searchCity.setText("Search for a city");
        searchWeather.setText("Search for a weather condition");
        searchTemp.setText("Search for a temperature range");
        searchCity.addActionListener(this);
        searchWeather.addActionListener(this);
        searchTemp.addActionListener(this);
        frame.pack();
        
        // All city keys have the first letter capitalized of each word
        //String cityName = Utilities.capitalizeWords( "san diego" );
        //WeatherData datum = weatherData.get(cityName);
        
        //if( datum == null ) {
        //    System.out.println("Unable to find weather data for: " + cityName);
        //} else {
        //	String output = cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F";
        //    System.out.println(output);
        //    JOptionPane.showMessageDialog(null, output);
        //}
    }
    
    //String output;
    
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) arg0.getSource();
		if (buttonPressed == searchCity)
		{
			String cityName = Utilities.capitalizeWords( JOptionPane.showInputDialog("Enter a city name: ") );
	        WeatherData datum = weatherData.get(cityName);
	        
	        if( datum == null ) {
	            System.out.println("Unable to find weather data for: " + cityName);
	        } else {
	        	String output = cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F";
	            System.out.println(output);
	            JOptionPane.showMessageDialog(null, output);
	        }
		}
		else if (buttonPressed == searchWeather)
		{
			String weather = Utilities.capitalizeWords( JOptionPane.showInputDialog("Enter a weather condition: ") );
	        ArrayList<String> datum = new ArrayList<String>();
	        for (String city : weatherData.keySet())
	        {
	        	if (weatherData.get(city).weatherSummary.equals(weather))
	        	{
	        		datum.add(city);
	        	}
	        }
	        
	        if( datum.size() == 0 ) {
	        	String output = "There are no cities with the weather: " + weather;
	            System.out.println(output);
	        	JOptionPane.showMessageDialog(null, output);
	        } else if (datum.size() == 1) {
	        	String output = datum.get(0) + " is the only city with " + weather + " weather";
	            System.out.println(output);
	            JOptionPane.showMessageDialog(null, output);
	        } else {
	        	System.out.print(datum.size());
	        	String output = "";
	        	for (int i = 0; i < datum.size(); i ++)
	        	{
	        		output = output + datum.get(i) + ", ";
	        		if (i >= 10 && i % 10 == 0)
	        		{
	        			output = output + "\n";
	        		}
        		}
        		output = output + "all have " + weather + " weather";
	            System.out.println(output);
	            JOptionPane.showMessageDialog(null, output);
	        }
		}
		else if (buttonPressed == searchTemp)
		{
			int minTemp = Integer.parseInt( JOptionPane.showInputDialog("Enter a minimum temperature: ") );
			int maxTemp = Integer.parseInt( JOptionPane.showInputDialog("Enter a maximum temperature: ") );
	        ArrayList<String> datum = new ArrayList<String>();
	        for (String city : weatherData.keySet())
	        {
	        	if (weatherData.get(city).temperatureF >= minTemp && weatherData.get(city).temperatureF <= maxTemp)
	        	{
	        		datum.add(city);
	        	}
	        }
	        
	        if( datum.size() == 0 ) {
	        	String output = "There are no cities within the temperature range : " + minTemp + "-" + maxTemp;
	            System.out.println(output);
	        	JOptionPane.showMessageDialog(null, output);
	        } else if (datum.size() == 1) {
	        	String output = datum.get(0) + " is the only city within the temperature range " + minTemp + "-" + maxTemp;
	            System.out.println(output);
	            JOptionPane.showMessageDialog(null, output);
	        } else {
	        	System.out.print(datum.size());
	        	String output = "";
	        	for (int i = 0; i < datum.size(); i ++)
	        	{
	        		output = output + datum.get(i) + ", ";
	        		if (i >= 10 && i % 10 == 0)
	        		{
	        			output = output + "\n";
	        		}
        		}
        		output = output + "are all within the temperature range " + minTemp + "-" + maxTemp;
	            System.out.println(output);
	            JOptionPane.showMessageDialog(null, output);
	        }
		}
	}
}
