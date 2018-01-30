/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for storing the list of all cars
 * @author raghavan
 */
public class Fleet {
    private ArrayList<Car> fleet;
    private TreeMap<String, Integer> manufacturers;
    private TreeSet<String> city;
    private TreeSet<Integer> year;
    private static final String BACKUP_FILE = System.getProperty("user.dir") +
                                                "/resources/data/fleetData.dat";
    private static final Logger LOG = Logger.getLogger(Fleet.class.getName());
    private Date lastModifiedOn;

    
    public Fleet() {
        fleet = new ArrayList<>();
        manufacturers = new TreeMap<>();
        city = new TreeSet<>();
        year = new TreeSet<>();
        lastModifiedOn = new Date();
        try {
            restoreBackup();
        } catch(IOException ex) {
            LOG.severe(ex.toString());
        }
    }
    
    public ArrayList<Car> getFleet() {
        return fleet;
    }
    
    public void setFleet(ArrayList<Car> fleet) {
        this.fleet = fleet;
        lastModifiedOn = new Date();
    }

    public TreeMap<String, Integer> getManufacturers() {
        return manufacturers;
    }

    public TreeSet<String> getCities() {
        return city;
    }

    public TreeSet<Integer> getYear() {
        return year;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }
    
    public void addNewCar(Car c) {
        fleet.add(c);
        if(manufacturers.containsKey(c.getManufacturer()))
            manufacturers.put(c.getManufacturer(), 
                    manufacturers.get(c.getManufacturer()) + 1);
        else
            manufacturers.put(c.getManufacturer(), 1);
        city.add(c.getCity());
        year.add(c.getManufacturedYear());
        lastModifiedOn = new Date();
    }
    
    public void deleteCar(Car c) {
        fleet.remove(c);
        lastModifiedOn = new Date();
    }
    
    public Car firstAvailableCar() {
        for(Car c : fleet)
            if(c.isAvailable())
                return c;
        return null;
    }
    
    public Integer getAvailibityNumber() {
        return Car.getAvailabilityCount();
    }
    
    public ArrayList<Car> carsWithExpiredMaintenanceCertificates() {
        ArrayList<Car> results = new ArrayList<>();
        for(Car c : fleet) {
            if(c.getMaintenanceCertificateExpiry().before(new Date())) {
                results.add(c);
            }
        }
        return results;
    }
    
    public Car filterBySerialNumber(String s) {
        for(Car c : fleet) {
            if(c.getSerialNumber().equals(s))
                return c;
        }
        return null;
    }
    
    public ArrayList<Car> filterByModelNumber(String s) {
        ArrayList<Car> results = new ArrayList<>();
        for(Car c : fleet) {
            if(c.getModelNumber().equals(s))
                results.add(c);
        }
        return results;
    }
    
    public ArrayList<Car> filterByManufacturedYear(Integer y) {
        ArrayList<Car> results = new ArrayList<>();
        for(Car c : fleet) {
            if(c.getManufacturedYear().equals(y))
                results.add(c);
        }
        return results;
    }
    
    public ArrayList<Car> filterBySeats(Integer min, Integer max) {
        ArrayList<Car> results = new ArrayList<>();
        for(Car c : fleet) {
            Integer seats = c.getTotalSeats();
            if(seats >= min && seats <= max)
                results.add(c);
        }
        return results;
    }
    
    public ArrayList<Car> filterByCityAndAvailibility(String s) {
        ArrayList<Car> results = new ArrayList<>();
        for(Car c : fleet) {
            if(c.getCity().equals(s) && c.isAvailable())
                results.add(c);
        }
        return results;
    }
    
    private void restoreBackup() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(BACKUP_FILE));
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat dfWithTime = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        String line;
        String lastUpdatedOn = dfWithTime.format(new Date());
        boolean firstLine = true;
        while((line = reader.readLine()) != null) {
            if(firstLine) {
                lastUpdatedOn = line;
                firstLine = false;
                continue;
            }
            String[] values = line.split(",");
            Car c = new Car();
            c.setSerialNumber(values[0]);
            c.setModelNumber(values[1]);
            c.setManufacturer(values[2]);
            c.setAvailable("true".equals(values[5]));
            try {
                c.setTotalSeats(Integer.parseInt(values[3]));
                c.setAvailableSeats(Integer.parseInt(values[4]));
                c.setMaintenanceCertificateExpiry(df.parse(values[6]));
                c.setManufacturedYear(Integer.parseInt(values[7]));
            } catch (ParseException | NumberFormatException ex) {
                LOG.log(Level.SEVERE, "{0} - {1}", new Object[]{ex.toString(), c.getSerialNumber()});
                continue;
            }
            c.setCity(values[8]);
            
            addNewCar(c);
        }
        try {
            lastModifiedOn = dfWithTime.parse(lastUpdatedOn);
        } catch (ParseException ex) {
            LOG.log(Level.SEVERE, "{0} - {1}", 
                    new Object[]{ex.toString(), "Invalid Last Updated Date"});

        }
    }
    
    public void backupData() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(BACKUP_FILE));
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat dfWithTime = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        writer.write(dfWithTime.format(lastModifiedOn) + "\n");
        for(Car c : fleet) {
            writer.append(c.getSerialNumber() + "," +
                    c.getModelNumber() + "," +
                    c.getManufacturer() + "," +
                    c.getTotalSeats() + "," +
                    c.getAvailableSeats() + "," +
                    c.isAvailable() + "," +
                    df.format(c.getMaintenanceCertificateExpiry()) + "," +
                    c.getManufacturedYear() + "," +
                    c.getCity() + "\n");
        }
        writer.close();
    }    
}
