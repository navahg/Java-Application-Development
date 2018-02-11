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

package collections;

import java.util.ArrayList;
import java.util.Date;
import models.Seat;
import utils.Directory;

/**
 * The SeatsDirectory class holds the collection of all the seats and
 * extends the Directory class.
 * This allows it to perform various operations over the collection
 * 
 * @author  Raghavan Renganathan <renganathan.raghavan@gmail.com>
 * @version 1.0
 * @since   Feb 9, 2018
 */
public class SeatsDirectory extends Directory<Seat, String> {

    public SeatsDirectory() {
        initialize();
    }
    
    @Override
    public Seat create() {
        return new Seat(null, null);
    }
    
    /**
     * Creates a seat instance with specified row and col
     * @param row Seat Row identifier
     * @param col Seat Column identifier
     * @return A new Seat Instance
     */
    public Seat create(String row, String col) {
        return new Seat(row, col);
    }

    @Override
    public Seat search(String key, String value) {
        for(Seat item : getList())
            if(item.identifies(key, value))
                return item;
        return null;
    }
    
    @Override
    public ArrayList<Seat> filter(String key, String value) {
        ArrayList<Seat> results = new ArrayList<>();
        getList().stream().filter((item) -> (item.identifies(key, value)))
                .forEachOrdered((item) -> {
                    results.add(item);
                });
        return results;
    }

    @Override
    public Seat searchIfNotCreate(String key, String value) {
        for(Seat item : getList())
            if(item.identifies(key, value))
                return item;
        Seat newInstance = create();
        add(newInstance);
        return newInstance;
    }

    /**
     * Returns the available instance of seats
     * @param date Day for which the checking has be done
     * @return Available seats
     */
    public ArrayList<Seat> getAvailableSeats(Date date) {
        ArrayList<Seat> results = new ArrayList<>();
        getList().stream().filter((s) -> (!s.isBooked(date)))
                .forEachOrdered((s) -> {
                    results.add(s);
                });
        return results;
    }
}
