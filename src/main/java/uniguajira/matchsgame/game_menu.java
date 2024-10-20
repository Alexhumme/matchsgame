/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uniguajira.matchsgame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
 /*
 * @author MARIA JOSE
 */
public class game_menu extends javax.swing.JFrame {
    public game_menu() {
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

        jProgressBar1 = new javax.swing.JProgressBar();
        Jpanel = new javax.swing.JPanel();
        jpanel1 = new javax.swing.JPanel();
        tema_panel = new javax.swing.JPanel();
        Tp_carta = new javax.swing.JLabel();
        trj_temas = new javax.swing.JComboBox<>();
        btn_aplicar = new javax.swing.JButton();
        tamaño_panel = new javax.swing.JPanel();
        Tm_matriz = new javax.swing.JLabel();
        tamañocmb = new javax.swing.JComboBox<>();
        btn_aplicartmñ = new javax.swing.JButton();
        tiempo_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tiempo = new javax.swing.JToggleButton();
        Play = new javax.swing.JButton();
        fondo_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(153, 153, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        Jpanel.setBackground(new java.awt.Color(255, 255, 255));
        Jpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpanel1.setBackground(new java.awt.Color(255, 255, 255));
        jpanel1.setOpaque(false);

        tema_panel.setMaximumSize(new java.awt.Dimension(104, 82));
        tema_panel.setMinimumSize(new java.awt.Dimension(104, 82));
        tema_panel.setName(""); // NOI18N
        tema_panel.setOpaque(false);
        tema_panel.setPreferredSize(new java.awt.Dimension(104, 82));

        Tp_carta.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        Tp_carta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tp_carta.setText("Tipo Carta");

        trj_temas.setBackground(new java.awt.Color(0, 204, 204));
        trj_temas.setEditable(true);
        trj_temas.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        trj_temas.setForeground(new java.awt.Color(255, 255, 255));
        trj_temas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Animales", "Frutas", "Plantas" }));
        trj_temas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), new java.awt.Color(0, 255, 204), new java.awt.Color(204, 255, 255), new java.awt.Color(102, 255, 204)));
        trj_temas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trj_temasActionPerformed(evt);
            }
        });

        btn_aplicar.setBackground(new java.awt.Color(255, 255, 204));
        btn_aplicar.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        btn_aplicar.setText("Aplicar");
        btn_aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aplicarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tema_panelLayout = new javax.swing.GroupLayout(tema_panel);
        tema_panel.setLayout(tema_panelLayout);
        tema_panelLayout.setHorizontalGroup(
            tema_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tema_panelLayout.createSequentialGroup()
                .addComponent(btn_aplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tema_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(tema_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Tp_carta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trj_temas, 0, 104, Short.MAX_VALUE))
                .addContainerGap())
        );
        tema_panelLayout.setVerticalGroup(
            tema_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tema_panelLayout.createSequentialGroup()
                .addComponent(Tp_carta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trj_temas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_aplicar)
                .addGap(0, 0, 0))
        );

        tamaño_panel.setMaximumSize(new java.awt.Dimension(104, 82));
        tamaño_panel.setMinimumSize(new java.awt.Dimension(104, 82));
        tamaño_panel.setOpaque(false);

        Tm_matriz.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        Tm_matriz.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Tm_matriz.setText("Tamaño: 4");

        tamañocmb.setBackground(new java.awt.Color(0, 204, 204));
        tamañocmb.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        tamañocmb.setForeground(new java.awt.Color(255, 255, 255));
        tamañocmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4X4", "6X6", "8X8" }));
        tamañocmb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 255, 204), new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(0, 153, 153)));
        tamañocmb.setMinimumSize(new java.awt.Dimension(72, 27));
        tamañocmb.setPreferredSize(new java.awt.Dimension(72, 27));
        tamañocmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamañocmbActionPerformed(evt);
            }
        });

        btn_aplicartmñ.setBackground(new java.awt.Color(255, 255, 204));
        btn_aplicartmñ.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        btn_aplicartmñ.setText("Aplicar");
        btn_aplicartmñ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aplicartmñActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tamaño_panelLayout = new javax.swing.GroupLayout(tamaño_panel);
        tamaño_panel.setLayout(tamaño_panelLayout);
        tamaño_panelLayout.setHorizontalGroup(
            tamaño_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tamañocmb, 0, 104, Short.MAX_VALUE)
            .addComponent(btn_aplicartmñ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Tm_matriz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tamaño_panelLayout.setVerticalGroup(
            tamaño_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tamaño_panelLayout.createSequentialGroup()
                .addComponent(Tm_matriz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tamañocmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btn_aplicartmñ)
                .addGap(0, 0, 0))
        );

        tiempo_panel.setMaximumSize(new java.awt.Dimension(104, 82));
        tiempo_panel.setMinimumSize(new java.awt.Dimension(104, 82));
        tiempo_panel.setOpaque(false);
        tiempo_panel.setPreferredSize(new java.awt.Dimension(104, 82));

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tiempo");

        tiempo.setBackground(new java.awt.Color(0, 204, 204));
        tiempo.setFont(new java.awt.Font("OCR A Extended", 1, 14)); // NOI18N
        tiempo.setForeground(new java.awt.Color(255, 255, 255));
        tiempo.setText("Sin tiempo");
        tiempo.setToolTipText("");
        tiempo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 204), new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(102, 255, 204)));
        tiempo.setMaximumSize(new java.awt.Dimension(87, 27));
        tiempo.setMinimumSize(new java.awt.Dimension(87, 27));
        tiempo.setPreferredSize(new java.awt.Dimension(87, 27));
        tiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiempoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tiempo_panelLayout = new javax.swing.GroupLayout(tiempo_panel);
        tiempo_panel.setLayout(tiempo_panelLayout);
        tiempo_panelLayout.setHorizontalGroup(
            tiempo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tiempo, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tiempo_panelLayout.setVerticalGroup(
            tiempo_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tiempo_panelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        Play.setBackground(new java.awt.Color(255, 51, 51));
        Play.setFont(new java.awt.Font("Showcard Gothic", 1, 14)); // NOI18N
        Play.setForeground(new java.awt.Color(255, 255, 255));
        Play.setText("JUGAR");
        Play.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 0, 51), new java.awt.Color(255, 0, 51), new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 204)));
        Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanel1Layout = new javax.swing.GroupLayout(jpanel1);
        jpanel1.setLayout(jpanel1Layout);
        jpanel1Layout.setHorizontalGroup(
            jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(tema_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Play, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tamaño_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(tiempo_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jpanel1Layout.setVerticalGroup(
            jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tiempo_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tema_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(tamaño_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(Play, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        Jpanel.add(jpanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        fondo_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/interface/Mapa Mental Ahorro de Energía Moderno Verde.png"))); // NOI18N
        fondo_label.setText("jLabel2");
        fondo_label.setOpaque(true);
        Jpanel.add(fondo_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 390));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tamañocmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamañocmbActionPerformed
    }//GEN-LAST:event_tamañocmbActionPerformed

    private void PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayActionPerformed
        game_scene juego = new game_scene(tema, tamaño, tiempo1);
        juego.setVisible(true);
    }//GEN-LAST:event_PlayActionPerformed

    private void trj_temasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trj_temasActionPerformed

    }//GEN-LAST:event_trj_temasActionPerformed
       
   
    
    private boolean tiempo1 = true;
    private void tiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiempoActionPerformed
        if (tiempo.isSelected()) {
            tiempo1 = true;
            tiempo.setText("Con tiempo");

        } else {
            tiempo.setText("sin tiempo");
            tiempo1 = false;
        }
    }//GEN-LAST:event_tiempoActionPerformed
    private String tema = "Animales";
    private void btn_aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aplicarActionPerformed
        btn_aplicar.setText("Aplicado");
        tema = trj_temas.getSelectedItem().toString();
    }//GEN-LAST:event_btn_aplicarActionPerformed
    private int tamaño = 4;
    private void btn_aplicartmñActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aplicartmñActionPerformed
        btn_aplicartmñ.setText("Aplicado");
        if (tamañocmb.getSelectedItem().equals("4X4")) {
            tamaño = 4;
        }
        if (tamañocmb.getSelectedItem().equals("6X6")) {
            tamaño = 6;
        }
        if (tamañocmb.getSelectedItem().equals("8X8")) {
            tamaño = 8;
        }
        Tm_matriz.setText("Tamaño: " + tamaño);
    }//GEN-LAST:event_btn_aplicartmñActionPerformed
   
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(game_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(game_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(game_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(game_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new game_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel;
    private javax.swing.JButton Play;
    private javax.swing.JLabel Tm_matriz;
    private javax.swing.JLabel Tp_carta;
    private javax.swing.JButton btn_aplicar;
    private javax.swing.JButton btn_aplicartmñ;
    private javax.swing.JLabel fondo_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JPanel jpanel1;
    private javax.swing.JPanel tamaño_panel;
    private javax.swing.JComboBox<String> tamañocmb;
    private javax.swing.JPanel tema_panel;
    private javax.swing.JToggleButton tiempo;
    private javax.swing.JPanel tiempo_panel;
    private javax.swing.JComboBox<String> trj_temas;
    // End of variables declaration//GEN-END:variables
}
