/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iiitb.gui;

import java.awt.CardLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author ARUN
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
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

        toolBar = new javax.swing.JToolBar();
        homeButton = new javax.swing.JButton();
        createButton = new javax.swing.JButton();
        importButton = new javax.swing.JButton();
        mergeButton = new javax.swing.JButton();
        displayPanel = new javax.swing.JPanel();
        repositoryPanel = new com.iiitb.gui.RepositoryPanel();
        importPanel = new com.iiitb.gui.ImportPanel();
        createPanel = new com.iiitb.gui.CreatePanel();
        exportPanel = new com.iiitb.gui.ExportPanel();
        configPanel = new com.iiitb.gui.ConfigPanel();
        mergePanel = new com.iiitb.gui.MergePanel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        optionMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("L.O.M.S");

        toolBar.setRollover(true);

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Gnome-Go-Home-32.png"))); // NOI18N
        homeButton.setText("Home");
        homeButton.setFocusable(false);
        homeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        homeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        toolBar.add(homeButton);

        createButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/scorm-icon.png"))); // NOI18N
        createButton.setText("Create");
        createButton.setFocusable(false);
        createButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        createButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonClicked(evt);
            }
        });
        toolBar.add(createButton);

        importButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add-Files-To-Archive-Blue-32.png"))); // NOI18N
        importButton.setText("Import");
        importButton.setFocusable(false);
        importButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        importButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });
        toolBar.add(importButton);

        mergeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/merge-cells-icon.png"))); // NOI18N
        mergeButton.setText("Merge");
        mergeButton.setFocusable(false);
        mergeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mergeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mergeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mergeButtonActionPerformed(evt);
            }
        });
        toolBar.add(mergeButton);

        getContentPane().add(toolBar, java.awt.BorderLayout.NORTH);

        displayPanel.setLayout(new java.awt.CardLayout());

        repositoryPanel.setEnabled(false);
        displayPanel.add(repositoryPanel, "repo_panel");
        displayPanel.add(importPanel, "import_panel");
        displayPanel.add(createPanel, "create_panel");
        displayPanel.add(exportPanel, "export_panel");
        displayPanel.add(configPanel, "config_panel");
        displayPanel.add(mergePanel, "merge_panel");

        getContentPane().add(displayPanel, java.awt.BorderLayout.CENTER);

        fileMenu.setText("File");

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        optionMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        optionMenuItem.setText("Options");
        optionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(optionMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(this, "Learning Object Management System v1.0\n\n Arun Philip Jacob"
                + "\n Ashrith Kulai"
                + "\n Gaurav Kulkarni"
                + "\n Venkatesan Muthu", "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void createButtonClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonClicked

        String s = (String) JOptionPane.showInputDialog(this, "Enter Package Name", "Package Name", JOptionPane.PLAIN_MESSAGE);
        if (s != null && s.length() > 0) {
            createPanel.populateTree(s);
            CardLayout card = (CardLayout) displayPanel.getLayout();
            card.show(displayPanel, "create_panel");
        }

    }//GEN-LAST:event_createButtonClicked

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        CardLayout card = (CardLayout) displayPanel.getLayout();
        card.show(displayPanel, "import_panel");
    }//GEN-LAST:event_importButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        CardLayout card = (CardLayout) displayPanel.getLayout();
        card.show(displayPanel, "repo_panel");
    }//GEN-LAST:event_homeButtonActionPerformed

    private void optionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionMenuItemActionPerformed
        CardLayout card = (CardLayout) displayPanel.getLayout();
        card.show(displayPanel, "config_panel");
    }//GEN-LAST:event_optionMenuItemActionPerformed

    private void mergeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mergeButtonActionPerformed
        CardLayout card = (CardLayout) displayPanel.getLayout();
        card.show(displayPanel, "merge_panel");
    }//GEN-LAST:event_mergeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private com.iiitb.gui.ConfigPanel configPanel;
    private javax.swing.JButton createButton;
    private com.iiitb.gui.CreatePanel createPanel;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JMenuItem exitMenuItem;
    private com.iiitb.gui.ExportPanel exportPanel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton homeButton;
    private javax.swing.JButton importButton;
    private com.iiitb.gui.ImportPanel importPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton mergeButton;
    private com.iiitb.gui.MergePanel mergePanel;
    private javax.swing.JMenuItem optionMenuItem;
    private com.iiitb.gui.RepositoryPanel repositoryPanel;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
