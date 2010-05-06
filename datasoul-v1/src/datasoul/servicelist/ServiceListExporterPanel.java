/*
 * ServiceListExporterPanel.java
 *
 * Created on June 4, 2008, 11:44 PM
 */

package datasoul.servicelist;

import com.lowagie.text.DocumentException;
import datasoul.DatasoulMainForm;
import datasoul.config.BackgroundConfig;
import datasoul.serviceitems.ServiceItem;
import datasoul.serviceitems.text.TextServiceItem;
import datasoul.render.ContentRender;
import datasoul.serviceitems.song.Song;
import datasoul.templates.DisplayTemplate;
import datasoul.templates.TemplateManager;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author  samuel
 */
public class ServiceListExporterPanel extends javax.swing.JFrame {

    public static final int MODE_EXPORT = 0;
    public static final int MODE_PRINT = 1;

    /** Creates new form ServiceListExporterPanel */
    public ServiceListExporterPanel() {
        initComponents();
        DatasoulMainForm.setDatasoulIcon(this);
        pbProgress.setVisible(false);
    }
    
    private Song singleSong = null;
    private int mode;
    
    public void setSingleSong(Song s){
        singleSong = s;
        cbServicePlan.setSelected(false);
        cbServicePlan.setEnabled(false);
        rbSlides.setEnabled(false);
    }

