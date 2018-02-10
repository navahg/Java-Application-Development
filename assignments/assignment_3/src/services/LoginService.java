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

package services;

import collections.CustomerDirectory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Customer;

/**
 * This class will be used to check credentials of the users and agents.
 * This class will not allow any object creation!
 *
 * @author    Raghavan Renganathan <renganathan.raghavan@gmail.com>
 * @version   1.0
 * @since     Feb 10, 2018
 */
public class LoginService {
    /**
     * A private constructor to restrict object creation
     */
    private LoginService(){}
    
    /**
     * String constance representing the location of the credential files of the
     * agent and customer respectively
     */
    private static final String AGENT_DATA = System.getProperty("user.dir") + 
            "/resources/data/agent_credentials.dat";
    private static final String CUST_DATA = System.getProperty("user.dir") + 
            "/resources/data/customer_credentials.dat";
    
    /**
     * Login service for customers
     * @param username Username given
     * @param password Password given
     * @param dir      The customer directory
     * @return         The matched Customer Instance 
     *                 if not a new Instance if the credentials are correct
     *                 else null
     */
    public static Customer doCustLogin(String username, String password, 
            CustomerDirectory dir) {
        Customer cust;
        HashMap<String, String> custDetails;
        try {
            custDetails = authorize("customer", username, password);
        } catch (IOException ex) {
            Logger.getLogger(LoginService.class.getName())
                  .log(Level.SEVERE, null, ex);
            return null;
        }
        if(custDetails == null)
            return null;
        
        cust = dir.search(username, password);
        if(cust != null)
            return cust;
        
        cust = new Customer();
        cust.setFirstName(custDetails.get("firstName"));
        cust.setLastName(custDetails.get("lastName"));
        cust.setUserName(custDetails.get("userName"));
        cust.setEmail(custDetails.get("email"));
        return cust;
    }
    
    /**
     * Login service for agents
     * @param username Username given
     * @param password Password given
     * @return         true if the credentials are correct, else false
     */
    public static boolean doAgentLogin(String username, String password) {
        HashMap<String, String> agentCredentials;
        try {
            agentCredentials = authorize("agent", username, password);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginService.class.getName())
                  .log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(LoginService.class.getName())
                  .log(Level.SEVERE, null, ex);
            return false;
        }
        return agentCredentials != null;
    }
    
    /**
     * A method that authorizes the given credentials
     * @param role     Role of the user
     * @param username Username of the user
     * @param password Password of the user
     * @return         A HashMap of the details of the authorized user, 
     *                 else null 
     */
    private static HashMap<String, String> authorize(String role, 
            String username, String password) 
            throws FileNotFoundException, IOException {
        String filename;
        if(role.equals("customer"))
            filename = CUST_DATA;
        else
            filename = AGENT_DATA;
        
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while((line = reader.readLine()) != null) {
            String[] fields = line.split("~");
            if(!fields[0].equals(username))
                continue;
            if(!fields[1].equals(password))
                return null;
            
            HashMap<String, String> result = new HashMap<>();
            if(role.equals("customer")) {
                result.put("username", username);
                result.put("email", fields[2]);
                result.put("firstName", fields[3].split(",")[1]);
                result.put("lastName", fields[3].split(",")[0]);
            }          
            return result;
        }
        return null;
    }
}
