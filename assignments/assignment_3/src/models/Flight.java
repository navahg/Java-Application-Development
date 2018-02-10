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
    private String model;
    private SeatsDirectory seats;
    private String origin;
    private String destination;
    private Date departure;
    private Date arrival;

    /**
     * Create an instance of Fight
     */
    public Flight() {
        model = "n/a";
        seats = new SeatsDirectory();
        origin = "n/a";
        destination = "n/a";
        departure = new Date(0);
        arrival = new Date(0);
    }
    
    @Override
    public boolean identifies(String key, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Date getDeparture() {
        return departure;
    }

    /**
     * Sets the departure time of the flight
     * @param departure Departure time of the flight
     */
    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    /**
     * Gets the arrival time of the flight
     * @return Arrival time of the flight
     */
    public Date getArrival() {
        return arrival;
    }

    /**
     * Sets the arrival time of the flight
     * @param arrival Arrival time of the flight
     */
    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }
}