    public boolean setMode(int mode){
        String action = "";
        switch (mode){
            case MODE_EXPORT:
                action = java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("EXPORT");
                break;
            case MODE_PRINT:
                action = java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("PRINT");
                if (! Desktop.isDesktopSupported() || ! Desktop.getDesktop().isSupported(Desktop.Action.PRINT) ){
                    JOptionPane.showMessageDialog(ServiceListExporterPanel.this, java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("PRINT SUPPORT IS NOT ENABLED BY JAVA IN YOUR PLATFORM.")
                            +"\n"+ java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("PLEASE USE EXPORT FUNCTION AND PRINT IT MANUALLY."));
                    return false;
                }
                break;
        }

        if (singleSong == null){
            lblTitle.setText(action+" "+java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("SERVICE LIST"));
        }else{
            lblTitle.setText(action+" "+java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("SONG"));
        }

        this.mode = mode;

        return true;
    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblTitle = new javax.swing.JLabel();
        cbServicePlan = new javax.swing.JCheckBox();
        cbLyrics = new javax.swing.JCheckBox();
        cbChordsSimple = new javax.swing.JCheckBox();
        cbChordsComplete = new javax.swing.JCheckBox();
        cbOk = new javax.swing.JButton();
        lblFormat = new javax.swing.JLabel();
        cbFormat = new javax.swing.JComboBox();
        cbCancel = new javax.swing.JButton();
        rbPrintout = new javax.swing.JRadioButton();
        rbSlides = new javax.swing.JRadioButton();
        pbProgress = new javax.swing.JProgressBar();
        cbEmptySlide = new javax.swing.JCheckBox();
        cbGuitarTabs = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        setTitle(bundle.getString("EXPORT SERVICE LIST")); // NOI18N

        lblTitle.setFont(lblTitle.getFont().deriveFont(lblTitle.getFont().getStyle() | java.awt.Font.BOLD));
        lblTitle.setText(bundle.getString("PRINT SERVICE LIST")); // NOI18N

        cbServicePlan.setSelected(true);
        cbServicePlan.setText(bundle.getString("SERVICE PLAN")); // NOI18N
        cbServicePlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbServicePlanActionPerformed(evt);
            }
        });

        cbLyrics.setSelected(true);
        cbLyrics.setText(bundle.getString("SONG LYRICS AND TEXTS ITEMS")); // NOI18N
        cbLyrics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLyricsActionPerformed(evt);
            }
        });

        cbChordsSimple.setSelected(true);
        cbChordsSimple.setText(bundle.getString("SONGS CHORDS SIMPLE")); // NOI18N

        cbChordsComplete.setSelected(true);
        cbChordsComplete.setText(bundle.getString("SONGS CHORDS COMPLETE")); // NOI18N

        cbOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/dialog-apply.png"))); // NOI18N
        cbOk.setText(bundle.getString("OK")); // NOI18N
        cbOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOkActionPerformed(evt);
            }
        });

        lblFormat.setText(bundle.getString("FORMAT")); // NOI18N

        cbFormat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PDF", "RTF" }));

        cbCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/process-stop.png"))); // NOI18N
        cbCancel.setText(bundle.getString("CANCEL")); // NOI18N
        cbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCancelActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbPrintout);
        rbPrintout.setSelected(true);
        rbPrintout.setText(bundle.getString("PRINTOUTS")); // NOI18N
        rbPrintout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPrintoutActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbSlides);
        rbSlides.setText(bundle.getString("SLIDES")); // NOI18N
        rbSlides.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSlidesActionPerformed(evt);
            }
        });

        cbEmptySlide.setSelected(true);
        cbEmptySlide.setText(bundle.getString("ADD AN EMPTY SLIDE BETWEEN SERVICE ITEMS")); // NOI18N
        cbEmptySlide.setEnabled(false);
        cbEmptySlide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEmptySlideActionPerformed(evt);
            }
        });

        cbGuitarTabs.setSelected(true);
        cbGuitarTabs.setText(bundle.getString("GUITAR TABS")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(cbEmptySlide))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pbProgress, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(cbCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbOk))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbServicePlan)
                            .addComponent(cbLyrics)
                            .addComponent(cbChordsSimple)
                            .addComponent(cbChordsComplete)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFormat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbGuitarTabs)))
                    .addComponent(rbPrintout)
                    .addComponent(lblTitle)
                    .addComponent(rbSlides))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbPrintout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbServicePlan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbLyrics)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbChordsSimple)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbChordsComplete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbGuitarTabs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormat)
                    .addComponent(cbFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbSlides)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEmptySlide)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbOk)
                        .addComponent(cbCancel))
                    .addComponent(pbProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbServicePlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbServicePlanActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cbServicePlanActionPerformed

    private void cbLyricsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLyricsActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cbLyricsActionPerformed

    private void exportSlides(String fileName) throws FileNotFoundException, DocumentException, Exception{

        // Determine width and height. Use from the template for the first item
        ServiceItem item = ServiceListTable.getActiveInstance().getServiceItem(0);
        if (item == null)
            return;

        DisplayTemplate firstTemplate = TemplateManager.getInstance().newDisplayTemplate(item.getTemplate());
        int width = firstTemplate.getWidth();
        int height = firstTemplate.getHeight();


        // Create output
        ServiceListExporterSlides sles = new ServiceListExporterSlides(fileName, width, height);
        try{
            ServiceListTable slt =  ServiceListTable.getActiveInstance();
            ContentRender r = sles.getRender();
            r.paintBackground( BackgroundConfig.getInstance().getBackgroundImg());
            int slideCount = 0;

            /* initial empty slide */
            if (cbEmptySlide.isSelected()){
                sles.addEmptySlide();
                slideCount++;
            }

            pbProgress.setMaximum(slt.getRowCount());
            for (int i=0; i<slt.getRowCount(); i++){
                Object o = slt.getServiceItem(i);
                pbProgress.setValue(i);
                if (o instanceof Song){
                    Song s = (Song) o;
                    r.setTemplate(s.getTemplate());
                    r.setTitle(s.getTitle());
                    r.setSongAuthor(s.getSongAuthor());
                    r.setSongSource(s.getSongSource());
                    r.setCopyright(s.getCopyright());
                    for (int k=0; k<s.getRowCount(); k++){
                        slideCount++;
                        r.setSlide(s.getSlideText(k));
                        if (k < s.getRowCount()-1){
                            r.setNextSlide(s.getSlideText(k+1));
                        }else{
                            r.setNextSlide("");
                        }
                        /* start rendering */
                        r.slideChange(-1);
                        /* wait render thread to render the slide */
                        while (slideCount > sles.getSlideCount()){
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException ex) {
                               // ignore
                            }
                            if (sles.getSlideCount() == -1){
                                throw new DocumentException(java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("INTERNAL ERROR"));
                            }
                        }
                    }
                    /* empty slide after songs */
                    if (cbEmptySlide.isSelected()){
                        sles.addEmptySlide();
                        slideCount++;
                    }

                }else if (o instanceof TextServiceItem){
                    TextServiceItem t = (TextServiceItem) o;
                    r.setTemplate(t.getTemplate());
                    r.setTitle(t.getTitle());
                    for (int k=0; k<t.getRowCount(); k++){
                        slideCount++;
                        r.setSlide(t.getSlideText(k));
                        if (k < t.getRowCount()-1){
                            r.setNextSlide(t.getSlideText(k+1));
                        }else{
                            r.setNextSlide("");
                        }
                        /* start rendering */
                        r.slideChange(-1);
                        /* wait render thread to render the slide */
                        while (slideCount > sles.getSlideCount()){
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException ex) {
                                // ignore
                            }
                            if (sles.getSlideCount() == -1){
                                throw new DocumentException(java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("INTERNAL ERROR"));
                            }
                        }
                    }
                    /* empty slide after text */
                    if (cbEmptySlide.isSelected()){
                        sles.addEmptySlide();
                        slideCount++;
                    }

                }
            }
            pbProgress.setValue(slt.getRowCount());
            sles.write();

        }finally{
            sles.cleanup();
        }

    }

    private void exportPrintout(int type, String fileName) throws DocumentException, FileNotFoundException{
        ServiceListExporterDocument sled = new ServiceListExporterDocument(type, fileName, cbGuitarTabs.isSelected());

        if (singleSong == null){

            if (cbServicePlan.isSelected()){
                sled.addServicePlan();
            }

            ServiceListTable slt =  ServiceListTable.getActiveInstance();
            pbProgress.setMaximum(slt.getRowCount());
            for (int i=0; i<slt.getRowCount(); i++){
                Object o = slt.getServiceItem(i);
                pbProgress.setValue(i);
                if (o instanceof Song){
                    if (cbLyrics.isSelected()){
                        sled.addSongLyrics((Song)o);
                    }
                    if (cbChordsSimple.isSelected()){
                        sled.addSongChordsSimple((Song)o);
                    }
                    if (cbChordsComplete.isSelected()){
                        sled.addSongChordsComplete((Song)o);
                    }
                }else if (o instanceof TextServiceItem){
                    if (cbLyrics.isSelected()){
                        sled.addTextItem((TextServiceItem)o);
                    }
                }
            }
            pbProgress.setValue(slt.getRowCount());

        }else{
            if (cbLyrics.isSelected()){
                sled.addSongLyrics(singleSong);
            }
            if (cbChordsSimple.isSelected()){
                sled.addSongChordsSimple(singleSong);
            }
            if (cbChordsComplete.isSelected()){
                sled.addSongChordsComplete(singleSong);
            }

        }

        if (cbGuitarTabs.isSelected()){
            sled.addGuitarTabs();
        }
        sled.write();

    }

    private void cbOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOkActionPerformed

        String fileName = null;

        // Choose PDF or RTF
        int type =  ServiceListExporterDocument.TYPE_PDF;
        String fileextension = ".pdf";

        if (rbPrintout.isSelected() && cbFormat.getSelectedIndex() == 1){
            type = ServiceListExporterDocument.TYPE_RTF;
            fileextension = ".rtf";
        }

        if (mode == MODE_EXPORT){
            // Ask for file to save
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle(java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("SELECT THE FILE TO SAVE."));
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                fileName = fc.getSelectedFile().getPath();
                if (!fileName.contains(fileextension)) {
                    fileName = fileName + fileextension;
                }
            }

        }else{
            try {
                // Just create a temporary file
                File tmp = File.createTempFile("datasoul-exp-", fileextension);
                tmp.deleteOnExit();
                fileName = tmp.getAbsolutePath();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


        // Process it
        if (fileName != null){

            enablePrintoutControls(false);
            enableSlideControls(false);
            rbPrintout.setEnabled(false);
            rbSlides.setEnabled(false);
            cbCancel.setEnabled(false);
            cbOk.setEnabled(false);

            pbProgress.setVisible(true);
            Thread t = new ProcessThread(type, fileName, rbSlides.isSelected());
            t.start();
        }
            
}//GEN-LAST:event_cbOkActionPerformed

       
    private void cbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCancelActionPerformed
        dispose();
    }//GEN-LAST:event_cbCancelActionPerformed

    private void enablePrintoutControls(boolean b){
        cbChordsComplete.setEnabled(b);
        cbChordsSimple.setEnabled(b);
        cbLyrics.setEnabled(b);
        cbServicePlan.setEnabled(b);
        lblFormat.setEnabled(b);
        cbFormat.setEnabled(b);
        cbGuitarTabs.setEnabled(b);
    }

    private void enableSlideControls(boolean b){
        cbEmptySlide.setEnabled(b);
    }


    private void rbPrintoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPrintoutActionPerformed
        enablePrintoutControls(true);
        enableSlideControls(false);
    }//GEN-LAST:event_rbPrintoutActionPerformed

    private void rbSlidesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSlidesActionPerformed
        enablePrintoutControls(false);
        enableSlideControls(true);
    }//GEN-LAST:event_rbSlidesActionPerformed

    private void cbEmptySlideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEmptySlideActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEmptySlideActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cbCancel;
    private javax.swing.JCheckBox cbChordsComplete;
    private javax.swing.JCheckBox cbChordsSimple;
    private javax.swing.JCheckBox cbEmptySlide;
    private javax.swing.JComboBox cbFormat;
    private javax.swing.JCheckBox cbGuitarTabs;
    private javax.swing.JCheckBox cbLyrics;
    private javax.swing.JButton cbOk;
    private javax.swing.JCheckBox cbServicePlan;
    private javax.swing.JLabel lblFormat;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JProgressBar pbProgress;
    private javax.swing.JRadioButton rbPrintout;
    private javax.swing.JRadioButton rbSlides;
    // End of variables declaration//GEN-END:variables

    private class ProcessThread extends Thread {
        private int type;
        private String fileName;
        private boolean slides;

        public ProcessThread(int type, String fileName, boolean slides){
            this.type = type;
            this.fileName = fileName;
            this.slides = slides;
        }
        public void run(){
            try{
                if (slides){
                    exportSlides(fileName);
                }else{
                    exportPrintout(type, fileName);
                }
                done();
            }catch(Exception e){
                JOptionPane.showMessageDialog(ServiceListExporterPanel.this, java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("ERROR CREATING DOCUMENT: ")+e.getMessage());
                e.printStackTrace();
            }
            (ServiceListExporterPanel.this).dispose();
        }

        public void done(){

            switch (mode){
                case MODE_EXPORT:
                    JOptionPane.showMessageDialog(ServiceListExporterPanel.this, java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("DOCUMENT CREATED SUCCESSFULLY"));
                    try{
                        Desktop.getDesktop().open(new File(fileName));
                        return;
                    }catch (Exception e){
                        // ignore and just show the message
                        e.printStackTrace();
                    }
                    break;

                case MODE_PRINT:
                    try{
                        Desktop.getDesktop().print(new File(fileName));
                        return;
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(ServiceListExporterPanel.this, java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("UNABLE TO PRINT DOCUMENT"));
                        e.printStackTrace();
                    }
                    break;

            }

        }

    }
}


