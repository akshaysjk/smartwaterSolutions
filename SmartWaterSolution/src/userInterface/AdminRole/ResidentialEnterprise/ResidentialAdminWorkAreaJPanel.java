/*
 * AdminWorkAreaJPanel.java
 *
 * Created on October 10, 2008, 8:50 AM
 */

package userInterface.AdminRole.ResidentialEnterprise;


import business.EcoSystems;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.userAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author  vinay
 */
public class ResidentialAdminWorkAreaJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    Enterprise enterprise;
     Organization organization;
    UserAccount userAccount;
    /** Creates new form AdminWorkAreaJPanel */
   
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */

    public ResidentialAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.organization=organization;
        this.userAccount=account;
        valueLabel.setText(enterprise.getName());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userJButton = new javax.swing.JButton();
        manageEmployeeJButton = new javax.swing.JButton();
        manageOrganizationJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userJButton.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        userJButton.setText("Manage Employee Users");
        userJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButtonActionPerformed(evt);
            }
        });
        add(userJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 350, 70));

        manageEmployeeJButton.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        manageEmployeeJButton.setText("Manage Employee");
        manageEmployeeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeJButtonActionPerformed(evt);
            }
        });
        add(manageEmployeeJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 350, 70));

        manageOrganizationJButton.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        manageOrganizationJButton.setText("Manage Organization");
        manageOrganizationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationJButtonActionPerformed(evt);
            }
        });
        add(manageOrganizationJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 350, 70));

        enterpriseLabel.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        enterpriseLabel.setText("Enterprise Name:");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 190, 30));

        valueLabel.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 91, 140, 30));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        jLabel1.setText("Enterprise Admin Work Area ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void userJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButtonActionPerformed
        // TODO add your handling code here:
        ResidentialManageUserAccountJPanel muajp = new ResidentialManageUserAccountJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("ManageUserAccountJPanel", muajp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_userJButtonActionPerformed

    private void manageEmployeeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeJButtonActionPerformed

        ResidentialManageEmployeeJPanel manageEmployeeJPanel = new ResidentialManageEmployeeJPanel(userProcessContainer, enterprise.getOrganizationsList());
        userProcessContainer.add("manageEmployeeJPanel", manageEmployeeJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_manageEmployeeJButtonActionPerformed

    private void manageOrganizationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationJButtonActionPerformed

        ResidentialManageOrganizationJPanel manageOrganizationJPanel = new ResidentialManageOrganizationJPanel(userProcessContainer, enterprise.getOrganizationsList());
        userProcessContainer.add("manageOrganizationJPanel", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageOrganizationJButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageEmployeeJButton;
    private javax.swing.JButton manageOrganizationJButton;
    private javax.swing.JButton userJButton;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
    
}
