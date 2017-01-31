/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.RainWaterHarvesting;

import business.workqueue.RainWaterHarvesting.RainWaterHarvestingRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ayush
 */
public class RainWaterHarvestingProcessRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RainWaterHarvestingProcessRequestJPanel
     */
    
    private JPanel userProcessContainer;
    private RainWaterHarvestingRequest request;
    public RainWaterHarvestingProcessRequestJPanel(JPanel userProcessContainer, RainWaterHarvestingRequest request) 
    {
         initComponents();
         this.userProcessContainer=userProcessContainer;
         this.request=request;
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
        commentsTxtArea = new javax.swing.JTextArea();
        backBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        commentsTxtArea.setColumns(20);
        commentsTxtArea.setRows(5);
        jScrollPane1.setViewportView(commentsTxtArea);

        backBtn.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        submitBtn.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 20)); // NOI18N
        jLabel1.setText("Rain Water Storage Process Request");

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 20)); // NOI18N
        jLabel2.setText("Comments");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitBtn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addContainerGap(43, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitBtn)
                    .addComponent(backBtn))
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        String comments = commentsTxtArea.getText();
        if(comments.equals("")){
            JOptionPane.showMessageDialog(null,"Please enter the resolution in the comments section","Warning",1);
        }
        else{
           request.setStatus("Completed");
           request.setResult(comments);
           
           request.getCustomer().initializeRainWaterStorage();
           if(request.getCustomer().getCustomerType().contains("Residential"))
           request.getCustomer().getRainWaterTank().setCapacity(request.getCustomer().getConsumer().getStorageTank().getTotalCapacity());
           else if(request.getCustomer().getCustomerType().contains("Commercial"))
           request.getCustomer().getRainWaterTank().setCapacity(request.getCustomer().getConsumer().getStorageTanks().get(0).getTotalCapacity());    
               
           if(request.getCustomer().getCustomerType().contains("Residential"))
           request.getCustomer().getRainWaterTank().setDimensions(request.getCustomer().getConsumer().getStorageTank().getDimensions());
           else if(request.getCustomer().getCustomerType().contains("Commercial"))
               request.getCustomer().getRainWaterTank().setDimensions(request.getCustomer().getConsumer().getStorageTanks().get(0).getDimensions());
   
           
           JOptionPane.showMessageDialog(null,"Request has been completed successfully","Success",1);
           commentsTxtArea.setText("");
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        RainWaterHarvestingRoleWorkAreaJPanel dwjp = (RainWaterHarvestingRoleWorkAreaJPanel) component;
        dwjp.populateTable();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextArea commentsTxtArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}