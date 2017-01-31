/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.Customer.Residential;

import business.Utils.Utils;
import business.consumer.WaterOutlet;
import business.enterprise.Enterprise;
import business.userAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.Date;
import java.util.Map.Entry;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author ayush
 */
public class ResidentialCustomerSummaryJPanel extends javax.swing.JPanel {

    
    
    /**
     * Creates new form ResidentialCustomerSummaryJPanel
     */
    
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount account;
     private String[][] waterOutletDetails;
    private String[][] totalWaterUsage;
    
    private int size;
    
    ResidentialCustomerSummaryJPanel(JPanel userProcessContainer, Enterprise enterprise, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account = account;
        int mapSize=account.getCustomer().getConsumer().getTrackWaterUsageMap().size();
        size=account.getCustomer().getConsumer().getWaterOutlets().getWaterOutlets().size();
        
        waterOutletDetails = new String[mapSize][3];
        int number=0;
        for(Entry<Date, String> entry : account.getCustomer().getConsumer().getTrackWaterUsageMap().entrySet())  
        {
          Date key = entry.getKey();
          String value = entry.getValue();
          String[] waterOulet =value.split(",");
          String waterOutletName = waterOulet[0];
          String waterOutletUsage = waterOulet[1];
        System.out.println("inside "); 
          waterOutletDetails[number][0]=key.toString();
          waterOutletDetails[number][1]=waterOutletName;
          waterOutletDetails[number][2]=waterOutletUsage;
          number++;
          //System.out.println(key + " " + value);
        }
        calculateOverallUsage();
        
        
    }
    
    public void calculateOverallUsage(){
        totalWaterUsage= new String[size][2];
        for(int i=0;i<size;i++){
            totalWaterUsage[i][0]=account.getCustomer().getConsumer().getWaterOutlets().getWaterOutlets().get(i).toString();
            totalWaterUsage[i][1]=Double.toString(0);
        }
        
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<waterOutletDetails.length;j++)
            {
                if(totalWaterUsage[i][0].equals(waterOutletDetails[j][1]))
                {
//                    if(totalWaterUsage[i][1]==null)
//                    totalWaterUsage[i][1]=Double.toString(0+Double.parseDouble(waterOutletDetails[j][2]));
//                    else
                    totalWaterUsage[i][1]=Double.toString(Double.parseDouble(totalWaterUsage[i][1])+Double.parseDouble(waterOutletDetails[j][2]));    
                }
            }
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

        jLabel1 = new javax.swing.JLabel();
        waterOutletGraphBtn = new javax.swing.JButton();
        pieChartBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        billingDetailsBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        jLabel1.setText("Customer Usage Summary");

        waterOutletGraphBtn.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        waterOutletGraphBtn.setText("Water Outlet Usage Graph");
        waterOutletGraphBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waterOutletGraphBtnActionPerformed(evt);
            }
        });

        pieChartBtn.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        pieChartBtn.setText("Pie Chart for Storage Tank Vs RainWater Tank Usage");
        pieChartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pieChartBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 16)); // NOI18N
        backBtn.setText("<< BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        billingDetailsBtn.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        billingDetailsBtn.setText("Billing Details");
        billingDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billingDetailsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pieChartBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(billingDetailsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(waterOutletGraphBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(waterOutletGraphBtn)
                .addGap(18, 18, 18)
                .addComponent(pieChartBtn)
                .addGap(18, 18, 18)
                .addComponent(billingDetailsBtn)
                .addGap(18, 18, 18)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void waterOutletGraphBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waterOutletGraphBtnActionPerformed
        // TODO add your handling code here:
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
             
        for(int i=0;i<totalWaterUsage.length;i++){
            dataset.addValue(Double.parseDouble(totalWaterUsage[i][1]), "Water Outlet Usage", totalWaterUsage[i][0]);
        }

        
        JFreeChart chart = ChartFactory.createBarChart("Water Outlet Usage Details", "Water Outlet Name", "Water Utilization", dataset, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot p =chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
        ChartFrame frame = new ChartFrame("Bar Chart for Water Outlet Usage", chart);
        frame.setVisible(true);
        frame.setSize(500, 400);
        
    }//GEN-LAST:event_waterOutletGraphBtnActionPerformed

    private void pieChartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pieChartBtnActionPerformed
        // TODO add your handling code here:
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Storage Tank Utilization "+Utils.roundDouble(account.getCustomer().getStorageTankUtilization()), Utils.roundDouble(account.getCustomer().getStorageTankUtilization()));
        dataset.setValue("Rain Water Tank Utilization "+Utils.roundDouble(account.getCustomer().getRainWaterTankUtilization()), Utils.roundDouble(account.getCustomer().getRainWaterTankUtilization()));
        JFreeChart chart = ChartFactory.createPieChart("Pie Chart", dataset);
       // CategoryPlot p = chart.getCategoryPlot();
        
        ChartFrame frame = new ChartFrame("Utilization Pie Chart", chart);
        frame.setVisible(true);
        frame.setSize(500, 400);
        
    }//GEN-LAST:event_pieChartBtnActionPerformed

    private void billingDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billingDetailsBtnActionPerformed
        // TODO add your handling code here:
        ResidentialCustomerBillingDetailsJPanel customerBillingDetailsJPanel = new ResidentialCustomerBillingDetailsJPanel(userProcessContainer,enterprise,account);
        userProcessContainer.add("customerBillingDetailsJPanel", customerBillingDetailsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_billingDetailsBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
       
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton billingDetailsBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton pieChartBtn;
    private javax.swing.JButton waterOutletGraphBtn;
    // End of variables declaration//GEN-END:variables
}