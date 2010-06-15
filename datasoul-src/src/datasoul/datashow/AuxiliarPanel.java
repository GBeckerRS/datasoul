/* 
 * Copyright 2005-2008 Samuel Mello & Eduardo Schnell
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; version 2 of the License.
 * 
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 * 
 */

/*
 * AuxiliarPanel.java
 *
 * Created on 26 de Dezembro de 2005, 23:37
 */

package datasoul.datashow;

import datasoul.config.ConfigObj;
import datasoul.util.ObjectManager;

/**
 *
 * @author  Administrador
 */
public class AuxiliarPanel extends javax.swing.JPanel {

    public static final int TAB_DISPLAY = 0;
    public static final int TAB_ALARM = 1;
    public static final int TAB_CLOCK = 2;
    /**
     * Creates new form AuxiliarPanel
     */
    public AuxiliarPanel() {
        initComponents();

        ObjectManager.getInstance().setAuxiliarPanel(this);
        if (!ConfigObj.getActiveInstance().getTrackDurationBool()){
            tabAuxiliar.removeTabAt(TAB_CLOCK);
        }
        
    }

    public DisplayControlPanel getDisplayControlPanel(){
        return this.displayControlPanel1;
    }
    
    public void setVisibleTab(int tab) {
        this.tabAuxiliar.setSelectedIndex(tab);
    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabAuxiliar = new javax.swing.JTabbedPane();
        displayControlPanel1 = new datasoul.datashow.DisplayControlPanel();
        alertControlPanel1 = new datasoul.datashow.AlertControlPanel();
        timerControlPanel1 = new datasoul.datashow.TimerControlPanel();

        tabAuxiliar.setToolTipText("");
        tabAuxiliar.setMaximumSize(new java.awt.Dimension(32767, 250));
        tabAuxiliar.setMinimumSize(new java.awt.Dimension(0, 0));
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        tabAuxiliar.addTab(bundle.getString("OUTPUT"), new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/video-display.png")), displayControlPanel1); // NOI18N
        tabAuxiliar.addTab(bundle.getString("ALERT"), new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/stock_bell.png")), alertControlPanel1); // NOI18N
        tabAuxiliar.addTab(bundle.getString("TIMER"), new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/stock_timer.png")), timerControlPanel1); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabAuxiliar, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabAuxiliar, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void templateMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_templateMonitorActionPerformed
        
        
    }//GEN-LAST:event_templateMonitorActionPerformed

    
        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datasoul.datashow.AlertControlPanel alertControlPanel1;
    private datasoul.datashow.DisplayControlPanel displayControlPanel1;
    private javax.swing.JTabbedPane tabAuxiliar;
    private datasoul.datashow.TimerControlPanel timerControlPanel1;
    // End of variables declaration//GEN-END:variables
    
}

