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

import java.awt.Color;

import sensor.TemperatureSensor;




/*
 * This class is an adapter for the Temperature Sensor class to allow communication between the Sensor Application, to adapt
 * the methods from the Temperature Sensor, so that it fits the needs of the Sensor Application.
 */
public class TemperatureSensorAdapter implements SensorApplicationInterface {
	TemperatureSensor adaptee; // creates an adaptee object to allow communication to the Temperature Sensor class
	private double value; // value of the Temperature Sensor reading
	
	/*
	 * Constructor that takes in a TemperatureSensor object
	 */
	
	public TemperatureSensorAdapter(TemperatureSensor ts) {
		this.adaptee = ts; // sets the adaptee to the ts object
		this.value = ts.senseTemperature(); // set's the value of the ts reading to the TemperatureSensorAdapter reading
	}

	/*
	 * This method returns the adaptee's sensor name
	 */
	@Override
	public String getSensorName() {
		return adaptee.getSensorType();
	}
	
	/*
	 * This method generates and returns the Color object for the gauge based on the
	 * adaptee's getReport result
	 */
	@Override
	public Color getColorCode() {
		if (adaptee.getTempReport() == "OK")
			return Color.green;
		if (adaptee.getTempReport() == "CRITICAL")
			return Color.yellow;
		return Color.red;
	}

	/*
	 * This method generates and returns the length needed for the gauge based on
	 * the adaptee's getReport result
	 */
	@Override
	public int getLength() {
		//returns size in pixels of the gauge
		if (adaptee.getTempReport() == "OK")
			return 20;
		if (adaptee.getTempReport() == "CRITICAL")
			return 75;
		return 200;

	}

	/*
	 * This method returns the getReport based on the adaptee's value and it's
	 * reading value;
	 */
	@Override
	public String getMessage() {
		return adaptee.getTempReport() + " --> " + value; //message returned
	}
}
