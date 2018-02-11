/*
 * Copyright (C) 2018 Raghavan Renganathan <renganathan.raghavan@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package models;

import collections.SeatsDirectory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import utils.Entity;

/**
 * The Flight class represents all the features of a flight.
 *
 * @author  Raghavan Renganathan <renganathan.raghavan@gmail.com>
 * @version 1.0
 * @since   Feb 7, 2018
 */
public class Flight extends Entity {

    /**
     * Members declaration
     */
    private String name;
    private String model;
    private SeatsDirectory seats;
    private String origin;
    private String destination;
    private Date departure;
    private Date arrival;
    
    /**
     * Seats configuration
     */
    private final String[] SEAT_ROWS;
    private final String[] SEAT_COLUMNS;
    
    /**
     * DateFormat
     */
    private final DateFormat DATE_FORMAT = new SimpleDateFormat("hh:mm a");

    /**
     * Create an instance of Fight
     */
    public Flight() {
        name = "n/a";
        model = "n/a";
        seats = new SeatsDirectory();
        origin = "n/a";
        destination = "n/a";
        departure = new Date(0);
        arrival = new Date(0);
        SEAT_ROWS = new String[]{"1", "2", "3", "4", "5"};
        SEAT_COLUMNS = new String[]{"A", "B", "C", "D"};
        initializeSeats();
    }
    
    @Override
    public boolean identifies(String key, String value) {
        switch(key) {
            case "name":
                return name.equals(value);
            case "model":
                return model.equals(value);
            case "origin":
                return origin.equals(value);
            case "destination":
                return destination.equals(value);
            default:
                return false;
        }
    }
    
    @Override
    public String toString() {
        return name;
    }

    /**
     * Gets the name of the flight
     * @return Name of the flight
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the flight
     * @param name Name of the flight
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the model of the flight
     * @return Model of the flight
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the flight
     * @param model Model of the flight
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the seats directory of the flight
     * @return Seats directory of the flight
     */
    public SeatsDirectory getSeats() {
        return seats;
    }

    /**
     * Gets the origination of the flight
     * @return Boarding point of the
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the origination of the flight
     * @param origin 
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Gets the destination of the flight
     * @return Destination point of the flight
     */
    public String getDestination() {
        return destination;
    }

    /**
     * sets the destination of the flight
     * @param destination Destination point of the flight
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Gets the departure time of the flight
     * @return Departure time of the flight
     */
    public String getDeparture() {
        return DATE_FORMAT.format(departure);
    }

    /**
     * Sets the departure time of the flight
     * @param departure Departure time of the flight
     * @throws java.text.ParseException
     */
    public void setDeparture(String departure) throws ParseException {
        this.departure = DATE_FORMAT.parse(departure);
    }

    /**
     * Gets the arrival time of the flight
     * @return Arrival time of the flight
     */
    public String getArrival() {
        return DATE_FORMAT.format(arrival);
    }

    /**
     * Sets the arrival time of the flight
     * @param arrival Arrival time of the flight
     * @throws java.text.ParseException
     */
    public void setArrival(String arrival) throws ParseException {
        this.arrival = DATE_FORMAT.parse(arrival);
    }
    
    /**
     * Returns the total number of seats
     * @return size of the seats ArrayList
     */
    public int getTotalSeats() {
        return seats.size();
    }
    
    /**
     * A method to initialize seats for the flight
     */
    private void initializeSeats() {
        for(String col : SEAT_COLUMNS) {
            for(String row : SEAT_ROWS) {
                seats.add(seats.create(row, col));
            }
        }
    }
    
    /**
     * Returns the available instance of seats
     * @param date Day for which the checking has be done
     * @return Available seats
     */
    public ArrayList<Seat> getAvailableSeats(Date date) {
        return seats.getAvailableSeats(date);
    }
}