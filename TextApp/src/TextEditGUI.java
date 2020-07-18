package textapp;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.TextComponent;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;


public class TextEditGUI extends javax.swing.JFrame {

    String FileName;
    Clipboard clipBoard = getToolkit().getSystemClipboard();
    
    public TextEditGUI() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SeachButton = new javax.swing.JButton();
        Search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        NewFile = new javax.swing.JMenuItem();
        OpenFile = new javax.swing.JMenuItem();
        SaveFile = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        CutText = new javax.swing.JMenuItem();
        CopyText = new javax.swing.JMenuItem();
        PasteText = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SeachButton.setText("Search");
        SeachButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeachButtonActionPerformed(evt);
            }
        });

        TextArea.setColumns(20);
        TextArea.setRows(5);
        jScrollPane1.setViewportView(TextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeachButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SeachButton)
                    .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("File");

        NewFile.setText("New");
        NewFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewFileActionPerformed(evt);
            }
        });
        jMenu1.add(NewFile);

        OpenFile.setText("Open");
        OpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileActionPerformed(evt);
            }
        });
        jMenu1.add(OpenFile);

        SaveFile.setText("Save");
        SaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveFileActionPerformed(evt);
            }
        });
        jMenu1.add(SaveFile);

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jMenu1.add(Exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        CutText.setText("Cut");
        CutText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CutTextActionPerformed(evt);
            }
        });
        jMenu2.add(CutText);

        CopyText.setText("Copy");
        CopyText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopyTextActionPerformed(evt);
            }
        });
        jMenu2.add(CopyText);

        PasteText.setText("Paste");
        PasteText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasteTextActionPerformed(evt);
            }
        });
        jMenu2.add(PasteText);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewFileActionPerformed
        
        TextArea.setText("");
        setTitle(FileName);
    }//GEN-LAST:event_NewFileActionPerformed

    private void SaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveFileActionPerformed
       FileDialog fileDialog = new FileDialog(TextEditGUI.this, "Save File" , FileDialog.SAVE);
       fileDialog.setVisible(true);
       
       if(fileDialog.getFile()!= null){
       
       FileName= fileDialog.getDirectory() + fileDialog.getFile();
           setTitle(FileName);
           
           try {
               FileWriter fileWriter = new FileWriter(FileName);
               fileWriter.write(TextArea.getText());
               setTitle(FileName);
               fileWriter.close();
           } catch (IOException e) {
               
               System.out.println("File Not found");
           }
       }
    }//GEN-LAST:event_SaveFileActionPerformed

    private void OpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileActionPerformed
        FileDialog fileDialog = new FileDialog(TextEditGUI.this , "Open File" , FileDialog.LOAD);
        fileDialog.setVisible(true);
        
        if(fileDialog.getFile() != null){
        
        FileName= fileDialog.getDirectory() + fileDialog.getFile();
            setTitle(FileName);
        }
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FileName));
            StringBuilder sb = new StringBuilder();
            
            String line = null;
            
            while ((line = reader.readLine()) != null){
            
            sb.append(line + "\n");
            TextArea.setText(sb.toString());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }//GEN-LAST:event_OpenFileActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void CutTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutTextActionPerformed
        String CutString = TextArea.getSelectedText();
        StringSelection CutSelection = new StringSelection(CutString);
        clipBoard.setContents(CutSelection, CutSelection);
        TextArea.replaceRange("", TextArea.getSelectionStart(), TextArea.getSelectionEnd());
    }//GEN-LAST:event_CutTextActionPerformed

    private void CopyTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyTextActionPerformed
        String CopyText = TextArea.getSelectedText();
        StringSelection CopySelection= new StringSelection(CopyText);
        clipBoard.setContents(CopySelection, CopySelection);
    }//GEN-LAST:event_CopyTextActionPerformed

    private void PasteTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasteTextActionPerformed
        try {
            Transferable pasteText= clipBoard.getContents(TextEditGUI.this);
            String selc = (String) pasteText.getTransferData(DataFlavor.stringFlavor);
            TextArea.replaceRange(selc, TextArea.getSelectionStart(), TextArea.getSelectionEnd());
        } 
        
        catch (Exception e) {
            System.out.println("It Did Not Work");
        }
    }//GEN-LAST:event_PasteTextActionPerformed

    private void SeachButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeachButtonActionPerformed
        SeacrchTextArea(TextArea, Search.getText());
    }//GEN-LAST:event_SeachButtonActionPerformed

   class HighLighter extends DefaultHighlighter.DefaultHighlightPainter{
   
   public HighLighter(Color color){
       super(color);
   }
   
   }
   
   DefaultHighlighter.HighlightPainter highlighter = new HighLighter(Color.yellow);
   
  
   public void removeHighlight(JTextComponent textComponent){

    Highlighter RemoveH= textComponent.getHighlighter();
    Highlighter.Highlight[] remove = RemoveH.getHighlights();
    
    for( int i =0;i < remove.length; i++ ){
        
        if(remove[i].getPainter() instanceof HighLighter ){
        
        RemoveH.removeHighlight(remove[i]);
      
    }
    }

}
   
   public void SeacrchTextArea(JTextComponent textComponent, String textSting){
       
       removeHighlight(textComponent);
       try {
           Highlighter hilight = textComponent.getHighlighter();
           Document doc = textComponent.getDocument();
           String text = doc.getText(0, doc.getLength());
           
           int position = 0;
           
           while ((position= text.toUpperCase().indexOf(textSting.toUpperCase(), position )) >= 0) {
           
           hilight.addHighlight(position,position+ textSting.length(), highlighter);
           position += textSting.length();
           }
       } catch (Exception e) {
       }
   
   }
  
   
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
            java.util.logging.Logger.getLogger(TextEditGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextEditGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextEditGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextEditGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextEditGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CopyText;
    private javax.swing.JMenuItem CutText;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem NewFile;
    private javax.swing.JMenuItem OpenFile;
    private javax.swing.JMenuItem PasteText;
    private javax.swing.JMenuItem SaveFile;
    private javax.swing.JButton SeachButton;
    private javax.swing.JTextField Search;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
