
package relogio;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Diego
 */
public class Tela1 extends javax.swing.JFrame {

    public Tela1() {
        initComponents();
    }

    private void initComponents() {

        bgCor = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        paFigs1 = new relogio.PaFigs();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        jLabel1.setText(paFigs1.getHoraDigital());
        jPanel2.add(jLabel1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout paFigs1Layout = new javax.swing.GroupLayout(paFigs1);
        paFigs1.setLayout(paFigs1Layout);
        paFigs1Layout.setHorizontalGroup(
            paFigs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );
        paFigs1Layout.setVerticalGroup(
            paFigs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );

        jPanel5.add(paFigs1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }

    public void oi(){
        paFigs1.desenha(0, 0, 63000);
        paFigs1.repaint();
        paFigs1.setBackground(Color.BLACK);
    }

    public void atualizarRelogioDigital(){
        jLabel1.setText(paFigs1.getHoraDigital());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgCor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private relogio.PaFigs paFigs1;
    // End of variables declaration//GEN-END:variables
}
