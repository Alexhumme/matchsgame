/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uniguajira.matchsgame;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 *
 * @author AlexVB
 */
// las tarjetitas tienen que ser su propia clase aparte para controlar sus estados
class MiniCard extends JButton {

    // el id es el que se compara para saber si son iguales
    public String id;
    public String theme;
    public boolean revealed = false;
    public boolean paired = false;
    public ImageIcon icon;

    // este color es un gris azulado para cuando esten ocultas
    Color bgColor = new java.awt.Color(204, 204, 205);

   
    public MiniCard(String id, String theme) {
        // poner el id, color de fondo, fuente pixelada, y el borde
        this.id = id;
        this.setBackground(bgColor);
        this.setFont(new java.awt.Font("PF Tempesta Five Condensed", 0, 24));
        this.setBorder( // este codigo le coloca el borde, no encontre como ponerlo mas simple
                javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(Color.BLACK, 2),
                        javax.swing.BorderFactory.createBevelBorder(
                                javax.swing.border.BevelBorder.RAISED, null, null, null, Color.white)
                ));
        this.icon = new javax.swing.ImageIcon(getClass().getResource("/Images/"+theme+"/"+id+".png"));
    }

    public void reveal() { 
        // cuando se revele cambia su color de fondo y mustra su id
        revealed = true;
        Color color = Color.BLACK;
        if (id.equals("1")) {
            color = Color.BLUE;
        }
        if (id.equals("2")) {
            color = Color.CYAN;
        }
        if (id.equals("3")) {
            color = Color.YELLOW;
        }
        if (id.equals("4")) {
            color = Color.GREEN;
        }
        if (id.equals("5")) {
            color = Color.ORANGE;
        }
        if (id.equals("6")) {
            color = Color.MAGENTA;
        }
        if (id.equals("7")) {
            color = Color.RED;
        }
        if (id.equals("8")) {
            color = Color.PINK;
        }

        this.setBackground(color);
        this.setIcon(icon);
    }

    public void unreveal() {
        // cuando se oculte, solo si no ha sido emparejada
        // cambia el fondo y quita el texto
        if (!this.paired) {
            revealed = false;
            this.setBackground(bgColor);
            this.setText("");
            this.setIcon(null);
        }
    }

    public void match() {
        // cuando encuentre su match
        paired = true;
        // cambia su color de borde
        this.setBorderPainted(true);

        this.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(Color.BLACK, 2),
                javax.swing.BorderFactory.createBevelBorder(
                        javax.swing.border.BevelBorder.RAISED, null, null, null, Color.GREEN)));

        // y desactiva el la tarjeta
        this.setEnabled(false);
    }

    public void unmatch() {
        // cuando la pareja no sea correcta ponle borde rojo
        this.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(Color.BLACK, 2),
                javax.swing.BorderFactory.createBevelBorder(
                        javax.swing.border.BevelBorder.RAISED, null, null, null, Color.RED)));

        // y despues de medio segundo (con un temporizador) ocultala
        Timer timer = new Timer(500, e -> {
            this.paired = false;

            this.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                    javax.swing.BorderFactory.createLineBorder(Color.BLACK, 2),
                    javax.swing.BorderFactory.createBevelBorder(
                            javax.swing.border.BevelBorder.RAISED, null, null, null, Color.WHITE)));

            this.unreveal();
        });
        timer.setRepeats(false);  // No queremos que el temporizador se repita
        timer.start();

    }

    public static void main(String[] args) {

    }
}

