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
import models.Flight;
import utils.Directory;

/**
 * The FlightDirectory class holds the collection of all the flights and
 extends the Directory class.
 * This allows it to perform various operations over the collection
 * 
 * @author  Raghavan Renganathan <renganathan.raghavan@gmail.com>
 * @version 1.0
 * @since   Feb 7, 2018
 */
public class FlightDirectory extends Directory<Flight, String> {

    public FlightDirectory() {
        initialize();
    }
    
    @Override
    public Flight create() {
        return new Flight();
    }

    @Override
    public Flight search(String key, String value) {
        for(Flight item : getList())
            if(item.identifies(key, value))
                return item;
        return null;
    }
    
    @Override
    public ArrayList<Flight> filter(String key, String value) {
        ArrayList<Flight> results = new ArrayList<>();
        getList().stream().filter((item) -> (item.identifies(key, value)))
                .forEachOrdered((item) -> {
                    results.add(item);
                });
        return results;
    }

    @Override
    public Flight searchIfNotCreate(String key, String value) {
        for(Flight item : getList())
            if(item.identifies(key, value))
                return item;
        Flight newInstance = create();
        add(newInstance);
        return newInstance;
    }

    /**
     * Returns the list of all connecting flights from point A to B
     * @param from Source
     * @param to   Destination
     * @return     ArrayList of connecting flights
     */
    public ArrayList<Flight> getConnectingFlights(String from, String to) {
        ArrayList<Flight> results = new ArrayList<>();
        getList().stream()
                .filter((f) -> 
                        (f.getOrigin().equals(from) && 
                                f.getDestination().equals(to)))
                .forEachOrdered((f) -> {
                    results.add(f);
                });
        return results;
    }
}
