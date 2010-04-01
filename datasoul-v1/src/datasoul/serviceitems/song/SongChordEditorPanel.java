/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SongChordEditorPanel.java
 *
 * Created on Mar 27, 2010, 1:02:27 AM
 */

package datasoul.serviceitems.song;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author samuel
 */
public class SongChordEditorPanel extends javax.swing.JPanel {

    /** Creates new form SongChordEditorPanel */
    public SongChordEditorPanel() {
        initComponents();
        textChords.setChords(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTabs = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        pnlGridTabs = new javax.swing.JPanel();
        pnlTabsNotFound = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblNotFound = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRefreshTabs = new javax.swing.JButton();
        btnTabsCatalog = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        textChords = new datasoul.util.HighlightTextArea();
        transposeToolbar = new javax.swing.JToolBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        pnlTabs.setPreferredSize(new java.awt.Dimension(100, 221));
        pnlTabs.setLayout(new java.awt.BorderLayout());

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlGridTabs.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane4.setViewportView(pnlGridTabs);

        pnlTabs.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        pnlTabsNotFound.setLayout(new java.awt.GridLayout(2, 1));

        jLabel2.setText("Not Found:");
        pnlTabsNotFound.add(jLabel2);

        lblNotFound.setText("jLabel3");
        pnlTabsNotFound.add(lblNotFound);

        pnlTabs.add(pnlTabsNotFound, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());

        btnRefreshTabs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/view-refresh.png"))); // NOI18N
        btnRefreshTabs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshTabsActionPerformed(evt);
            }
        });
        jPanel2.add(btnRefreshTabs, java.awt.BorderLayout.LINE_START);

        btnTabsCatalog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/gtk-edit.png"))); // NOI18N
        btnTabsCatalog.setText("Edit");
        btnTabsCatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTabsCatalogActionPerformed(evt);
            }
        });
        jPanel2.add(btnTabsCatalog, java.awt.BorderLayout.CENTER);

        pnlTabs.add(jPanel2, java.awt.BorderLayout.NORTH);

        add(pnlTabs, java.awt.BorderLayout.EAST);

        textChords.setColumns(20);
        textChords.setRows(5);
        textChords.setFont(new java.awt.Font("Courier New", 0, 13));
        jScrollPane3.setViewportView(textChords);

        add(jScrollPane3, java.awt.BorderLayout.CENTER);

        transposeToolbar.setFloatable(false);
        transposeToolbar.setRollover(true);

        jLabel3.setText("  ");
        transposeToolbar.add(jLabel3);

        jLabel1.setText("Transpose using");
        transposeToolbar.add(jLabel1);

        jLabel4.setText("  ");
        transposeToolbar.add(jLabel4);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "#", "b" }));
        transposeToolbar.add(jComboBox1);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/view-sort-ascending.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        transposeToolbar.add(jButton3);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/view-sort-descending.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        transposeToolbar.add(jButton2);

        add(transposeToolbar, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshTabsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshTabsActionPerformed
        updateTabs();
}//GEN-LAST:event_btnRefreshTabsActionPerformed

    private void btnTabsCatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabsCatalogActionPerformed
        ChordsManagerFrame cmf = new ChordsManagerFrame();
        cmf.setLocationRelativeTo(this);
        cmf.setVisible(true);
    }//GEN-LAST:event_btnTabsCatalogActionPerformed


    public void init(){
        textChords.setCaretPosition(0);
    }

    public void setText(String s){
        textChords.setText(s);
    }

    public String getText(){
        return textChords.getText();
    }

    public void setTransposeVisible(boolean b){
        transposeToolbar.setVisible(b);
    }

    public void setTabsVisible(boolean b){
        pnlTabs.setVisible(b);
        if (b){
            updateTabs();
        }
    }

    private void updateTabs(){

        /* clean up */
        pnlGridTabs.removeAll();

        /* get used chords */
        ArrayList<String> usedChords = Song.getUsedChords(textChords.getText());

        /* Process it */
        ArrayList<String> notFound = new ArrayList<String>();
        ChordsDB chordsDB = ChordsDB.getInstance();
        for(String chordStr : usedChords){
            Chord chord = chordsDB.getChordByName(chordStr);
            if(chord!=null){
                ChordShapePanel csp = new ChordShapePanel(2, chord.getName(),chord.getShape());
                csp.setEditable(false);
                pnlGridTabs.add(csp);
            }else{
                if (!notFound.contains(chordStr)){
                    notFound.add(chordStr);
                }
            }
        }

        pnlTabsNotFound.setVisible(notFound.size() > 0);
        StringBuffer sb = new StringBuffer();
        for (String nf : notFound){
            sb.append(nf);
            sb.append(" ");
        }
        lblNotFound.setText(sb.toString());

        pnlGridTabs.revalidate();

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefreshTabs;
    private javax.swing.JButton btnTabsCatalog;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblNotFound;
    private javax.swing.JPanel pnlGridTabs;
    private javax.swing.JPanel pnlTabs;
    private javax.swing.JPanel pnlTabsNotFound;
    private datasoul.util.HighlightTextArea textChords;
    private javax.swing.JToolBar transposeToolbar;
    // End of variables declaration//GEN-END:variables

}
