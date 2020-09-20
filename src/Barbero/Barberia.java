/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Barbero;

import java.awt.Color;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author Fernando
 */
public class Barberia extends javax.swing.JFrame {

    /**
     * Creates new form Barberia
     */
    public Silla cuadricula[][] = new Silla[10][2];
    ExecutorService ejecutorPersona;
    ListaSillas lista;
    public static int cola = 0;
    public static int atendidos = 0;
    public static int retirados = 0;

    public Barberia() {
        initComponents();

        this.setSize(950, 600);
        this.setLocationRelativeTo(null);
        int inicioX = 120;
        int inicioY = 20;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                cuadricula[i][j] = new Silla();
                cuadricula[i][j].setBackground(Color.black);
                cuadricula[i][j].setOpaque(true);
                Border border = BorderFactory.createLineBorder(Color.white, 1);
                cuadricula[i][j].setBorder(border);
                cuadricula[i][j].setBounds(inicioY + 70, inicioX, 60, 60);
                this.add(cuadricula[i][j]);
                inicioX += 70;
            }
            inicioX = 120;
            inicioY += 80;
        }
        this.getContentPane();
        barbero.setOpaque(true);
        barbero.setBackground(Color.BLUE);
        lista = new ListaSillas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barbero = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtespera = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtatendidas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtretirados = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        barbero.setText("Barbero");

        jLabel1.setText("Cantidad de personas para la simulacion:");

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Personas en espera:");

        jLabel3.setText("Personas Atendidas:");

        jLabel4.setText("Personas que se retiraron:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(barbero, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtespera))
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtatendidas, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtretirados, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtespera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtatendidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtretirados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(barbero, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ejecutorPersona = Executors.newCachedThreadPool();
        String numero = txtcantidad.getText();
        int cantidad = Integer.parseInt(numero);
        ejecutorPersona.execute(new Barbero(cuadricula, lista));
        ejecutorPersona.execute(new LlegadaClientes(cuadricula, lista, cantidad));
    }//GEN-LAST:event_jButton1ActionPerformed
    public static void actualizarespera(int accion) {
        if (accion == 0) {
            cola = cola + 1;
        } else {
            cola = cola - 1;
        }
        txtespera.setText(String.valueOf(cola));
    }

    public static void actualizaratendidos() {
        atendidos = atendidos + 1;
        txtatendidas.setText(String.valueOf(atendidos));
    }

    public static void actualizarretirados() {
        retirados = retirados + 1;
        txtretirados.setText(String.valueOf(retirados));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel barbero;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JTextField txtatendidas;
    private javax.swing.JTextField txtcantidad;
    public static javax.swing.JTextField txtespera;
    public static javax.swing.JTextField txtretirados;
    // End of variables declaration//GEN-END:variables
}
