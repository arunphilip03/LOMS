/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iiitb.gui;

/**
 *
 * @author ARUN
 */
public class RepositoryPanel extends javax.swing.JPanel {

    /**
     * Creates new form RepositoryPanel
     */
    public RepositoryPanel() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        repoToolBar = new javax.swing.JToolBar(javax.swing.JToolBar.VERTICAL);
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Package Repository", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.BELOW_TOP));
        setLayout(new java.awt.BorderLayout());

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Package 1", "Package 2", "Package 3" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        repoToolBar.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Gnome-Emblem-Downloads-32.png"))); // NOI18N
        jButton1.setToolTipText("Export");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        repoToolBar.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Gnome-Edit-Delete-32.png"))); // NOI18N
        jButton2.setToolTipText("Delete");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        repoToolBar.add(jButton2);

        add(repoToolBar, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar repoToolBar;
    // End of variables declaration//GEN-END:variables
}
