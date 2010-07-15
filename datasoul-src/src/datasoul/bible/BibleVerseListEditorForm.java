/* 
 * Copyright 2005-2010 Samuel Mello & Eduardo Schnell
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
 * EditTextItem.java
 *
 * Created on 9 de Marco de 2006, 21:04
 */
package datasoul.bible;

import datasoul.serviceitems.text.*;
import datasoul.DatasoulMainForm;
import datasoul.config.DisplayControlConfig;
import datasoul.config.WindowPropConfig;
import datasoul.templates.DisplayTemplate;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.Books;

/**
 *
 * @author  Administrador
 */
public class BibleVerseListEditorForm extends javax.swing.JFrame {

    private boolean updateSize;
    boolean hasChanged = false;

    /** Creates new form EditTextItem */
    public BibleVerseListEditorForm() {
        initComponents();
        DatasoulMainForm.setDatasoulIcon(this);
        WindowPropConfig.getInstance().getTextEditor(this);
        updateSize = true;

        //read value
        this.cbTemplate.setSelectedItem(DisplayControlConfig.getInstance().getDefaultTemplateText());

        btnShowBible.setSelected(true);
        cbTemplate.setTargetContent(DisplayTemplate.TARGET_CONTENT_TEXT);

        textSplitPanel1.setVisible(btnShowSplit.isSelected());

        bibleTextPanel1.configureForVerseListEditorForm();
        bibleTextPanel1.setVisible(true);

        bibleVerseListPanel1.registerBibleTextPanel(bibleTextPanel1);
        Book book = Books.installed().getBook(bibleTextPanel1.getSelectedBookName());
        bibleVerseListPanel1.setBook(book);

        textSplitPanel1.setBtnSplitVisible(false);
        textSplitPanel1.setVisible(true);
        btnShowSplit.setSelected(true);
    }

    public boolean hasChanged() {
        return hasChanged;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textSplitPanel1 = new datasoul.util.TextSplitPanel();
        bibleTextPanel1 = new datasoul.bible.BibleTextPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnSave = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnShowBible = new javax.swing.JToggleButton();
        btnShowSplit = new javax.swing.JToggleButton();
        lblTemplate = new javax.swing.JLabel();
        cbTemplate = new datasoul.templates.TemplateComboBox();
        bibleVerseListPanel1 = new datasoul.bible.BibleVerseListPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("datasoul/internationalize"); // NOI18N
        setTitle(bundle.getString("ADD_VERSE_LIST")); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/document-save_big.png"))); // NOI18N
        btnSave.setToolTipText(bundle.getString("SAVE")); // NOI18N
        btnSave.setBorderPainted(false);
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSave);
        jToolBar1.add(jSeparator1);

        btnShowBible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/accessories-dictionary.png"))); // NOI18N
        btnShowBible.setText(bundle.getString("BIBLE OPTIONS")); // NOI18N
        btnShowBible.setFocusable(false);
        btnShowBible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowBibleActionPerformed(evt);
            }
        });
        jToolBar1.add(btnShowBible);

        btnShowSplit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/datasoul/icons/v2/format-justify-center.png"))); // NOI18N
        btnShowSplit.setText(bundle.getString("SPLIT OPTIONS")); // NOI18N
        btnShowSplit.setFocusable(false);
        btnShowSplit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowSplitActionPerformed(evt);
            }
        });
        jToolBar1.add(btnShowSplit);

        lblTemplate.setText(bundle.getString("TEMPLATE:")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bibleVerseListPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                            .addComponent(bibleTextPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTemplate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(textSplitPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bibleTextPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textSplitPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTemplate)
                    .addComponent(cbTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bibleVerseListPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean save() {
        bibleVerseListPanel1.createTextServiceItems(textSplitPanel1);
        return true;
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        save();
        dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnShowSplitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowSplitActionPerformed
        textSplitPanel1.setVisible(btnShowSplit.isSelected());
    }//GEN-LAST:event_btnShowSplitActionPerformed

    private void btnShowBibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowBibleActionPerformed
        bibleTextPanel1.setVisible(btnShowBible.isSelected());
        if (updateSize) {
            WindowPropConfig.getInstance().setShowBibleControlsBool(btnShowBible.isSelected());
        }
    }//GEN-LAST:event_btnShowBibleActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        bibleTextPanel1.onClose();
    }//GEN-LAST:event_formWindowClosed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        if (updateSize) {
            WindowPropConfig.getInstance().setTextEditor(this);
        }
    }//GEN-LAST:event_formComponentResized

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        if (hasChanged()) {
            int resp = JOptionPane.showConfirmDialog(this, java.util.ResourceBundle.getBundle("datasoul/internationalize").getString("SAVE THE CHANGES?"), "Datasoul", JOptionPane.YES_NO_CANCEL_OPTION);

            if (resp == JOptionPane.YES_OPTION) {
                if (save()) {
                    this.dispose();
                }
            } else if (resp == JOptionPane.NO_OPTION) {
                this.dispose();
            }
        } else {
            this.dispose();
        }

    }//GEN-LAST:event_formWindowClosing
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datasoul.bible.BibleTextPanel bibleTextPanel1;
    private datasoul.bible.BibleVerseListPanel bibleVerseListPanel1;
    private javax.swing.JButton btnSave;
    private javax.swing.JToggleButton btnShowBible;
    private javax.swing.JToggleButton btnShowSplit;
    private datasoul.templates.TemplateComboBox cbTemplate;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblTemplate;
    private datasoul.util.TextSplitPanel textSplitPanel1;
    // End of variables declaration//GEN-END:variables

    public void highlightlyric(JTextComponent textComp) {
        removeHighlights(textComp);
        highlight(textComp, "\n" + TextServiceItem.SLIDE_BREAK + "\n", Color.ORANGE);
        highlight(textComp, "\n" + TextServiceItem.CHORUS_MARK + "\n", Color.PINK);
    }
    // Creates highlights around all occurrences of pattern in textComp

    public void highlight(JTextComponent textComp, String pattern, Color color) {
        Highlighter.HighlightPainter highlightPainter = new MyHighlightPainter(color);

        try {
            Highlighter hilite = textComp.getHighlighter();
            javax.swing.text.Document doc = textComp.getDocument();
            String text = doc.getText(0, doc.getLength());
            int pos = 0;

            // Search for pattern
            while ((pos = text.indexOf(pattern, pos)) >= 0) {
                // Create highlighter using private painter and apply around pattern
                hilite.addHighlight(pos, pos + pattern.length(), highlightPainter);
                pos += pattern.length();
            }
        } catch (BadLocationException e) {
        }
    }

    // Removes only our private highlights
    public void removeHighlights(JTextComponent textComp) {
        Highlighter hilite = textComp.getHighlighter();
        hilite.removeAllHighlights();
    }

    // A private subclass of the default highlight painter
    class MyHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter {

        public MyHighlightPainter(Color color) {
            super(color);
        }
    }
}

