/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConfigFrame.java
 *
 * Created on Dec 24, 2009, 1:03:12 AM
 */

package datasoul.config;

import datasoul.DatasoulMainForm;
import datasoul.render.OutputDevice;
import datasoul.util.ObjectManager;
import java.awt.Component;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author samuel
 */
public class ConfigFrame extends javax.swing.JFrame {

    private ConfigObj configObj;
    private ArrayList<Component> components;



    /** Creates new form ConfigFrame */
    public ConfigFrame() {
        initComponents();

        DatasoulMainForm.setDatasoulIcon(this);

        initDeviceMenu();

        components = new ArrayList<Component>();
        registerComponents();

        configObj = ConfigObj.getNextInstance();
        refreshScreenValues();

        setSize(615,515);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        btnStgloc = new javax.swing.JButton();
        txtStorageLoc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbQualityMain = new javax.swing.JComboBox();
        cbMonitorOutput = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        clockMode = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cbDetectMonitors = new javax.swing.JCheckBox();
        pnlMonitors = new javax.swing.JPanel();
        cbMainDevice = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cbMonitorDevice = new javax.swing.JComboBox();
        lblMonitorDisabled = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnDiscard = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbOnlineUpdate = new javax.swing.JCheckBox();
        cbOnlineStats = new javax.swing.JCheckBox();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        setTitle(bundle.getString("DATASOUL CONFIGURATION")); // NOI18N

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("STORAGE LOCATION"))); // NOI18N

        btnStgloc.setText(bundle.getString("CHANGE")); // NOI18N
        btnStgloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStglocActionPerformed(evt);
            }
        });

        txtStorageLoc.setEditable(false);
        txtStorageLoc.setText("jTextField1");

        jLabel10.setText(bundle.getString("STORAGE DIRECTORY")); // NOI18N

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getSize()-2f));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/folder.png"))); // NOI18N
        jLabel1.setText(bundle.getString("DIRECTORY WHERE DATASOUL STORE ITS FILES")); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStorageLoc, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStgloc))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtStorageLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStgloc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Output Configuration"));

        jLabel7.setText(bundle.getString("RENDERING QUALITY")); // NOI18N

        cbQualityMain.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbMonitorOutput.setText(bundle.getString("ENABLE STAGE OUTPUT")); // NOI18N

        jLabel9.setText(bundle.getString("CLOCK FORMAT")); // NOI18N

        clockMode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getSize()-2f));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/stock_effects-preview_small.png"))); // NOI18N
        jLabel3.setText(bundle.getString("DISPLAY DEVICES AND RENDERING PROPERTIES")); // NOI18N

        cbDetectMonitors.setText(bundle.getString("AUTOMATICALLY DETECT OUTPUTS")); // NOI18N
        cbDetectMonitors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDetectMonitorsActionPerformed(evt);
            }
        });

        cbMainDevice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel28.setText(bundle.getString("MAIN OUTPUT")); // NOI18N

        jLabel29.setText(bundle.getString("STAGE OUTPUT")); // NOI18N

        cbMonitorDevice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnlMonitorsLayout = new javax.swing.GroupLayout(pnlMonitors);
        pnlMonitors.setLayout(pnlMonitorsLayout);
        pnlMonitorsLayout.setHorizontalGroup(
            pnlMonitorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMonitorsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMonitorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMonitorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbMonitorDevice, 0, 445, Short.MAX_VALUE)
                    .addComponent(cbMainDevice, 0, 445, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlMonitorsLayout.setVerticalGroup(
            pnlMonitorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMonitorsLayout.createSequentialGroup()
                .addGroup(pnlMonitorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMainDevice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMonitorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMonitorDevice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)))
        );

        lblMonitorDisabled.setText(bundle.getString("(YOU NEED AT LEAST 2 DISPLAYS TO ENABLE STAGE OUTPUT)")); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMonitors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cbDetectMonitors)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cbMonitorOutput)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMonitorDisabled))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clockMode, 0, 431, Short.MAX_VALUE)
                                    .addComponent(cbQualityMain, 0, 431, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMonitorOutput)
                    .addComponent(lblMonitorDisabled))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDetectMonitors)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMonitors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbQualityMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(clockMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/document-save.png"))); // NOI18N
        btnSave.setText(bundle.getString("SAVE AND CLOSE")); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDiscard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/window-close.png"))); // NOI18N
        btnDiscard.setText(bundle.getString("DISCARD AND CLOSE")); // NOI18N
        btnDiscard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiscardActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Online Actions"));

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getSize()-2f));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/web-browser.png"))); // NOI18N
        jLabel2.setText(bundle.getString("ALLOW THESE FUNCTIONS TO ACCESS INTERNET")); // NOI18N

        cbOnlineUpdate.setText(bundle.getString("NOTIFY ME WHEN A NEW VERSION OF DATASOUL IS AVAILABLE")); // NOI18N

        cbOnlineStats.setText(bundle.getString("SEND ANONYMOUS USAGE STATISTICS")); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("SansSerif", 1, 13));
        jTextArea1.setLineWrap(true);
        jTextArea1.setText(bundle.getString("IF YOU LIVE IN A COUNTRY WHERE CHRISTIANS ARE PERSECUTED AND DO NOT WISH TO RISK DETECTION YOU SHOULD NOT USE ANY OF THESE FUNCTIONS.")); // NOI18N
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(null);
        jTextArea1.setFocusable(false);
        jTextArea1.setOpaque(false);
        jTextArea1.setRequestFocusEnabled(false);
        jTextArea1.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cbOnlineUpdate)
                    .addComponent(cbOnlineStats)
                    .addComponent(jTextArea1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbOnlineUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbOnlineStats)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDiscard))
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDiscard)
                    .addComponent(btnSave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStglocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStglocActionPerformed
        JFileChooser fc = new JFileChooser();
        File dir = new File(txtStorageLoc.getText());
        fc.setCurrentDirectory(dir);
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setMultiSelectionEnabled(false);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //        fc.setDialogTitle("Select directory");
        if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION && fc.getSelectedFile().exists() ){
            txtStorageLoc.setText(fc.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_btnStglocActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try{
            ObjectManager.getInstance().setBusyCursor();
            refreshObjectValues();
            configObj.save();
            JOptionPane.showMessageDialog(this, java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("CONFIGURATION WILL TAKE EFFECT NEXT TIME DATASOUL IS STARTED"), "Datasoul", JOptionPane.INFORMATION_MESSAGE);

        }finally{
            ObjectManager.getInstance().setDefaultCursor();
        }
        dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDiscardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiscardActionPerformed
        dispose();
    }//GEN-LAST:event_btnDiscardActionPerformed

    private void cbDetectMonitorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDetectMonitorsActionPerformed
        pnlMonitors.setVisible(!cbDetectMonitors.isSelected());
        
    }//GEN-LAST:event_cbDetectMonitorsActionPerformed

    private void registerComponents(){
        registerComponent(cbMonitorOutput,"MonitorOutputIdx");
        registerComponent(cbDetectMonitors, "DetectMonitorsIdx");
        registerComponent(txtStorageLoc, "StorageLoc");

        registerComponent(clockMode,"ClockMode");
        clockMode.removeAllItems();
        for (int i=0; i<ConfigObj.CLOCKMODE_TABLE.length; i++){
            clockMode.addItem(ConfigObj.CLOCKMODE_TABLE[i]);
        }

        registerComponent(cbQualityMain, "QualityMain");
        cbQualityMain.removeAllItems();
        for (int i=0; i<ConfigObj.QUALITY_TABLE.length; i++){
            cbQualityMain.addItem(ConfigObj.QUALITY_TABLE[i]);
        }

        registerComponent(cbMainDevice, "MainOutputDevice");
        registerComponent(cbMonitorDevice, "MonitorOutputDevice");

        registerComponent(cbOnlineUpdate, "OnlineCheckUpdate");
        registerComponent(cbOnlineStats, "OnlineUsageStats");

    }

    private void initDeviceMenu(){

        cbMainDevice.removeAllItems();
        cbMonitorDevice.removeAllItems();

        for (GraphicsDevice gd : GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()){
            cbMainDevice.addItem(gd.getIDstring());
            cbMonitorDevice.addItem(gd.getIDstring());
        }

    }

    private void registerComponent(Component component, String string){
        components.add(component);
        component.setName(string);
    }

    private void setComponentValue(String string, Component component){
        if(component instanceof JCheckBox){
            if(string != null && string.compareToIgnoreCase("1")==0){
                ((JCheckBox)component).setSelected(true);
            }else{
                ((JCheckBox)component).setSelected(false);
            }
        }else if(component instanceof JComboBox){
            ((JComboBox)component).setSelectedItem(string);
        }else if(component instanceof JTextField){
            ((JTextField)component).setText(string);
        }
    }

    private String getComponentValue(Component component){
        if(component instanceof JCheckBox){
            if(((JCheckBox)component).isSelected()){
                return "1";
            }else{
                return "0";
            }
        }else if(component instanceof JComboBox){
            return (String)((JComboBox)component).getSelectedItem();
        }else if(component instanceof JTextField){
            return ((JTextField)component).getText();
        }
        return "";
    }

    private void refreshScreenValues(){
        for(Component component:components){
            try {
                Object o = configObj.getClass().getMethod("get"+component.getName()).invoke(configObj);
                setComponentValue( o.toString(), component);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        pnlMonitors.setVisible(!cbDetectMonitors.isSelected());

        boolean allowMonitor = OutputDevice.isMonitorAllowed();
        lblMonitorDisabled.setVisible(!allowMonitor);
        cbMonitorDevice.setEnabled(allowMonitor);
        cbMonitorOutput.setEnabled(allowMonitor);

    }

    private void refreshObjectValues(){
        for(Component component:components){
            try {
                configObj.getClass().getMethod("set"+component.getName(), String.class).invoke(configObj, getComponentValue(component));
            } catch (Exception ex) {
                System.err.println("Setting "+component.getName()+":");
                ex.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDiscard;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnStgloc;
    private javax.swing.JCheckBox cbDetectMonitors;
    private javax.swing.JComboBox cbMainDevice;
    private javax.swing.JComboBox cbMonitorDevice;
    private javax.swing.JCheckBox cbMonitorOutput;
    private javax.swing.JCheckBox cbOnlineStats;
    private javax.swing.JCheckBox cbOnlineUpdate;
    private javax.swing.JComboBox cbQualityMain;
    private javax.swing.JComboBox clockMode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblMonitorDisabled;
    private javax.swing.JPanel pnlMonitors;
    private javax.swing.JTextField txtStorageLoc;
    // End of variables declaration//GEN-END:variables

}


