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
import models.Airline;
import utils.Directory;

/**
 * The AirlinesDirectory class holds the collection of all the airlines and
 * extends the Directory class.
 * This allows it to perform various operations over the collection
 * 
 * @author  Raghavan Renganathan <renganathan.raghavan@gmail.com>
 * @version 1.0
 * @since   Feb 7, 2018
 */
public class AirlinesDirectory extends Directory<Airline, String> {
    
    @Override
    public Airline create() {
        return new Airline();
    }
    
    @Override
    public Airline search(String key, String value) {
        for(Airline item : getList())
            if(item.identifies(key, value))
                return item;
        return null;
    }

    @Override
    public ArrayList<Airline> filter(String key, String value) {
        ArrayList<Airline> results = new ArrayList<>();
        getList().stream().filter((item) -> (item.identifies(key, value)))
                .forEachOrdered((item) -> {
                    results.add(item);
                });
        return results;
    }

    @Override
    public Airline searchIfNotCreate(String key, String value) {
        for(Airline item : getList())
            if(item.identifies(key, value))
                return item;
        Airline newInstance = create();
        add(newInstance);
        return newInstance;
    }
        
}
