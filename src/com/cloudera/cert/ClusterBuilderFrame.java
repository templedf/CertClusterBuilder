package com.cloudera.cert;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel@cloudera.com
 */
public class ClusterBuilderFrame extends javax.swing.JFrame {
    private static final String DEFAULT_MESSAGE = "Ready";
    private static ConsoleFrame consoleFrame = null;
    private static final Timer delayTimer = new Timer();
    private TimerTask delayTask = null;
    
    /**
     * Creates new form ClusterBuilderFrame
     */
    public ClusterBuilderFrame() {
        initComponents();
        
        consoleFrame = new ConsoleFrame(this);
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
        jLabel5 = new javax.swing.JLabel();
        console = new javax.swing.JButton();
        brooklyn = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        userField = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        deploy = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        provider = new javax.swing.JComboBox();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(603, 476));
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cloudera_connect_logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 32)); // NOI18N
        jLabel2.setText("Certification Cluster Builder");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Cloud Provider Information");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("User credential");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("Private credential");

        console.setText("View Console");
        console.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewConsole(evt);
            }
        });

        brooklyn.setText("Launch Brooklyn UI");
        brooklyn.setEnabled(false);
        brooklyn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchBrooklynUI(evt);
            }
        });

        passwordField.setMaximumSize(new java.awt.Dimension(14, 28));

        userField.setMaximumSize(new java.awt.Dimension(14, 28));

        jLabel7.setText("Powered by");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/brooklyn_sm.png"))); // NOI18N

        deploy.setText("Deploy Cluster");
        deploy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deployCluster(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setText("Provider");

        provider.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Amazon East", "Amazon West", "Go Grid", "Rackspace" }));

        status.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        status.setForeground(new java.awt.Color(51, 51, 51));
        status.setText(DEFAULT_MESSAGE);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(48, 48, 48)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel2)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(53, 53, 53))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 467, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel3)
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jLabel4)
                                            .add(jLabel9)
                                            .add(jLabel5))
                                        .add(32, 32, 32)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                            .add(provider, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(passwordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 147, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(userField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 147, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                .add(26, 26, 26)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(brooklyn)
                                    .add(deploy, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 165, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(console, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 165, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(67, 67, 67)
                                .add(jLabel6))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(status, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 340, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel7)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel8)
                                .add(24, 24, 24)))
                        .add(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(45, 45, 45)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel2)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(9, 9, 9)
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createSequentialGroup()
                                .add(deploy, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(console, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(brooklyn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(jLabel3)
                                .add(21, 21, 21)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel9)
                                    .add(provider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel4)
                                    .add(userField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel5)
                                    .add(passwordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel7)
                                .add(status))
                            .add(jLabel8)))
                    .add(layout.createSequentialGroup()
                        .add(154, 154, 154)
                        .add(jLabel6)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewConsole(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewConsole
        setTempStatus("Opening Console...");
        console.setEnabled(false);
        consoleFrame.pack();
        consoleFrame.setVisible(true);
    }//GEN-LAST:event_viewConsole

    private void launchBrooklynUI(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchBrooklynUI
        setTempStatus("Launching browser...");
        
        try {
            Desktop.getDesktop().browse(new URI("http://localhost:" + CertClusterBuilder.getPort()));
        } catch (IOException ex) {
            Logger.getLogger(ClusterBuilderFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ClusterBuilderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_launchBrooklynUI

    private void deployCluster(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deployCluster
        deploy.setEnabled(false);
        
        String cloudCode = null;
        String cloudSpec = null;
        String cloudName = provider.getSelectedItem().toString();
        
        if (cloudName.equals("Amazon East")) {
            cloudCode = "aws-ec2";
            cloudSpec = "us-east-1";
        } else if (cloudName.equals("Amazon West")) {
            cloudCode = "aws-ec2";
            cloudSpec = "us-west-1";
        } else if (cloudName.equals("Rackspace")) {
            cloudCode = "rackspace-cloudservers-us";
        } else if (cloudName.equals("Go Grid")) {
            cloudCode = "gogrid";
        }

//        setStatus("starting");
        CertClusterBuilder.launch(cloudCode, cloudSpec, userField.getText(), passwordField.getText());
        
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            brooklyn.setEnabled(true);
        }
    }//GEN-LAST:event_deployCluster

    void consoleClosed() {
        console.setEnabled(true);
    }
    
    void setStatus(String message) {
        if (delayTask != null) {
            delayTask.cancel();
        }
        
        status.setText(message.trim());
    }
    
    void setDefaultStatus() {
        setStatus(DEFAULT_MESSAGE);
    }
    
    void setTempStatus(String message) {
        setStatus(message.trim());
        setDelayedStatus(DEFAULT_MESSAGE, 3);
    }
    
    private void setDelayedStatus(final String message, int delay) {
        delayTask = new DelayTask(message);
        delayTimer.schedule(delayTask, delay * 1000);
    }
    
    void addOutput(String message) {
        consoleFrame.addOutput(message);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClusterBuilderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClusterBuilderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClusterBuilderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClusterBuilderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClusterBuilderFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brooklyn;
    private javax.swing.JButton console;
    private javax.swing.JButton deploy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JComboBox provider;
    private javax.swing.JLabel status;
    private javax.swing.JPasswordField userField;
    // End of variables declaration//GEN-END:variables

    private class DelayTask extends TimerTask {
        private String message;

        DelayTask(String message) {
            this.message = message;
        }
        
        @Override
        public void run() {
            setStatus(message);
        }
    }
}
