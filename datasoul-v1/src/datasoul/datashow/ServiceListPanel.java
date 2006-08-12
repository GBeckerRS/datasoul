/*
 * ServiceListPanel.java
 *
 * Created on 26 de Dezembro de 2005, 23:14
 */

package datasoul.datashow;

import datasoul.*;
import datasoul.templates.TemplateComboBox;
import datasoul.templates.TemplateManager;
import datasoul.util.*;
import datasoul.datashow.*;
import datasoul.song.*;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.xml.serialize.OutputFormat;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author  Administrador
 */
public class ServiceListPanel extends javax.swing.JPanel implements javax.swing.event.TableModelListener{

    private String fileName="";
    /**
     * Creates new form ServiceListPanel
     */
    public ServiceListPanel() {
        initComponents();
       
       ServiceListTable serviceListTable = ServiceListTable.getActiveInstance();
       
       serviceListTable.addTableModelListener(this);        
        
       tableServiceList.setModel(serviceListTable);

        //initTemplateCombo
        TemplateComboBox comboBox = new TemplateComboBox(); 
        comboBox.setFilterType(TemplateComboBox.FILTER_GENERAL);
        this.tableServiceList.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(comboBox));          
        
        ServiceListColorRender cr = new ServiceListColorRender();
        
        this.tableServiceList.getColumnModel().getColumn(0).setCellRenderer(cr);
        this.tableServiceList.getColumnModel().getColumn(1).setCellRenderer(cr);        
    }

    
    private String getFileName(){
        return this.fileName;
    }
    private void setFileName(String fileName){
        this.fileName = fileName;
    }

    public void tableChanged(TableModelEvent e) {
        this.repaint();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        toolBar = new javax.swing.JToolBar();
        btnOpen = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnSaveAs = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnExportWizard = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnAddWizard = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        scroolServiceList = new javax.swing.JScrollPane();
        tableServiceList = new datasoul.util.DnDTable();

        setDoubleBuffered(false);
        toolBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        toolBar.setMinimumSize(new java.awt.Dimension(30, 25));
        btnOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/open.gif")));
        btnOpen.setToolTipText("Load service list ...");
        btnOpen.setAlignmentY(0.0F);
        btnOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOpenMouseClicked(evt);
            }
        });

        toolBar.add(btnOpen);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/save.gif")));
        btnSave.setToolTipText("Save service list");
        btnSave.setAlignmentY(0.0F);
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        toolBar.add(btnSave);

        btnSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/saveAs.gif")));
        btnSaveAs.setToolTipText("Save service list as... ");
        btnSaveAs.setAlignmentY(0.0F);
        btnSaveAs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveAsMouseClicked(evt);
            }
        });

        toolBar.add(btnSaveAs);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setAlignmentX(0.0F);
        jSeparator1.setAlignmentY(0.0F);
        jSeparator1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jSeparator1.setMaximumSize(new java.awt.Dimension(5, 32767));
        toolBar.add(jSeparator1);

        btnExportWizard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/exportWizard.gif")));
        btnExportWizard.setToolTipText("Export wizard ...");
        btnExportWizard.setAlignmentY(0.0F);
        btnExportWizard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportWizardActionPerformed(evt);
            }
        });

        toolBar.add(btnExportWizard);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setAlignmentX(0.0F);
        jSeparator2.setAlignmentY(0.0F);
        jSeparator2.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jSeparator2.setMaximumSize(new java.awt.Dimension(5, 32767));
        toolBar.add(jSeparator2);

        btnAddWizard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/addWizard.gif")));
        btnAddWizard.setToolTipText("Add wizard ...");
        btnAddWizard.setAlignmentY(0.0F);
        btnAddWizard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        toolBar.add(btnAddWizard);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/edit.gif")));
        btnEdit.setToolTipText("Edit selected item ...");
        btnEdit.setAlignmentY(0.0F);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        toolBar.add(btnEdit);

        btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/up.gif")));
        btnUp.setToolTipText("Change item order to upper position");
        btnUp.setAlignmentY(0.0F);
        btnUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpMouseClicked(evt);
            }
        });

        toolBar.add(btnUp);

        btnDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/down.gif")));
        btnDown.setToolTipText("Change item order to lower position");
        btnDown.setAlignmentY(0.0F);
        btnDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDownMouseClicked(evt);
            }
        });

        toolBar.add(btnDown);

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/remove.gif")));
        btnRemove.setToolTipText("Delete item");
        btnRemove.setAlignmentY(0.0F);
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
        });

        toolBar.add(btnRemove);

        tableServiceList.setModel(new javax.swing.table.DefaultTableModel(
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
        tableServiceList.setCellSelectionEnabled(true);
        tableServiceList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableServiceListKeyPressed(evt);
            }
        });
        tableServiceList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableServiceListMouseClicked(evt);
            }
        });

        scroolServiceList.setViewportView(tableServiceList);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(scroolServiceList, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
            .add(toolBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(scroolServiceList, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(toolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        
        if (tableServiceList.getSelectedRow() == -1){
            return;
        }
        
        ServiceItem item = (ServiceItem)tableServiceList.getModel().getValueAt(tableServiceList.getSelectedRow(),0);
        if(item instanceof Song){
            SongEditorForm sef = new SongEditorForm((Song)item);
            sef.setVisible(true);
        }else if(item instanceof TextServiceItem){
            TextServiceItemEditorForm tsief = new TextServiceItemEditorForm((TextServiceItem)item);
            tsief.setVisible(true);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        AddWizardForm awf = new AddWizardForm();
        awf.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnExportWizardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportWizardActionPerformed
        ExportWizardForm exportWizardForm = new ExportWizardForm();
        exportWizardForm.setVisible(true);
    }//GEN-LAST:event_btnExportWizardActionPerformed

    private void tableServiceListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableServiceListKeyPressed
        showItem();
    }//GEN-LAST:event_tableServiceListKeyPressed

    private void tableServiceListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableServiceListMouseClicked
        showItem();
    }//GEN-LAST:event_tableServiceListMouseClicked

    private void showItem(){
        
        try{
            ObjectManager.getInstance().setBusyCursor();
            if(ObjectManager.getInstance().getViewActive()==ObjectManager.VIEW_PROJECTOR){
                if(ObjectManager.getInstance().getPreviewPanel()!=null)
                    ObjectManager.getInstance().getPreviewPanel().previewItem((ServiceItem)tableServiceList.getModel().getValueAt(tableServiceList.getSelectedRow(),0));
            }
            if(ObjectManager.getInstance().getViewActive()==ObjectManager.VIEW_SONGS){
                ServiceItem item = (ServiceItem)tableServiceList.getModel().getValueAt(tableServiceList.getSelectedRow(),0);
                if(item instanceof Song)
                    if(ObjectManager.getInstance().getSongViewerPanel()!=null)
                        ObjectManager.getInstance().getSongViewerPanel().viewSong((Song)item);
            }
        }finally{
            ObjectManager.getInstance().setDefaultCursor();
        }
    }
    
    private void btnOpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOpenMouseClicked
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new javax.swing.filechooser.FileFilter() { 
                      public boolean accept(File f) { 
                          if (f.isDirectory()) { 
                              return true; 
                          } 
                          String name = f.getName(); 
                          if (name.endsWith(".servicelist")) { 
                              return true; 
                          } 
                          return false; 
                      } 
   
                      public String getDescription() { 
                          return ".servicelist"; 
                      } 
                  });
        File dir = new File (System.getProperty("user.dir") + System.getProperty("file.separator") + "serviceslist");
        fc.setCurrentDirectory(dir);
        if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            fileName = fc.getSelectedFile().getPath();

            File file = new File(fileName);

            Document dom=null;
            Node node = null;
            ServiceListTable slt;
            try {
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

                    //Using factory get an instance of document builder
                    DocumentBuilder db = dbf.newDocumentBuilder();

                    //parse using builder to get DOM representation of the XML file
                    dom = db.parse(file);

                    //node = dom.getDocumentElement().getChildNodes().item(0);
                    node = dom.getElementsByTagName("ServiceListTable").item(0);

            }catch(Exception e) {
                JOptionPane.showMessageDialog(this,"Error, the file is not well formed\nErro:"+e.getMessage(),"DataSoul Error",0);    
            }        

            slt = ServiceListTable.getActiveInstance();
            try {
                slt.readObject(node);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Error, the file is not well formed\nErro:"+e.getMessage(),"DataSoul Error",0);    
            }
         
            tableServiceList.setModel(slt);
        }
    }//GEN-LAST:event_btnOpenMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if(!fileName.contains(".servicelist"))
            fileName = fileName + ".servicelist";

        if(fileName.equals("")){
            btnSaveAsMouseClicked(evt);
            return;
        }
        
        saveFile();
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSaveAsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveAsMouseClicked
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new javax.swing.filechooser.FileFilter() { 
                      public boolean accept(File f) { 
                          if (f.isDirectory()) { 
                              return true; 
                          } 
                          String name = f.getName(); 
                          if (name.endsWith(".servicelist")) { 
                              return true; 
                          } 
                          return false; 
                      } 
   
                      public String getDescription() { 
                          return ".servicelist"; 
                      } 
                  });
        File dir = new File (System.getProperty("user.dir") + System.getProperty("file.separator") + "serviceslist");
        fc.setCurrentDirectory(dir);
        fc.setDialogTitle("Select the file to save.");
        if(fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION){
            fileName = fc.getSelectedFile().getPath();
            if(!fileName.contains(".servicelist"))
                 fileName = fileName + ".servicelist";            
            saveFile();
        }

    }//GEN-LAST:event_btnSaveAsMouseClicked

    private void saveFile(){
        try{
            ServiceListTable slt = (ServiceListTable)tableServiceList.getModel();
            Node node = slt.writeObject();
            Document doc = node.getOwnerDocument();
            doc.appendChild( node);                        // Add Root to Document
            FileOutputStream fos = new FileOutputStream(fileName);
            org.apache.xml.serialize.XMLSerializer xs = new org.apache.xml.serialize.XMLSerializer();
            OutputFormat outFormat = new OutputFormat();
            outFormat.setIndenting(true);
            outFormat.setEncoding("ISO-8859-1");
            xs.setOutputFormat(outFormat);
            xs.setOutputByteStream(fos);
            xs.serialize(doc);

        } catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error writing file.\nErro:"+e.getMessage(),"DataSoul Error",0);    
        }
    }

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
        tableServiceList.removeItem();
    }//GEN-LAST:event_btnRemoveMouseClicked

    private void btnDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDownMouseClicked
        tableServiceList.downItem();
    }//GEN-LAST:event_btnDownMouseClicked

    private void btnUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpMouseClicked
        tableServiceList.upItem();
    }//GEN-LAST:event_btnUpMouseClicked
    
    public void addItem(Object object){
        ((ListTable)tableServiceList.getModel()).addItem(object);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddWizard;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExportWizard;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveAs;
    private javax.swing.JButton btnUp;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JScrollPane scroolServiceList;
    private datasoul.util.DnDTable tableServiceList;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
    
}
