/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.Customer.Residential;

import business.Role.CustomerRole;
import business.consumer.WaterOutlet;
import business.consumer.WaterOutlets;
import business.enterprise.Enterprise;
import business.organization.CommercialRainWaterHarvestingUnitOrganization;
import business.organization.Customer.Customer;
import business.organization.Organization;
import business.organization.ResidentialMaintainenceUnitOrganization;
import business.organization.ResidentialRainWaterHarvestingUnitOrganization;
import business.userAccount.UserAccount;
import business.workqueue.Maintainence.MaintainenceRequest;
import business.workqueue.RainWaterHarvesting.RainWaterHarvestingRequest;
import java.awt.CardLayout;
import java.awt.Component;
import static java.time.Clock.system;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinay
 */
public class ViewResidentialCustomerProfileJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewResidentialCustomerProfileJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private WaterOutlets tempWaterOutlets;
    private Enterprise enterprise;
    
    public ViewResidentialCustomerProfileJPanel(JPanel userProcessContainer, UserAccount account,Enterprise enterprise) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.account=account;
        this.enterprise=enterprise;
        populateWaterOutletTable();
        customerNameTxtField.setText(account.getCustomer().getCustomerName());
        dimensionsTxtField.setText(account.getCustomer().getConsumer().getStorageTank().getDimensions());
        capacityTxtField.setText(Double.toString(account.getCustomer().getConsumer().getStorageTank().getTotalCapacity()));
        nameJTextField.setText(account.getUserName());
        passwordJTextField.setText(account.getPassword());
        
        tempWaterOutlets = account.getCustomer().getConsumer().getWaterOutlets();
    }
    
    public void populateWaterOutletTable()
    {
        DefaultTableModel model = (DefaultTableModel) waterOutletTable.getModel();
        
        model.setRowCount(0);
        
        for (WaterOutlet waterOutlet: account.getCustomer().getConsumer().getWaterOutlets().getWaterOutlets()){
            Object[] row = new Object[2];
            row[0] = waterOutlet;
            row[1] = waterOutlet.getWaterOutletType();
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        customerNameTxtField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        waterOutletComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        waterOutletNameTxtField = new javax.swing.JTextField();
        addOutletBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        waterOutletTable = new javax.swing.JTable();
        removeOutletBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dimensionsTxtField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        capacityTxtField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        passwordJTextField = new javax.swing.JTextField();
        nameJTextField = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        updateDetailsBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel1.setText("View Residential Customer Details");

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        jLabel2.setText("Name:");

        customerNameTxtField.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        jLabel4.setText("Add Water Outlets");

        waterOutletComboBox.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 16)); // NOI18N
        waterOutletComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Basin Tap", "Shower", "Bath Tap", "Washing Machine", "Flush", "Others" }));

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        jLabel5.setText("Water Outlet Name");

        waterOutletNameTxtField.setEditable(false);

        addOutletBtn.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        addOutletBtn.setText("Add Outlet");
        addOutletBtn.setEnabled(false);
        addOutletBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOutletBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        jLabel3.setText("Water Outlets List:");

        waterOutletTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Water Outlet Name", "Water Outlet Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(waterOutletTable);

        removeOutletBtn.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        removeOutletBtn.setText("Remove Outlet");
        removeOutletBtn.setEnabled(false);
        removeOutletBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeOutletBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        jLabel7.setText("Enter Existing Storage Tank Details");

        jLabel8.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        jLabel8.setText("Dimensions");

        dimensionsTxtField.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        jLabel9.setText("L*B*H");

        jLabel11.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        jLabel11.setText("Capacity");

        capacityTxtField.setEditable(false);

        jLabel10.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        jLabel10.setText("Gallons");

        jLabel13.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        jLabel13.setText("Username and Password Details:");

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        jLabel6.setText("User Name");

        jLabel12.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        jLabel12.setText("Password");

        passwordJTextField.setEditable(false);

        nameJTextField.setEditable(false);

        backBtn.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        saveBtn.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        saveBtn.setText("Request Updation");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        updateDetailsBtn.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        updateDetailsBtn.setText("Modify Details");
        updateDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDetailsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(customerNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(waterOutletComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel3))
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel5)
                                        .addGap(31, 31, 31)
                                        .addComponent(waterOutletNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(addOutletBtn))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(removeOutletBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(capacityTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(dimensionsTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(updateDetailsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(customerNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(waterOutletNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(waterOutletComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addOutletBtn)))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(removeOutletBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(dimensionsTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(capacityTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateDetailsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addOutletBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOutletBtnActionPerformed
        // TODO add your handling code here:
        WaterOutlet tempWaterOutlet = new WaterOutlet();
        if(!waterOutletNameTxtField.getText().equals("")){
            tempWaterOutlet.setWaterOutletName(waterOutletNameTxtField.getText());
            tempWaterOutlet.setWaterOutletType(waterOutletComboBox.getSelectedItem().toString());
            tempWaterOutlets.add(tempWaterOutlet);
            populateWaterOutletTable();
        }
        else
        JOptionPane.showMessageDialog(null,"Name cannot be null","Warning",1);
    }//GEN-LAST:event_addOutletBtnActionPerformed

    private void removeOutletBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeOutletBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) waterOutletTable.getModel();
        int select = waterOutletTable.getSelectedRow();
        if (select < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a row");
            return;
        }
        else{
            WaterOutlet waterOutlet = (WaterOutlet) waterOutletTable.getValueAt(select, 0);
            tempWaterOutlets.remove(waterOutlet);
            populateWaterOutletTable();
        }
    }//GEN-LAST:event_removeOutletBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ResidentialCustomerWorkAreaJPanel dwjp = (ResidentialCustomerWorkAreaJPanel) component;
        dwjp.populateTable();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        
        
        if(capacityTxtField.getText().equals("")||passwordJTextField.getText().equals("")
                ||dimensionsTxtField.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Values cannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
        else{
        try{
            int capacity=Integer.parseInt(capacityTxtField.getText());
        Customer customer = account.getCustomer();
        
        //Rain water tank will be installed once the employee of that organization will approve the request
        MaintainenceRequest requestUpdate = new MaintainenceRequest();
        requestUpdate.setMessage("Update User Account");
        requestUpdate.setSender(account);
        requestUpdate.setStatus("Sent");
        requestUpdate.setPriority(1);
        
        requestUpdate.setAccount(account);
        requestUpdate.setCapacity(capacityTxtField.getText());
        requestUpdate.setCustomer(account.getCustomer());
        requestUpdate.setPassword(passwordJTextField.getText());
        requestUpdate.setTempWaterOutlet(tempWaterOutlets);
        
        Organization org=null;
        
        for (Organization organization : enterprise.getOrganizationsList().getOrganizationList()){
            if (organization instanceof ResidentialMaintainenceUnitOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(requestUpdate);
            account.getWorkQueue().getWorkRequestList().add(requestUpdate);
        }


        String password = passwordJTextField.getText();

        JOptionPane.showMessageDialog(null, "Request for account updation has been sent. Wait for the request to get processed.","Confirmation Message",1);
        waterOutletTable.removeAll();
        customerNameTxtField.setText("");
        waterOutletNameTxtField.setText("");
        waterOutletTable.removeAll();
        dimensionsTxtField.setText("");
        capacityTxtField.setText("");
        nameJTextField.setText("");
        passwordJTextField.setText("");
        waterOutletNameTxtField.setEditable(false);
        addOutletBtn.setEnabled(false);
        removeOutletBtn.setEnabled(false);
        passwordJTextField.setEditable(false);
        capacityTxtField.setEditable(false);
        updateDetailsBtn.setEnabled(true);
        saveBtn.setEnabled(false);
        }
        catch(Exception e){
               JOptionPane.showMessageDialog(null, "Please check your input. Only integers is acceptable for some fields", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        }
        
    }//GEN-LAST:event_saveBtnActionPerformed

    private void updateDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDetailsBtnActionPerformed
        // TODO add your handling code here:
        waterOutletNameTxtField.setEditable(true);
        addOutletBtn.setEnabled(true);
        removeOutletBtn.setEnabled(true);
        passwordJTextField.setEditable(true);
        capacityTxtField.setEditable(true);
        updateDetailsBtn.setEnabled(false);
    }//GEN-LAST:event_updateDetailsBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOutletBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField capacityTxtField;
    private javax.swing.JTextField customerNameTxtField;
    private javax.swing.JTextField dimensionsTxtField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JButton removeOutletBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton updateDetailsBtn;
    private javax.swing.JComboBox<String> waterOutletComboBox;
    private javax.swing.JTextField waterOutletNameTxtField;
    private javax.swing.JTable waterOutletTable;
    // End of variables declaration//GEN-END:variables
}