public final class game_scene extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form game_scene
     */
    public boolean win;
    public boolean pause;
    public boolean points;
    public int time;

    public int size;
    public String theme;
    public boolean use_timer;

    public MiniCard[] pair = new MiniCard[2];
    public MiniCard[] cards;
    
    public game_scene(String theme, int size, boolean timer) {
        // recibir los valores que le mande el menu
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.theme = theme;
        this.size = size;
        this.use_timer = timer;
        initComponents();

        start_game();
    }

    public game_scene() {
        // valores por defecto
        this.theme = "Animales";
        this.size = 4;
        this.use_timer = false;
        initComponents();
        start_game();
    }

    // como de de estar el juego cada vez que empiece una partida
    public void start_game() { 
        state_panel.setBackground(new java.awt.Color(204, 204, 255));
        state_label.setForeground(Color.BLACK);
        state_label.setText("empareja lo/as "+theme);
        this.win = true;
        this.pause = false;
        this.cards = null;
        this.cards = new MiniCard[size * size];
        this.pair = null;
        this.pair = new MiniCard[2]; // aqui se guardan las que estan visibles y no han sido completadas
        this.time = 120;
        generate_grid(); // genera la cuadricula
        if (use_timer) {
            this.start_timer();
        }
    }

    // lo que debe hacer el temporizador
    public void timer_event() {
        // cambiar colores si queda poco tiempo
        if (time == 60) {
            time_lable.setForeground(Color.yellow);
        }
        if (time == 30) {
            time_lable.setForeground(Color.red);
        }
        // actualizar barra de progreso
        timer_progressbar.setValue(time);
        // actualizar cronometro (el texto se formatea para que paresca una hora
        time_lable.setText(
                String.format("%02d", (int) (time / 60)) + ":"
                + String.format("%02d", (time - 60 * (int) (time / 60)))
        );
        // lo que hacer si se acaba el tiempo
        if (time <= 0) {
            // desactiva todas las tarjetas
            for (MiniCard card : cards) {
                card.setEnabled(false);
            }
            // muestra el mensaje de perdiste
            state_label.setForeground(Color.WHITE);
            state_panel.setBackground(Color.red);
            state_label.setText("Perdiste");
            // deten el temporizador
            timer.stop();
        }
        // reduce el tiempo
        time--;
    }
    
    // el temporizador ejecuta l funcion de arriba cada segundo (1000 milisegundos)
    public Timer timer = new Timer(1000, e -> timer_event());

    // iniciar a contar los seggundos
    public void start_timer() {
        time_lable.setText("__:__");
        time_lable.setForeground(Color.green);
        timer.setRepeats(true);
        timer.start();
        
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
        state_panel = new javax.swing.JPanel();
        state_label = new javax.swing.JLabel();
        bottom_row = new javax.swing.JPanel();
        game_grid_panel = new javax.swing.JPanel();
        timer_panel = new javax.swing.JPanel();
        pause_button = new javax.swing.JButton();
        reset_button = new javax.swing.JButton();
        exit_button = new javax.swing.JButton();
        time_lable = new javax.swing.JLabel();
        timer_progressbar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new javax.swing.OverlayLayout(jPanel1));

        game_container.setBackground(new java.awt.Color(62, 60, 79));
        game_container.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2)));

        state_panel.setBackground(new java.awt.Color(204, 204, 255));
        state_panel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2)));

        state_label.setFont(new java.awt.Font("PF Tempesta Five Condensed", 0, 24)); // NOI18N
        state_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        state_label.setText("encuentra las parejas");

        javax.swing.GroupLayout state_panelLayout = new javax.swing.GroupLayout(state_panel);
        state_panel.setLayout(state_panelLayout);
        state_panelLayout.setHorizontalGroup(
            state_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(state_panelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(state_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );
        state_panelLayout.setVerticalGroup(
            state_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(state_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(state_label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bottom_row.setOpaque(false);

        game_grid_panel.setBackground(new java.awt.Color(204, 204, 204));
        game_grid_panel.setMinimumSize(new java.awt.Dimension(300, 300));
        game_grid_panel.setOpaque(false);
        game_grid_panel.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout game_grid_panelLayout = new javax.swing.GroupLayout(game_grid_panel);
        game_grid_panel.setLayout(game_grid_panelLayout);
        game_grid_panelLayout.setHorizontalGroup(
            game_grid_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        game_grid_panelLayout.setVerticalGroup(
            game_grid_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        timer_panel.setBackground(new java.awt.Color(204, 204, 255));
        timer_panel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2)));

        pause_button.setBackground(new java.awt.Color(54, 159, 215));
        pause_button.setFont(new java.awt.Font("PF Tempesta Five Condensed", 0, 14)); // NOI18N
        pause_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/interface/pause_icon.png"))); // NOI18N
        pause_button.setToolTipText("");
        pause_button.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        pause_button.setOpaque(true);
        pause_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pause_buttonActionPerformed(evt);
            }
        });

        reset_button.setBackground(new java.awt.Color(87, 171, 104));
        reset_button.setFont(new java.awt.Font("PF Tempesta Five Condensed", 0, 14)); // NOI18N
        reset_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/interface/reset_icon.png"))); // NOI18N
        reset_button.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        reset_button.setOpaque(true);
        reset_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_buttonActionPerformed(evt);
            }
        });

        exit_button.setBackground(new java.awt.Color(219, 87, 95));
        exit_button.setFont(new java.awt.Font("PF Tempesta Five Condensed", 0, 14)); // NOI18N
        exit_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/interface/exit_icon.png"))); // NOI18N
        exit_button.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        exit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_buttonActionPerformed(evt);
            }
        });

        time_lable.setBackground(new java.awt.Color(0, 51, 51));
        time_lable.setFont(new java.awt.Font("Liquid Crystal", 1, 24)); // NOI18N
        time_lable.setForeground(new java.awt.Color(0, 204, 0));
        time_lable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        time_lable.setText("00:00");
        time_lable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        time_lable.setOpaque(true);

        timer_progressbar.setMaximum(120);
        timer_progressbar.setOrientation(1);
        timer_progressbar.setValue(120);
        timer_progressbar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        javax.swing.GroupLayout timer_panelLayout = new javax.swing.GroupLayout(timer_panel);
        timer_panel.setLayout(timer_panelLayout);
        timer_panelLayout.setHorizontalGroup(
            timer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timer_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(timer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reset_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pause_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exit_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(timer_panelLayout.createSequentialGroup()
                        .addComponent(time_lable, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, timer_panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(timer_progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        timer_panelLayout.setVerticalGroup(
            timer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timer_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pause_button, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reset_button, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timer_progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(time_lable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout bottom_rowLayout = new javax.swing.GroupLayout(bottom_row);
        bottom_row.setLayout(bottom_rowLayout);
        bottom_rowLayout.setHorizontalGroup(
            bottom_rowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottom_rowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(game_grid_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timer_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bottom_rowLayout.setVerticalGroup(
            bottom_rowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottom_rowLayout.createSequentialGroup()
                .addGroup(bottom_rowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(timer_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(game_grid_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout game_containerLayout = new javax.swing.GroupLayout(game_container);
        game_container.setLayout(game_containerLayout);
        game_containerLayout.setHorizontalGroup(
            game_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottom_row, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, game_containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(state_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        game_containerLayout.setVerticalGroup(
            game_containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, game_containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(state_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottom_row, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(game_container, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(game_container, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reset_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_buttonActionPerformed
        start_game();
    }//GEN-LAST:event_reset_buttonActionPerformed

    private void exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_buttonActionPerformed
        this.dispose(); // esto cierra el frame
    }//GEN-LAST:event_exit_buttonActionPerformed

    private ImageIcon pause_icon = new javax.swing.ImageIcon(getClass().getResource("/Images/interface/pause_icon.png"));    
    private ImageIcon resume_icon = new javax.swing.ImageIcon(getClass().getResource("/Images/interface/resume_icon.png"));


    private void pause_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pause_buttonActionPerformed
        // pausar juego
        
        pause = !pause; // cambia el estado de pausa
        if (pause) {
            pause_button.setIcon(resume_icon);
            timer.stop();
        } else {
            pause_button.setIcon(pause_icon);
            timer.start();
        }
        pause_button.revalidate();
        pause_button.repaint();
        // desactiva/activa las tarjetas que NO esten emparejadas (esas se debe quedar desactivadas)
        for (MiniCard card : cards) {
            if (!card.paired) {
                card.setEnabled(!pause);
            }
        }
    }//GEN-LAST:event_pause_buttonActionPerformed

    /**
     * @param args the command line arguments
     */
    // funcion que genera un vector de ids en pares [1,1,2,2,3,3,...etc] y los revuelve
    public String[] generateIds() {
        
        String[] ids = new String[size * size];
        int counter = 0; // contador que aumenta de 16 en 16

        while (counter < size * size) {
            for (int i = 0; i < 8; i++) { // añade 8 veces
                // si no nos hemos pasado del tamaño del vector de tarjetas
                if (i * 2 + counter < size * size - 1) { 
                    // añade 2 ids iguales enla posicion actual y la que sigue
                    ids[i * 2 + counter] = "" + (i + 1);
                    ids[i * 2 + counter + 1] = "" + (i + 1);
                }
            }
            counter += 16;
        }

        shuffleArray(ids); // y revuelvelos

        return ids;
    }

    // funcion que revuelve los elementos de un arreglo
    static void shuffleArray(String[] ar) {
        Random rnd = new Random(); // ramdomizador
        // para cada una de los elementos del arreglo
        for (int i = ar.length - 1; i > 0; i--) { // empieza desde el final y hasta la posicion 0
            int index = rnd.nextInt(i + 1); // gener un index aleatorio entre 0 y la posicion actual
            String a = ar[index]; // guarda el valor de la posicion actual
            ar[index] = ar[i]; // en la posicion actual pon el de la posicion aleatoria
            ar[i] = a; // en la posicion aleatoria pon el actual
        }
    }

    // funcion que genera los botones del juego
    public void generate_grid() {
        // indicale al panel del juego vacio que será una cuadricula 
        // Vaciar el panel
        game_grid_panel.removeAll();

        // Actualizar el panel
        game_grid_panel.revalidate();
        game_grid_panel.repaint();
        game_grid_panel.setLayout(new GridLayout(size, size)); // esta es la linea que lo vuelve cuadricula
        game_grid_panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        // genera el arreglo con los ids aleatorios
        String[] ids = generateIds();

        for (int i = 0; i < size * size; i++) {
            // añade las tarjetas la lista de tarjetas y asignales un id
            cards[i] = new MiniCard(ids[i], theme);
            // añade a cada terjeta el lector de eventos del JFrame
            cards[i].addActionListener(this);
            //añade cada tarjeta al panel
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
    private javax.swing.JButton exit_button;
    private javax.swing.JPanel game_container;
    private javax.swing.JPanel game_grid_panel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton pause_button;
    private javax.swing.JButton reset_button;
    private javax.swing.JLabel state_label;
    private javax.swing.JPanel state_panel;
    private javax.swing.JLabel time_lable;
    private javax.swing.JPanel timer_panel;
    private javax.swing.JProgressBar timer_progressbar;
    // End of variables declaration//GEN-END:variables

    // funciones de evento (tarjetas)
    // funcion que maneja la tarjeta a la que le des click
    public void handleMiniCardClick(MiniCard clickedCard) { 
        // si la tareta ya esta revelada
        if (clickedCard.revealed) {
            // ocultala
            clickedCard.unreveal();
            // y sacala de la pareja
            for (int i = 0; i < 2; i++) {
                if (pair[i] == clickedCard) {
                    pair[i] = null;
                    break;
                }
            }
            // si no esta revelada y solo si alguno de los espacios para la pareja esta vacio
        } else if (pair[0] == null || pair[1] == null) {
            // revelar la tarjeta clickeada
            clickedCard.reveal();

            // y añadela a la pareja
            for (int i = 0; i < 2; i++) {
                if (pair[i] == null) {
                    pair[i] = clickedCard;
                    break;
                }
            }

            // si toda la pareja esta ocupada
            if (pair[0] != null && pair[1] != null) {
                // si el id de ambas tarjetas en la pareja es igual
                if (pair[0].id.equals(pair[1].id)) {
                    // ponlas en match
                    pair[0].match();
                    pair[1].match();
                    
                    // y si no coinciden
                } else {
                    // pon la animacion de error
                    pair[0].unmatch();
                    pair[1].unmatch();

                }
                // y quitalas de la pareja
                pair[0] = null;
                pair[1] = null;

            }
        }

        // verificar si ya ganaste
        win = true;
        for (int i = 0; i < size * size; i++) { 
            // si se encuentra una tarjeta sin pareja es porque no has ganado
            if (cards[i] == null || !cards[i].paired) {
                win = false;
                break;
            }
        }
        // si ganate deten el temporizador y manda el mensaje de ganaste
        if (win) {
            state_label.setText("Ganaste!");
            time = 0;
            timer.stop();
            time_lable.setText("__:__");
            state_label.setForeground(Color.WHITE);
            state_panel.setBackground(Color.GREEN);
        }

    }

    @Override
    // cuando detecte que se realizó una accion
    public void actionPerformed(ActionEvent ae) {
        // si la accion se realizó en una MiniCard
        if (ae.getSource().getClass() == MiniCard.class) {
            handleMiniCardClick((MiniCard) ae.getSource()); // maneja la accion
        }

        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
