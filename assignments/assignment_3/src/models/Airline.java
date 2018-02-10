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

import collections.FlightDirectory;
import utils.Entity;

/**
 * The Airline class represents all the features of an airline.
 * 
 * @author  Raghavan Renganathan <renganathan.raghavan@gmail.com>
 * @version 1.0
 * @since   Feb 7, 2018
 */
public class Airline extends Entity {

    /**
     * Members declaration
     */
    private String name;
    private FlightDirectory flights;

    /**
     * Creates an instance for Airline class
     */
    public Airline() {
        name = "";
        flights = new FlightDirectory();
    }

    /**
     * Create an instance with the passed parameters
     * @param name    Name of the Airline
     * @param flights Directory of flights  
     */
    public Airline(String name, FlightDirectory flights) {
        this.name = name;
        this.flights = flights;
    }
    
    @Override
    public boolean identifies(String key, String value) {
        switch(key) {
            case "name":
                return name.equals(value);
            default:
                return false;
        }
    }

    /**
     * Getter method for {@code this.name}
     * @return The name of the flight
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for {@code this.name}
     * @param name The name of the flight
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for {@code this.flights}
     * @return The directory of all flights under this current Airline
     */
    public FlightDirectory getFlights() {
        return flights;
    }

    /**
     * Setter method for {@code this.flights}
     * @param flights The directory of flights
     */
    public void setFlights(FlightDirectory flights) {
        this.flights = flights;
    }
    
    /**
     * Adds the passed <code>flight</code> to the flights directory
     * @param flight An instance of Flight object
     */
    public void addFlight(Flight flight) {
        flights.add(flight);
    }
    
    /**
     * Removes the passed <code>flight</code> to the flights directory
     * @param flight An instance of Flight object
     */
    public void removeFlight(Flight flight) {
        flights.remove(flight);
    }
}
