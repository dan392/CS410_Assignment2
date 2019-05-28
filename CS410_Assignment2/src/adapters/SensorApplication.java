/**
 * CS 410 - Assignment 2 
 * @author Daniyal Adzhiyev
 * @version 1.0 05/28/2019
 * 
 * This Application uses the Adapter Software Pattern to create adapter's for multiple predefined sensor classes.
 * Where the adapter classes implement the Sensor Application Interface, to 'adapt' the original sensor classes
 * so that all of the adapter classes have the same methods needed to display the information in the Sensor 
 * Application.
 *  
 */

package adapters;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import sensor.PressureSensor;
import sensor.RadiationSensor;
import sensor.TemperatureSensor;




/*
 * This Class creates the GUI for the Sensor Application
 */
public class SensorApplication extends JFrame {
	public SensorApplication(SensorApplicationInterface[] sensor) {
		setTitle("Sensor Tracker"); // set's the title of the application
		setLayout(new GridLayout(3, 1)); // uses a gridlayout

		// Uses grid bag constraints to seperate the Gauge Panels and the Message
		// Textfields
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
		c.gridx = 0;
		c.gridy = 1;

		// Creates the first Sensor Panel
		JPanel firstSensorPnl = new JPanel();
		firstSensorPnl.setLayout(new GridBagLayout());
		// sets the panel title to the first sensor name
		firstSensorPnl.setBorder(new TitledBorder(sensor[0].getSensorName()));
		add(firstSensorPnl); // adds panel to the JFrame
		JPanel firstSensorGaugePnl = new JPanel(); // JPanel to represent the Sensor Gauge
		// sets the size of the JPanel Gauge based on length returned form the sensor
		firstSensorGaugePnl.setPreferredSize(new Dimension(sensor[0].getLength(), 100));
		// sets the background color of the JPanel Gauge based on the sensor color code
		firstSensorGaugePnl.setBackground(sensor[0].getColorCode());
		// creates JLabel and sets the text to the sensor's getMessage() method
		JLabel firstSensorMessageLbl = new JLabel(sensor[0].getMessage());

		firstSensorPnl.add(firstSensorGaugePnl); // adds gauge to panel
		firstSensorPnl.add(firstSensorMessageLbl, c); // adds message label to panel, with constraints

		// Creates the second Sensor Panel
		JPanel secondSensorPnl = new JPanel();
		secondSensorPnl.setLayout(new GridBagLayout());
		// sets the panel title to the second sensor name
		secondSensorPnl.setBorder(new TitledBorder(sensor[1].getSensorName()));
		add(secondSensorPnl); // adds panel to the JFrame
		JPanel secondSensorGaugePnl = new JPanel(); // JPanel to represent the Sensor Gauge
		secondSensorGaugePnl.setPreferredSize(new Dimension(sensor[1].getLength(), 100));
		// sets the size of the JPanel Gauge based on length returned form the sensor
		secondSensorGaugePnl.setBackground(sensor[1].getColorCode());
		// creates JLabel and sets the text to the sensor's getMessage() method
		JLabel secondSensorMessageLbl = new JLabel(sensor[1].getMessage());

		secondSensorPnl.add(secondSensorGaugePnl);// adds gauge to panel
		secondSensorPnl.add(secondSensorMessageLbl, c);// adds message label to panel, with constraints

		// Creates the third Sensor Panel
		JPanel thirdSensorPnl = new JPanel();
		thirdSensorPnl.setLayout(new GridBagLayout());
		// sets the panel title to the third sensor name
		thirdSensorPnl.setBorder(new TitledBorder(sensor[2].getSensorName()));
		add(thirdSensorPnl); // adds panel to the JFrame
		JPanel thirdSensorGaugePnl = new JPanel(); // JPanel to represent the Sensor Gauge

		thirdSensorGaugePnl.setPreferredSize(new Dimension(sensor[2].getLength(), 100));
		// sets the size of the JPanel Gauge based on length returned form the sensor
		thirdSensorGaugePnl.setBackground(sensor[2].getColorCode());
		//creates JLabel and sets the text to the sensor's getMessage() method
		JLabel thirdSensorMessageLbl = new JLabel(sensor[2].getMessage());

		thirdSensorPnl.add(thirdSensorGaugePnl);// adds gauge to panel
		thirdSensorPnl.add(thirdSensorMessageLbl, c);// adds message label to panel, with constraints

		setPreferredSize(new Dimension(600, 600)); //sets size of JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows to exit application on close
		setVisible(true); //sets JFrame to be visible
		pack();
	}

	/*
	 * This is the main method to launch the application
	 */
	public static void main(String[] args) {
		
		//array to hold the three different type of sensor adapters
		SensorApplicationInterface[] sensors = { new PressureSensorAdapter(new PressureSensor()),
				new RadiationSensorAdapter(new RadiationSensor()),
				new TemperatureSensorAdapter(new TemperatureSensor()) };
		
		//creates a new Sensor Application to launch the GUI
		SensorApplication app = new SensorApplication(sensors);

	}
}