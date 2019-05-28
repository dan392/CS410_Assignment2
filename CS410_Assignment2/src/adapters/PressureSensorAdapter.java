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

import sensor.PressureSensor;




/*
 * This class is an adapter for the Pressure Sensor class to allow communication between the Sensor Application, to adapt
 * the methods from the Pressure Sensor, so that it fits the needs of the Sensor Application.
 */
public class PressureSensorAdapter implements SensorApplicationInterface {
	PressureSensor adaptee; // creates an adaptee object to allow communication to the Pressure Sensor class
	private double value; // value of the Pressure Sensor reading

	/*
	 * Constructor that takes in a PressureSensor object
	 */
	public PressureSensorAdapter(PressureSensor ps) {
		this.adaptee = ps; // sets the adaptee to the ps object
		this.value = ps.readValue(); // set's the value of the ps reading to the PressureSensorAdapter reading

	}

	/*
	 * This method returns the adaptee's sensor name
	 */
	@Override
	public String getSensorName() {
		return adaptee.getSensorName();
	}

	/*
	 * This method generates and returns the Color object for the gauge based on the
	 * adaptee's getReport result
	 */
	@Override
	public Color getColorCode() {
		if (adaptee.getReport() == "OK")
			return Color.green;
		if (adaptee.getReport() == "CRITICAL")
			return Color.yellow;
		else {
			return Color.red;
		}
	}

	/*
	 * This method generates and returns the length needed for the gauge based on
	 * the adaptee's getReport result
	 */
	@Override
	public int getLength() {
		//returns size in pixels of the length of the gauge
		if (adaptee.getReport() == "OK")
			return 20;
		if (adaptee.getReport() == "CRITICAL")
			return 75;
		return 200;

	}

	/*
	 * This method returns the getReport based on the adaptee's value and it's
	 * reading value;
	 */
	@Override
	public String getMessage() {
		return adaptee.getReport() + " --> " + value; // message returned
	}
}