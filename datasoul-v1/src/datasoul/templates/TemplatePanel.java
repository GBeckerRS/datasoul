/*
 * TemplatePanel.java
 *
 * Created on February 25, 2006, 10:11 AM
 */

package datasoul.templates;

import datasoul.util.ObjectManager;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author  samuelm
 */
public class TemplatePanel extends javax.swing.JPanel {
    
    /** Creates new form TemplatePanel */
    public TemplatePanel() {
        initComponents();
        
        TemplateManager manager = TemplateManager.getInstance();
        manager.refreshAvailableTemplates();
        jTableTemplates.setModel( manager );
        
        templateEditorPanel1.setPropertiesTable(jTableProperties);
        
        lblTemplateName.setText( templateEditorPanel1.getTemplate().getName() );
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelTemplateEditor = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTemplateName = new javax.swing.JLabel();
        templateEditorPanel1 = new datasoul.templates.TemplateEditorPanel();
        jPanel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnAddText = new javax.swing.JButton();
        btnDeleteItem = new javax.swing.JButton();
        btnMoveUp = new javax.swing.JButton();
        btnMoveDown = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAddImage = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnTimerProgress = new javax.swing.JButton();
        btnProperties = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSplitPane2 = new javax.swing.JSplitPane();
        panelTemplates = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTemplates = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnLoad = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnDeleteTemplate = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel6 = new javax.swing.JLabel();
        panelProperties = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProperties = new javax.swing.JTable();
        jToolBar3 = new javax.swing.JToolBar();
        jLabel7 = new javax.swing.JLabel();

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(250);
        panelTemplateEditor.setAutoscrolls(true);
        jLabel1.setText("Template:");

        lblTemplateName.setText("jLabel2");

        org.jdesktop.layout.GroupLayout templateEditorPanel1Layout = new org.jdesktop.layout.GroupLayout(templateEditorPanel1);
        templateEditorPanel1.setLayout(templateEditorPanel1Layout);
        templateEditorPanel1Layout.setHorizontalGroup(
            templateEditorPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 636, Short.MAX_VALUE)
        );
        templateEditorPanel1Layout.setVerticalGroup(
            templateEditorPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 476, Short.MAX_VALUE)
        );

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/filesave.png")));
        btnSave.setText("Save");
        btnSave.setToolTipText("Save template");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnAddText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/fonts.png")));
        btnAddText.setText("Text");
        btnAddText.setToolTipText("Add a text");
        btnAddText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTextActionPerformed(evt);
            }
        });

        btnDeleteItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/editdelete.png")));
        btnDeleteItem.setText("Remove");
        btnDeleteItem.setToolTipText("Delete item");
        btnDeleteItem.setMaximumSize(new java.awt.Dimension(91, 26));
        btnDeleteItem.setMinimumSize(new java.awt.Dimension(91, 26));
        btnDeleteItem.setPreferredSize(new java.awt.Dimension(91, 26));
        btnDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteItemActionPerformed(evt);
            }
        });

        btnMoveUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/raise.png")));
        btnMoveUp.setText("To Front");
        btnMoveUp.setToolTipText("Move the item to the upper layer");
        btnMoveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveUpActionPerformed(evt);
            }
        });

        btnMoveDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/lower.png")));
        btnMoveDown.setText("To Back");
        btnMoveDown.setToolTipText("Move the item to the lowest layer");
        btnMoveDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveDownActionPerformed(evt);
            }
        });

        jLabel2.setText("Template");

        jLabel3.setText("Add Item");

        btnAddImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/looknfeel_1.png")));
        btnAddImage.setText("Image");
        btnAddImage.setToolTipText("Add an image ...");
        btnAddImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddImageActionPerformed(evt);
            }
        });

        jLabel4.setText("Selected Item");

        btnTimerProgress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/kalarm.png")));
        btnTimerProgress.setText("Timer");
        btnTimerProgress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimerProgressActionPerformed(evt);
            }
        });

        btnProperties.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/info.png")));
        btnProperties.setText("Properties");
        btnProperties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPropertiesActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jLabel2)
                .addContainerGap(59, Short.MAX_VALUE))
            .add(btnAddText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
            .add(btnAddImage, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
            .add(btnSave, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
            .add(btnTimerProgress, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
            .add(btnDeleteItem, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
            .add(btnMoveDown, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
            .add(btnMoveUp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
            .add(btnProperties, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jLabel3)
                .addContainerGap())
            .add(jPanel1Layout.createSequentialGroup()
                .add(jLabel4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnSave)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnProperties)
                .add(28, 28, 28)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnAddText)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnAddImage)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnTimerProgress)
                .add(28, 28, 28)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnMoveUp)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnMoveDown)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnDeleteItem, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Dialog", 2, 12));
        jLabel5.setText("Hold Shift down for resizing itens");

        org.jdesktop.layout.GroupLayout panelTemplateEditorLayout = new org.jdesktop.layout.GroupLayout(panelTemplateEditor);
        panelTemplateEditor.setLayout(panelTemplateEditorLayout);
        panelTemplateEditorLayout.setHorizontalGroup(
            panelTemplateEditorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelTemplateEditorLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelTemplateEditorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelTemplateEditorLayout.createSequentialGroup()
                        .add(templateEditorPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jLabel5)
                    .add(jLabel1)
                    .add(lblTemplateName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelTemplateEditorLayout.setVerticalGroup(
            panelTemplateEditorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelTemplateEditorLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblTemplateName)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelTemplateEditorLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(panelTemplateEditorLayout.createSequentialGroup()
                        .add(templateEditorPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel5)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jScrollPane3.setViewportView(panelTemplateEditor);

        jSplitPane1.setRightComponent(jScrollPane3);

        jSplitPane2.setBorder(null);
        jSplitPane2.setDividerLocation(250);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        panelTemplates.setDoubleBuffered(false);
        jTableTemplates.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableTemplates);

        jToolBar1.setFloatable(false);
        btnLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/fileopen.png")));
        btnLoad.setText("Load");
        btnLoad.setToolTipText("Load selected template");
        btnLoad.setBorderPainted(false);
        btnLoad.setFocusPainted(false);
        btnLoad.setOpaque(false);
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        jToolBar1.add(btnLoad);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/filenew.png")));
        btnNew.setText("New");
        btnNew.setToolTipText("Create a new template");
        btnNew.setBorderPainted(false);
        btnNew.setFocusPainted(false);
        btnNew.setOpaque(false);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        jToolBar1.add(btnNew);

        btnDeleteTemplate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/edittrash.png")));
        btnDeleteTemplate.setText("Delete");
        btnDeleteTemplate.setToolTipText("Delete selected template");
        btnDeleteTemplate.setBorderPainted(false);
        btnDeleteTemplate.setFocusPainted(false);
        btnDeleteTemplate.setOpaque(false);
        btnDeleteTemplate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTemplateActionPerformed(evt);
            }
        });

        jToolBar1.add(btnDeleteTemplate);

        jToolBar2.setFloatable(false);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/images.png")));
        jLabel6.setText("Templates");
        jToolBar2.add(jLabel6);

        org.jdesktop.layout.GroupLayout panelTemplatesLayout = new org.jdesktop.layout.GroupLayout(panelTemplates);
        panelTemplates.setLayout(panelTemplatesLayout);
        panelTemplatesLayout.setHorizontalGroup(
            panelTemplatesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jToolBar2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelTemplatesLayout.setVerticalGroup(
            panelTemplatesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelTemplatesLayout.createSequentialGroup()
                .add(jToolBar2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        jSplitPane2.setTopComponent(panelTemplates);

        jTableProperties.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableProperties);

        jToolBar3.setFloatable(false);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/info.png")));
        jLabel7.setText("Properties");
        jToolBar3.add(jLabel7);

        org.jdesktop.layout.GroupLayout panelPropertiesLayout = new org.jdesktop.layout.GroupLayout(panelProperties);
        panelProperties.setLayout(panelPropertiesLayout);
        panelPropertiesLayout.setHorizontalGroup(
            panelPropertiesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jToolBar3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        panelPropertiesLayout.setVerticalGroup(
            panelPropertiesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelPropertiesLayout.createSequentialGroup()
                .add(jToolBar3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
        );
        jSplitPane2.setBottomComponent(panelProperties);

        jSplitPane1.setLeftComponent(jSplitPane2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jSplitPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1054, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jSplitPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPropertiesActionPerformed
        templateEditorPanel1.unselectItem();
    }//GEN-LAST:event_btnPropertiesActionPerformed

    private void btnTimerProgressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimerProgressActionPerformed
        TimerProgressbarTemplateItem timer = new TimerProgressbarTemplateItem();
        templateEditorPanel1.addItem(timer);
    }//GEN-LAST:event_btnTimerProgressActionPerformed

    private void btnDeleteTemplateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTemplateActionPerformed


        if ( jTableTemplates.getSelectedRowCount() == 1){
            Object x = jTableTemplates.getValueAt( jTableTemplates.getSelectedRow(), jTableTemplates.getSelectedColumn() );
            if (x instanceof String){
                String str = (String) x;
                int confirm = JOptionPane.showConfirmDialog(this, "Delete template "+x+"?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION){
                    try{
                        TemplateManager.getInstance().deleteTemplate(str);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this,"Unable to delete template:\n"+e.getMessage(),"Datasoul Error",0);    
                    }// try
                }//if confirm
            }// if instance of
        }// if selected

        
    }//GEN-LAST:event_btnDeleteTemplateActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed

        int resp = JOptionPane.showConfirmDialog(this, "Do you want to save "+templateEditorPanel1.getTemplate().getName()+ "?" );
        
        switch(resp){
            case JOptionPane.CANCEL_OPTION:
                return;
            case JOptionPane.YES_OPTION:
                templateEditorPanel1.save();
                break;
        }
        
        try{
            ObjectManager.getInstance().setBusyCursor();
            if ( jTableTemplates.getSelectedRowCount() == 1){
                Object x = jTableTemplates.getValueAt( jTableTemplates.getSelectedRow(), jTableTemplates.getSelectedColumn() );
                if (x instanceof String){
                    String str = (String) x;
                    templateEditorPanel1.open( str );
                    lblTemplateName.setText( str );
                }
            }
            TemplateManager.getInstance().refreshAvailableTemplates();
        }finally{
            ObjectManager.getInstance().setDefaultCursor();
        }

    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        templateEditorPanel1.openNewTemplate();
        lblTemplateName.setText( templateEditorPanel1.getTemplate().getName() );
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        try{
            ObjectManager.getInstance().setBusyCursor();
            templateEditorPanel1.save();
            TemplateManager.getInstance().refreshAvailableTemplates();
            lblTemplateName.setText( templateEditorPanel1.getTemplate().getName() );
        }finally{
            ObjectManager.getInstance().setDefaultCursor();
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteItemActionPerformed
        templateEditorPanel1.deleteSelectedItem();
    }//GEN-LAST:event_btnDeleteItemActionPerformed

    private void btnAddTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTextActionPerformed
        TextTemplateItem txt = new TextTemplateItem();
        templateEditorPanel1.addItem(txt);
    }//GEN-LAST:event_btnAddTextActionPerformed

    private void btnAddImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddImageActionPerformed
        JFileChooser fc = new JFileChooser();
        File dir = new File (System.getProperty("user.dir") + System.getProperty("file.separator") + "templates");
        fc.setCurrentDirectory(dir);
        fc.setDialogType(JFileChooser.OPEN_DIALOG);
        fc.setMultiSelectionEnabled(false);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setControlButtonsAreShown(true);
        fc.setDialogTitle("Select Image");
        if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION && fc.getSelectedFile().exists() ){
            String filename = fc.getSelectedFile().getAbsolutePath();
            ImageTemplateItem img = new ImageTemplateItem( filename );
            templateEditorPanel1.addItem(img);
        }
    }//GEN-LAST:event_btnAddImageActionPerformed

    private void btnMoveUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveUpActionPerformed
        templateEditorPanel1.moveUpSelectedItem();
    }//GEN-LAST:event_btnMoveUpActionPerformed

    private void btnMoveDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveDownActionPerformed
        templateEditorPanel1.moveDownSelectedItem();
    }//GEN-LAST:event_btnMoveDownActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddImage;
    private javax.swing.JButton btnAddText;
    private javax.swing.JButton btnDeleteItem;
    private javax.swing.JButton btnDeleteTemplate;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnMoveDown;
    private javax.swing.JButton btnMoveUp;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnProperties;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTimerProgress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTable jTableProperties;
    private javax.swing.JTable jTableTemplates;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JLabel lblTemplateName;
    private javax.swing.JPanel panelProperties;
    private javax.swing.JPanel panelTemplateEditor;
    private javax.swing.JPanel panelTemplates;
    private datasoul.templates.TemplateEditorPanel templateEditorPanel1;
    // End of variables declaration//GEN-END:variables
    
}
