/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceInvaders;

import java.awt.Color;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.ImageIcon;

/**
 *
 * @author Fernando
 */
public class Tablero extends javax.swing.JFrame {

    /**
     * Creates new form Tablero
     */
    Casilla cuadricula[][] = new Casilla[25][15];
    static Nave nuevanave;
    static Nave nuevanave2;
    Enemigo enemigos[];
    public static int enemigosderrotados = 0;
    String nave = "nave.jpg";
    String nave2 = "nave2.png";
    String misil = "misil.png";
    String enemigo = "enemigo.jpg";
    ExecutorService ejecutorInsertar;
    ExecutorService ejecutormisil;
    ExecutorService ejecutorInsertar1 = null;
    public static Boolean pausa = false;

    public Tablero() {
        initComponents();

        this.setSize(1000, 650);
        this.setLocationRelativeTo(null);
        int inicioX = 100;
        int inicioY = 100;
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 15; j++) {
                cuadricula[i][j] = new Casilla();
                cuadricula[i][j].setBackground(Color.black);
                cuadricula[i][j].setOpaque(true);
                Border border = BorderFactory.createLineBorder(Color.white, 1);
                cuadricula[i][j].setBorder(border);
                cuadricula[i][j].setBounds(inicioY + 30, inicioX, 30, 30);
                this.add(cuadricula[i][j]);
                inicioX += 30;
            }
            inicioX = 100;
            inicioY += 30;
        }
        this.getContentPane();
        nuevanave = new Nave();
        nuevanave.posicionNaveCentro = 5;
        nuevanave2 = new Nave();
        nuevanave2.posicionNaveCentro = 15;
        txtvida1.setText(Integer.toString(nuevanave.getVida()));
        txtvida2.setText(Integer.toString(nuevanave2.getVida()));
        txtenemigos.setText("0");
        //cuadricula[nuevanave.getPosicionNaveCentro()][13].setBackground(Color.GREEN);

        cuadricula[nuevanave.getPosicionNaveCentro()][13].setIcon(getIcono(1));
        //cuadricula[nuevanave2.getPosicionNaveCentro()][13].setBackground(Color.GREEN);
        cuadricula[nuevanave2.getPosicionNaveCentro()][13].setIcon(getIcono(2));
        ejecutormisil = Executors.newCachedThreadPool();
//        ExecutorService ejecutorInsertar = Executors.newCachedThreadPool();
//        
//        ejecutorInsertar.execute(new CapturaTeclado(this,this.cuadricula,this.nuevanave,this.nuevanave2));
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
                new KeyEventDispatcher() {
            public boolean dispatchKeyEvent(KeyEvent keyEvent) {
                if (keyEvent.getID() == KeyEvent.KEY_TYPED) {
                    if (!Tablero.pausa) {
                        char ch = keyEvent.getKeyChar();

                        switch (ch) {
                            case 'a':
                                //System.out.println(event.getKeyChar());
                                if (nuevanave.getPosicionNaveCentro() - 1 != -1) {
                                    cuadricula[nuevanave.getPosicionNaveCentro()][13].setBackground(Color.black);
                                    cuadricula[nuevanave.getPosicionNaveCentro()][13].setIcon(null);
                                    nuevanave.setPosicionNaveCentro(nuevanave.getPosicionNaveCentro() - 1);
                                    // cuadricula[nuevanave.getPosicionNaveCentro()][13].setBackground(Color.GREEN);
                                    cuadricula[nuevanave.getPosicionNaveCentro()][13].setIcon(getIcono(1));

                                }
                                break;
                            case 'd':
                                if (nuevanave.getPosicionNaveCentro() + 1 != 25 && (nuevanave.getPosicionNaveCentro() + 1 != nuevanave2.getPosicionNaveCentro())) {

                                    cuadricula[nuevanave.getPosicionNaveCentro()][13].setBackground(Color.black);
                                    cuadricula[nuevanave.getPosicionNaveCentro()][13].setIcon(null);

                                    nuevanave.setPosicionNaveCentro(nuevanave.getPosicionNaveCentro() + 1);
                                    // cuadricula[nuevanave.getPosicionNaveCentro()][13].setBackground(Color.GREEN);
                                    cuadricula[nuevanave.getPosicionNaveCentro()][13].setIcon(getIcono(1));

                                }
                                break;
                            case 's':
                                ejecutormisil.execute(new TrayectoriaMisil(new Misil(nuevanave.getPosicionNaveCentro(), 13), cuadricula));
                                break;
                            default:
                                break;
                        }
                        switch (ch) {
                            case 'j':
                                if (nuevanave2.getPosicionNaveCentro() - 1 != -1 && (nuevanave2.getPosicionNaveCentro() - 1 != nuevanave.getPosicionNaveCentro())) {

                                    cuadricula[nuevanave2.getPosicionNaveCentro()][13].setBackground(Color.black);
                                    cuadricula[nuevanave2.getPosicionNaveCentro()][13].setIcon(null);

                                    nuevanave2.setPosicionNaveCentro(nuevanave2.getPosicionNaveCentro() - 1);
                                    //cuadricula[nuevanave2.getPosicionNaveCentro()][13].setBackground(Color.GREEN);
                                    cuadricula[nuevanave2.getPosicionNaveCentro()][13].setIcon(getIcono(2));

                                }
                                break;
                            case 'l':
                                if (nuevanave2.getPosicionNaveCentro() + 1 != 25) {
                                    cuadricula[nuevanave2.getPosicionNaveCentro()][13].setBackground(Color.black);
                                    cuadricula[nuevanave2.getPosicionNaveCentro()][13].setIcon(null);

                                    nuevanave2.setPosicionNaveCentro(nuevanave2.getPosicionNaveCentro() + 1);
                                    //cuadricula[nuevanave2.getPosicionNaveCentro()][13].setBackground(Color.GREEN);
                                    cuadricula[nuevanave2.getPosicionNaveCentro()][13].setIcon(getIcono(2));

                                }

                                break;
                            case 'k':
                                ejecutormisil.execute(new TrayectoriaMisil(new Misil(nuevanave2.getPosicionNaveCentro(), 13), cuadricula));
                                break;
                            default:
                                break;
                        }
                    }
                }
                return false; // allowing it to be dispatched further
            }
        });

        //this.addKeyListener(new MKeyListener(cuadricula, nuevanave, nuevanave2));
        crearFilasEnemigas();

