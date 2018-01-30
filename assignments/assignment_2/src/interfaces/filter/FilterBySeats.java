/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.filter;

import business.Car;
import business.Fleet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raghavan
 */
public class FilterBySeats extends javax.swing.JPanel {

    private Fleet fleet;
    private JTable resultsTable;
    /**
     * Creates new form FilterBySeats
     */
    public FilterBySeats() {
        initComponents();
    }

    public FilterBySeats(Fleet fleet, JTable resultsTable) {
        this.fleet = fleet;
        this.resultsTable = resultsTable;
        
        initComponents();
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
        minSpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        maxSpinner = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMaximumSize(new java.awt.Dimension(850, 130));
        setPreferredSize(new java.awt.Dimension(850, 130));

        jLabel1.setText("Seats");

        jLabel2.setText("Min");

        minSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        jLabel3.setText("Max");

        maxSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        jButton1.setText("Show Results");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(minSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(maxSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(597, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(minSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(maxSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Integer minSeats = (Integer) minSpinner.getValue();
        Integer maxSeats = (Integer) maxSpinner.getValue();
        
        if(minSeats > maxSeats) {
            JOptionPane.showMessageDialog(null, "Minimum seats should be smaller than Maximum seats!");
            return;
        }
        
        DefaultTableModel tableModel = (DefaultTableModel) resultsTable.getModel();
        Object row[] = new Object[tableModel.getColumnCount()];

        tableModel.setRowCount(0);
        for(Car c : fleet.filterBySeats(minSeats, maxSeats)) {
            row[0] = c;
            row[1] = c.getTotalSeats();
            row[2] = c.getAvailableSeats();
            row[3] = c.getCity();
            tableModel.addRow(row);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner maxSpinner;
    private javax.swing.JSpinner minSpinner;
    // End of variables declaration//GEN-END:variables
}
