/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import business.Car;
import business.Fleet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author raghavan
 */
public class CreateCarPanel extends javax.swing.JPanel {

    private Fleet fleet;
    /**
     * Creates new form CreateCarPanel
     */
    public CreateCarPanel() {
        this.fleet = new Fleet();
        initComponents();
    }
    
    public CreateCarPanel(Fleet fleet) {
        this.fleet = fleet;
        initComponents();
        hideErrorLabels();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        serialNumberTextField = new javax.swing.JTextField();
        manufacturerTextField = new javax.swing.JTextField();
        modelNumberTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        manufacturedYearElement = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        totalSeatsSpinner = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        availableSeatsSpinner = new javax.swing.JSpinner();
        availabilityCheckbox = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        certificateExpiryTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cityTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        serialNumberErrorLabel = new javax.swing.JLabel();
        manufacturerErrorLabel = new javax.swing.JLabel();
        modelNumberErrorLabel = new javax.swing.JLabel();
        certificateExpiryErrorLabel = new javax.swing.JLabel();
        cityErrorLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1000, 768));
        setMinimumSize(new java.awt.Dimension(470, 360));
        setPreferredSize(new java.awt.Dimension(1000, 768));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setText("Create A New Car");

        jLabel2.setText("Serial Number");

        jLabel3.setText("Model Number");

        jLabel4.setText("Manufacturer");

        jLabel5.setText("Manufactured Year");

        manufacturedYearElement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018" }));

        jLabel6.setText("Total Seats");

        totalSeatsSpinner.setModel(new javax.swing.SpinnerNumberModel(2, 2, 10, 1));

        jLabel7.setText("Available Seats");

        availableSeatsSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 1));
        availableSeatsSpinner.setEnabled(false);

        availabilityCheckbox.setText("Available");
        availabilityCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availabilityCheckboxActionPerformed(evt);
            }
        });

        jLabel8.setText("Maintenance Certificate Expiry");

        jLabel9.setText("(mm/dd/yyyy)");

        jLabel10.setText("Available in city");

        saveButton.setText("Save Details");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset Form");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        serialNumberErrorLabel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        serialNumberErrorLabel.setForeground(new java.awt.Color(251, 8, 8));
        serialNumberErrorLabel.setText("Invalid entry");

        manufacturerErrorLabel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        manufacturerErrorLabel.setForeground(new java.awt.Color(251, 8, 8));
        manufacturerErrorLabel.setText("Invalid entry");

        modelNumberErrorLabel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        modelNumberErrorLabel.setForeground(new java.awt.Color(251, 8, 8));
        modelNumberErrorLabel.setText("Invalid entry");

        certificateExpiryErrorLabel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        certificateExpiryErrorLabel.setForeground(new java.awt.Color(251, 8, 8));
        certificateExpiryErrorLabel.setText("Invalid entry");

        cityErrorLabel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        cityErrorLabel.setForeground(new java.awt.Color(251, 8, 8));
        cityErrorLabel.setText("Invalid entry");

        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");

        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");

        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*");

        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("*");

        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(419, 419, 419)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(526, 526, 526))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel9))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel15)))))
                                .addGap(1, 1, 1)
                                .addComponent(jLabel14))
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(manufacturedYearElement, 0, 155, Short.MAX_VALUE)
                            .addComponent(certificateExpiryTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cityTextField, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(certificateExpiryErrorLabel)
                            .addComponent(cityErrorLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(serialNumberTextField)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(totalSeatsSpinner)
                                    .addComponent(availableSeatsSpinner)))
                            .addComponent(serialNumberErrorLabel))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(availabilityCheckbox)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(manufacturerErrorLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(manufacturerTextField))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modelNumberErrorLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(modelNumberTextField))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manufacturerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialNumberErrorLabel)
                    .addComponent(manufacturerErrorLabel)
                    .addComponent(modelNumberErrorLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(totalSeatsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(availabilityCheckbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(availableSeatsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(manufacturedYearElement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(certificateExpiryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(certificateExpiryErrorLabel)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityErrorLabel)
                    .addComponent(jLabel15))
                .addGap(252, 252, 252)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(resetButton))
                .addGap(84, 84, 84))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void availabilityCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availabilityCheckboxActionPerformed
        availableSeatsSpinner.setEnabled(availabilityCheckbox.isSelected());
    }//GEN-LAST:event_availabilityCheckboxActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        hideErrorLabels();
        clearFields();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if(validateForm()) {
            Car newCar = new Car();
            
            newCar.setSerialNumber(serialNumberTextField.getText());
            newCar.setManufacturer(manufacturerTextField.getText());
            newCar.setModelNumber(modelNumberTextField.getText());

            newCar.setTotalSeats((Integer) totalSeatsSpinner.getValue());

            newCar.setAvailable(availabilityCheckbox.isSelected());
            newCar.setAvailableSeats(
                    availabilityCheckbox.isSelected() ? 
                            (Integer) availableSeatsSpinner.getValue() : 0);

            newCar.setManufacturedYear(
                    Integer.parseInt(
                            (String) manufacturedYearElement.getSelectedItem()));
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            try {
                newCar.setMaintenanceCertificateExpiry(
                        df.parse(certificateExpiryTextField.getText()));
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, ex);
                return;
            }
            newCar.setCity(cityTextField.getText());
            fleet.addNewCar(newCar);
            JOptionPane.showMessageDialog(null, "Car added successfully to the list!");
            hideErrorLabels();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid values in the form!");
        }
    }//GEN-LAST:event_saveButtonActionPerformed
    
    private void hideErrorLabels() {
        serialNumberErrorLabel.setVisible(false);
        manufacturerErrorLabel.setVisible(false);
        modelNumberErrorLabel.setVisible(false);
        certificateExpiryErrorLabel.setVisible(false);
        cityErrorLabel.setVisible(false);
    }
    
    private void clearFields() {
        serialNumberTextField.setText("");
        manufacturerTextField.setText("");
        modelNumberTextField.setText("");
        
        totalSeatsSpinner.setValue(0);
        availabilityCheckbox.setSelected(false);
        availableSeatsSpinner.setValue(0);
        availableSeatsSpinner.setEnabled(false);
        
        manufacturedYearElement.setSelectedIndex(0);
        certificateExpiryTextField.setText("");
        cityTextField.setText("");
    }
    
    private boolean validateForm() {
        hideErrorLabels();
        boolean isValid = true;
        if("".equals(serialNumberTextField.getText())) {
            isValid = false;
            serialNumberErrorLabel.setVisible(!isValid);
        }
        if("".equals(manufacturerTextField.getText())) {
            isValid = false;
            manufacturerErrorLabel.setVisible(!isValid);
        }
        if("".equals(modelNumberTextField.getText())) {
            isValid = false;
            modelNumberErrorLabel.setVisible(!isValid);
        }
        if("".equals(certificateExpiryErrorLabel.getText())) {
            isValid = false;
            certificateExpiryErrorLabel.setVisible(!isValid);
        } else {
            String[] date = certificateExpiryTextField.getText().split("/");
            if(date.length != 3) {
                isValid = false;
                certificateExpiryErrorLabel.setVisible(!isValid);
            } else {
                try {
                    int month = Integer.parseInt(date[0]);
                    int day = Integer.parseInt(date[1]);
                    int year = Integer.parseInt(date[2]);
                    
                    ArrayList<Integer> longMonths = new ArrayList<>(
                            Arrays.asList(1, 3, 5, 7, 8, 10, 12));
                    if((month > 0 && month < 13) && 
                            (year >= 1900 && year <= 2100) &&
                            (day >= 1 && day <= 31)) {
                        if(!longMonths.contains(month) && day > 30) {
                            isValid = false;
                            certificateExpiryErrorLabel.setVisible(!isValid);
                        } else if(month == 2) {
                            if((isLeapYear(year) && day > 29) || 
                                    (!isLeapYear(year) && day >28)) {
                                isValid = false;
                                certificateExpiryErrorLabel.setVisible(!isValid);
                            }
                        }
                    } else {
                        isValid = false;
                        certificateExpiryErrorLabel.setVisible(!isValid);
                    }
                } catch(NumberFormatException ex) {
                    isValid = false;
                    certificateExpiryErrorLabel.setVisible(!isValid);
                }
            }
        }
        if("".equals(cityTextField.getText())) {
            isValid = false;
            cityErrorLabel.setVisible(!isValid);
        }
        
        return isValid;
    }
    
    private boolean isLeapYear(int year) {
        return (((year % 4 == 0) && 
                (year % 100 != 0)) ||
                (year % 400 == 0));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox availabilityCheckbox;
    private javax.swing.JSpinner availableSeatsSpinner;
    private javax.swing.JLabel certificateExpiryErrorLabel;
    private javax.swing.JTextField certificateExpiryTextField;
    private javax.swing.JLabel cityErrorLabel;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> manufacturedYearElement;
    private javax.swing.JLabel manufacturerErrorLabel;
    private javax.swing.JTextField manufacturerTextField;
    private javax.swing.JLabel modelNumberErrorLabel;
    private javax.swing.JTextField modelNumberTextField;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel serialNumberErrorLabel;
    private javax.swing.JTextField serialNumberTextField;
    private javax.swing.JSpinner totalSeatsSpinner;
    // End of variables declaration//GEN-END:variables
}