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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;
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
    private TreeMap<String, TreeMap<Flight, Seat>> bookings;
    
    /**
     * TreeMap will have the Date as the key.
     * Creating a date format parser.
     */
    private static final DateFormat DATE_FORMAT = 
                                            new SimpleDateFormat("dd-mm-yyyy");

    /**
     * Creates an instance for a customer
     */
    public Customer() {
        username = "n/a";
        email = "n/a";
        flight = null;
        bookings = new TreeMap<>();
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
     * Gets all the instance of the booked seat and flight of the customer
     * @return Instances of all the booked seats and flights
     */
    public TreeMap<String, TreeMap<Flight, Seat>> getAllBookings() {
        return bookings;
    }
    
    /**
     * Gets the instance of the booked seat and flight of the customer
     * @return Instance of the booked flight and seat or null
     */
    public TreeMap<Flight, Seat> getBookings(Date date) {
        String key = DATE_FORMAT.format(date);
        if(bookings.containsKey(key))
            return bookings.get(key);
        return null;
    }

    /**
     * Sets the booked seat for a customer
     * @param date   Date for which the flight is booked
     * @param flight The instance of the booked flight
     * @param seat   The instance of the booked seat
     */
    public void setBooking(Date date, Flight flight, Seat seat) {
        String key = DATE_FORMAT.format(date);
        TreeMap<Flight, Seat> newBooking;
        if(bookings.containsKey(key)) {
            newBooking = bookings.get(key);
            newBooking.put(flight, seat);
        } else {
            newBooking = new TreeMap<>();
            bookings.put(key, newBooking);
            newBooking.put(flight, seat);
        }
    }
    
    /**
     * Method to cancel the booking of the customer
     */
    public void cancelBooking(Date date, Flight flight, Seat seat) {
        String key = DATE_FORMAT.format(date);
        if(bookings.containsKey(key))
            if(bookings.get(key).containsKey(flight))
                bookings.get(key).remove(flight, seat);
        if(bookings.get(key).isEmpty())
            bookings.remove(key);
    }
}
