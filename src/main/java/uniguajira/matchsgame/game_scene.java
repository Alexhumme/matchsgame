/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uniguajira.matchsgame;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;

/**
 *
 * @author AlexVB
 */

class MiniCard extends JButton {
    public String id;
    public boolean revealed = false;
    public MiniCard(String id){
        this.id = id;
        this.setText(id);
    }
    public void reveal(){
        revealed = true;
         Color color = Color.BLACK;
        if (id.equals("1")) color = Color.BLUE;
        if (id.equals("2")) color = Color.CYAN;
        if (id.equals("3")) color = Color.DARK_GRAY;
        if (id.equals("4")) color = Color.GREEN;
        if (id.equals("5")) color = Color.LIGHT_GRAY;
        if (id.equals("6")) color = Color.magenta;
        if (id.equals("7")) color = Color.RED;
        if (id.equals("8")) color = Color.pink;

        this.setBackground(color);
    }
    public void unreveal(){
        revealed = false;
        this.setBackground(Color.white);
    }
    public static void main(String[] args) {
        
    }
}

public final class game_scene extends javax.swing.JFrame {

    /**
     * Creates new form game_scene
     */
    public game_scene() {
        initComponents();
        generate_grid();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        game_container = new javax.swing.JPanel();
        up_bar_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pause_button = new javax.swing.JButton();
        bottom_row = new javax.swing.JPanel();
        game_grid_panel = new javax.swing.JPanel();
        timer_panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));
        jPanel1.setLayout(new javax.swing.OverlayLayout(jPanel1));

        up_bar_panel.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Barra de juego");

        pause_button.setText("p");
        pause_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pause_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout up_bar_panelLayout = new javax.swing.GroupLayout(up_bar_panel);
        up_bar_panel.setLayout(up_bar_panelLayout);
        up_bar_panelLayout.setHorizontalGroup(
            up_bar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(up_bar_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pause_button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        up_bar_panelLayout.setVerticalGroup(
            up_bar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(up_bar_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(up_bar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(up_bar_panelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(pause_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        game_grid_panel.setBackground(new java.awt.Color(204, 204, 204));
        game_grid_panel.setMinimumSize(new java.awt.Dimension(300, 300));
        game_grid_panel.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout game_grid_panelLayout = new javax.swing.GroupLayout(game_grid_panel);
        game_grid_panel.setLayout(game_grid_panelLayout);
        game_grid_panelLayout.setHorizontalGroup(
            game_grid_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        game_grid_panelLayout.setVerticalGroup(
            game_grid_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        timer_panel.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout timer_panelLayout = new javax.swing.GroupLayout(timer_panel);
        timer_panel.setLayout(timer_panelLayout);
        timer_panelLayout.setHorizontalGroup(
            timer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );
        timer_panelLayout.setVerticalGroup(
            timer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bottom_rowLayout = new javax.swing.GroupLayout(bottom_row);
        bottom_row.setLayout(bottom_rowLayout);
        bottom_rowLayout.setHorizontalGroup(
            bottom_rowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottom_rowLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(game_grid_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timer_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        bottom_rowLayout.setVerticalGroup(
            bottom_rowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(timer_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(game_grid_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout game_containerLayout = new javax.swing.GroupLayout(game_container);
        game_container.setLayout(game_containerLayout);
        game_containerLayout.setHorizontalGroup(
            game_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottom_row, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(up_bar_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        game_containerLayout.setVerticalGroup(
            game_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, game_containerLayout.createSequentialGroup()
                .addComponent(up_bar_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottom_row, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(game_container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(game_container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pause_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pause_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pause_buttonActionPerformed

    /**
     * @param args the command line arguments
     */

    
    static void shuffleArray(String[] ar)
    {
      Random rnd = new Random();
      for (int i = ar.length - 1; i > 0; i--)
      {
        int index = rnd.nextInt(i + 1);
        String a = ar[index];
        ar[index] = ar[i];
        ar[i] = a;
      }
    }
    
    public int size = 6;
    public MiniCard[] cards = new MiniCard[size*size];
    
    public String[] generateIds(){
        
        String[] ids = new String[size*size];
        int counter = 0;
        
        while (counter < size*size) {            
            for (int i = 0; i < 8; i++) {
                if (i*2+counter < size*size-1){
                    ids[i*2+counter] = ""+(i+1);
                    ids[i*2+counter+1] = ""+(i+1);
                }
            }
            counter += 16;
        }
        
        shuffleArray(ids);
        
        System.out.println(Arrays.toString(ids));
        return ids;
    }
    
    public void generate_grid() {
        game_grid_panel.setLayout(new GridLayout(size, size));
        game_grid_panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        String[] ids = generateIds();
        System.out.println("Hola este es un test");
        
        for (int i = 0; i < size*size; i++) {
            cards[i] = new MiniCard(ids[i]);
            game_grid_panel.add(cards[i]);
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
            java.util.logging.Logger.getLogger(game_scene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(game_scene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(game_scene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(game_scene.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new game_scene().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottom_row;
    private javax.swing.JPanel game_container;
    private javax.swing.JPanel game_grid_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton pause_button;
    private javax.swing.JPanel timer_panel;
    private javax.swing.JPanel up_bar_panel;
    // End of variables declaration//GEN-END:variables
}
