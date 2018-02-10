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

import utils.Entity;

/**
 * The Customer class represents all the details of a customer.
 * 
 * @author  Raghavan Renganathan <renganathan.raghavan@gmail.com>
 * @version 1.0
 * @since   Feb 8, 2018
 */
public class Customer extends Entity {

    /**
     * Members declaration
     */
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Flight flight;
    private Seat seat;

    /**
     * Creates an instance for a customer
     */
    public Customer() {
        username = "n/a";
        email = "n/a";
        flight = null;
        seat = null;
    }
    
    @Override
    public boolean identifies(String key, String value) {
        switch(key) {
            case "username":
                return username.equalsIgnoreCase(value);
            case "email":
                return email.equalsIgnoreCase(value);
            default:
                return false;
        }
    }

    /**
     * A getter method for getting the username of the customer
     * @return The username of the customer
     */
    public String getUserName() {
        return username;
    }

    /**
     * Sets the username of the customer
     * @param username Username of the customer
     */
    public void setUserName(String username) {
        this.username = username;
    }

    /**
     * Gets the email of the customer
     * @return E-mail of the customer
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the customer
     * @param email E-Mail of the customer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the first name of the customer
     * @return The first name of the customer
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the customer
     * @param firstName The first name of the customer
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the customer
     * @return The last name of the customer
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the of customer
     * @param lastName The last name of the customer
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the flight instance of the customer if he has booked a flight
     * @return The instance of the booked flight or null
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * Sets the booked flight for the customer
     * @param flight Instance of the flight booked
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    /**
     * Gets the instance of the booked seat of the customer
     * @return Instance of the booked seat or null
     */
    public Seat getSeat() {
        return seat;
    }

    /**
     * Sets the booked seat for a customer
     * @param seat The instance of the booked seat
     */
    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    
    /**
     * Method to cancel the booking of the customer
     */
    public void cancelBooking() {
        flight = null;
        seat = null;
    }
}
