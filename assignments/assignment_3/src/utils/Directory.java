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

package utils;

import java.util.ArrayList;

/**
 * The Directory abstract class groups the methods that are necessary for any
 manageable entity that can be extended.
 *
 * @author  Raghavan Renganathan <renganathan.raghavan@gmail.com>
 * @version 1.0
 * @param   <E> A generic type based on the class which will extend this class
 * @param   <K> A generic type that will be used as a key variable  
 * @since   Feb 7, 2018
 */
public abstract class Directory<E, K> {
    
    /**
     * An ArrayList of given type that is used to store all the entities
     */
    private ArrayList<E> entityList;
        
    /**
     * The create method is used to create an entity, add it to the list and
     * then return the newly created instance
     * @return The newly created instance
     */
    public abstract E create();
    
    /**
     * The add method can be used to add new items to the manageable entities
     * @param   item Represents the entity that has to be added 
     */
    public void add(E item) {
        entityList.add(item);
    }
    
    /**
     * The search method takes in a key and then returns the first found result
     * @param   key   Represents the primary key value of item using which the 
     *                search has to be done
     * @param   value Represents the value that has to be matched
     * @return        The found instance from the list of all entities,
     *                if not null
     */
    public abstract E search(K key, K value);
    
    /**
     * The filter method takes in a key and then returns the first found result
     * @param   key   Represents the primary key value of item using which the 
     *                search has to be done
     * @param   value Represents the value that has to be matched
     * @return        The found instances from the list of all entities,
     *                if not empty ArrayList
     */
    public abstract ArrayList<E> filter(K key, K value);
    
    /**
     * The remove method deletes the object passed as a parameter from the list
     * of all entities
     * @param item The instance of the entity that has to be deleted
     */
    public void remove(E item) {
        entityList.remove(item);
    }
    
    /**
     * A getter method for getting reference of the entityList member
     * @return The list of all the entities
     */
    public ArrayList<E> getList() {
        return entityList;
    }
    
    /**
     * Returns the number of entities present
     * @return Size of the ArrayList
     */
    public int size() {
        return entityList.size();
    }
}
