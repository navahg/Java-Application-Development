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
import models.Customer;
import utils.Directory;

/**
 * The Customer Directory class holds the collection of all the customers and
 * extends the Directory class.
 * This allows it to perform various operations over the collection
 * 
 * @author  Raghavan Renganathan <renganathan.raghavan@gmail.com>
 * @version 1.0
 * @since   Feb 8, 2018
 */
public class CustomerDirectory extends Directory<Customer, String> {

    public CustomerDirectory() {
        initialize();
    }
    
    @Override
    public Customer create() {
        return new Customer();
    }

    @Override
    public Customer search(String key, String value) {
        for(Customer item : getList())
            if(item.identifies(key, value))
                return item;
        return null;
    }
    
    @Override
    public ArrayList<Customer> filter(String key, String value) {
        ArrayList<Customer> results = new ArrayList<>();
        getList().stream().filter((item) -> (item.identifies(key, value)))
                .forEachOrdered((item) -> {
                    results.add(item);
                });
        return results;
    }

    @Override
    public Customer searchIfNotCreate(String key, String value) {
        for(Customer item : getList())
            if(item.identifies(key, value))
                return item;
        Customer newInstance = create();
        add(newInstance);
        return newInstance;
    }
    
}
