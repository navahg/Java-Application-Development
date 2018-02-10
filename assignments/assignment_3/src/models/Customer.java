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
    private String name;
    private String email;
    private Flight flight;
    private Seat seat;
    
    @Override
    public boolean identifies(String key, String value) {
        switch(key) {
            case "name":
                return name.equalsIgnoreCase(value);
            case "email":
                return email.equalsIgnoreCase(value);
            default:
                return false;
        }
    }

}