//        ejecutorInsertar.shutdown();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        puntos = new javax.swing.JLabel();
        vida1 = new javax.swing.JLabel();
        vida2 = new javax.swing.JLabel();
        txtvida1 = new javax.swing.JTextField();
        txtvida2 = new javax.swing.JTextField();
        txtenemigos = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Pausa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        puntos.setText("Enemigos Derrotados:");

        vida1.setText("Vida Nave 1:");

        vida2.setText("Vida nave 2:");

        txtvida1.setFocusable(false);

        txtvida2.setFocusable(false);

        txtenemigos.setFocusable(false);

        jButton2.setText("Terminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Nueva");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(225, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(puntos, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtenemigos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vida1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtvida1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(vida2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtvida2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(puntos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vida1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vida2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvida1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvida2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtenemigos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static ImageIcon getIcono(int opcion) {
        String resultado = "";
        switch (opcion) {
            case 1:
                resultado = "nave.jpg";
                break;
            case 2:
                resultado = "nave2.png";
                break;
            case 3:
                resultado = "misil.png";
                break;
            case 4:
                resultado = "images.png";
                break;
        }
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(resultado));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        return imageIcon;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pausa = !pausa;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        try {
             for (int i = 0; i < enemigos.length; i++) {
                enemigos[i].setUsado(true);
            }
            ejecutormisil.shutdownNow();
            ejecutorInsertar1.shutdownNow();
            ejecutorInsertar.shutdownNow();
            
        } catch (Exception ex) {
           // Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int inicioX = 100;
        int inicioY = 100;
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 15; j++) {
                cuadricula[i][j] = new Casilla();
                cuadricula[i][j].setBackground(Color.black);
                cuadricula[i][j].setOpaque(true);
                Border border = BorderFactory.createLineBorder(Color.white, 1);
                cuadricula[i][j].setBorder(border);
                cuadricula[i][j].setBounds(inicioY + 30, inicioX, 30, 30);
                this.add(cuadricula[i][j]);
                inicioX += 30;
            }
            inicioX = 100;
            inicioY += 30;
        }
        this.getContentPane();
        nuevanave = new Nave();
        nuevanave.posicionNaveCentro = 5;
        nuevanave2 = new Nave();
        nuevanave2.posicionNaveCentro = 15;
        txtvida1.setText(Integer.toString(nuevanave.getVida()));
        txtvida2.setText(Integer.toString(nuevanave2.getVida()));
        txtenemigos.setText("0");
        //cuadricula[nuevanave.getPosicionNaveCentro()][13].setBackground(Color.GREEN);

        cuadricula[nuevanave.getPosicionNaveCentro()][13].setIcon(getIcono(1));
        //cuadricula[nuevanave2.getPosicionNaveCentro()][13].setBackground(Color.GREEN);
        cuadricula[nuevanave2.getPosicionNaveCentro()][13].setIcon(getIcono(2));
        ejecutormisil = Executors.newCachedThreadPool();
    }//GEN-LAST:event_jButton3ActionPerformed
    public static void modificarvida(int i) {
        if (i == 1) {
            nuevanave.setVida(nuevanave.getVida() - 1);
            Tablero.txtvida1.setText(Integer.toString(nuevanave.getVida()));
        } else {
            nuevanave2.setVida(nuevanave2.getVida() - 1);
            Tablero.txtvida2.setText(Integer.toString(nuevanave2.getVida()));
        }

    }

    public void crearFilasEnemigas() {
        ejecutorInsertar = Executors.newCachedThreadPool();
        ExecutorService ejecutorInsertar1 = null;
        ejecutorInsertar.execute(new CrearFilasEnemigas(enemigos, cuadricula,ejecutorInsertar1));

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel puntos;
    public static javax.swing.JTextField txtenemigos;
    public static javax.swing.JTextField txtvida1;
    public static javax.swing.JTextField txtvida2;
    private javax.swing.JLabel vida1;
    private javax.swing.JLabel vida2;
    // End of variables declaration//GEN-END:variables
}
