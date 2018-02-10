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
 * The Flight class represents all the features of a seat.
 *
 * @author  Raghavan Renganathan <renganathan.raghavan@gmail.com>
 * @version 1.0
 * @since   Feb 9, 2018
 */
public class Seat extends Entity {

    /**
     * Declaring members
     */
    private String column;
    private String row;
    private TreeMap<String, Customer> status;
    
    /**
     * TreeMap will have the Date as the key.
     * Creating a date format parser.
     */
    private static final DateFormat DATE_FORMAT = 
                                            new SimpleDateFormat("dd-mm-yyyy");

    /**
     * Creates an instance of a seat
     * @param column Seat column number
     * @param row    Seat row number
     */
    public Seat(String column, String row) {
        this.column = column;
        this.row = row;
        this.status = new TreeMap<>();
    }
    
    @Override
    public boolean identifies(String row, String column) {
        return (this.row.equals(row) && this.column.equals(column));
    }
    
    @Override
    public String toString() {
        return column + row;
    }

    /**
     * Book this seat for the given date and given customer.
     * @param date Date for which it should be booked
     * @param cust Customer to whom the seat should be booked
     */
    public void bookSeat(Date date, Customer cust) {
        status.put(DATE_FORMAT.format(date), cust);
    }
    
    /**
     * Cancel the booking for the given date
     * @param date Date for which the booking has to be canceled
     */
    public void cancelBooking(Date date) {
        status.remove(DATE_FORMAT.format(date));
    }
    
    /**
     * Tells if this seat is booked for the given date
     * @param date The date which the booking status has to be checked
     * @return {@code true} if the seat is booked else {@code false}
     */
    public boolean isBooked(Date date) {
        return status.containsKey(DATE_FORMAT.format(date));
    }
    
    /**
     * Return the customer to whom the seat is booked for the given date
     * @param date
     * @return Customer to which the seat is booked, if not return null
     */
    public Customer bookedFor(Date date) {
        String key = DATE_FORMAT.format(date);
        if(status.containsKey(key))
            return status.get(key);
        return null;
    }
}
