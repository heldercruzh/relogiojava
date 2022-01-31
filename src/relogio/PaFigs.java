
package relogio;

import java.awt.Color;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Helder
 */
public class PaFigs extends javax.swing.JPanel {

    int x=62, y=62, dx=100, dy=100;
    int c;



    public PaFigs() {
        initComponents();
    }

    public void desenha(int fx, int fy, int cor){
        dy = fy;
        c = cor;
    }

    public String getHoraDigital() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.decode(String.valueOf(c)));
        g.drawOval(10, 10, 100, 100);
        double T[] = new double[2];
        g.drawString("12", x-10, y-34);
        g.drawString("3", x+34, y+4);
        g.drawString("6", x-4, y+43);
        g.drawString("9", x-47, y+4);

        String data = "dd/MM/yyyy";
        String hora = "hh";
        String min = "mm";
        String seg = "ss";
        String data1, hora1;

        java.util.Date agora = new java.util.Date();  
        SimpleDateFormat formata = new SimpleDateFormat(data);  
        data1 = formata.format(agora);  
        formata = new SimpleDateFormat(hora);  
        hora1 = formata.format(agora);  
        dx = Integer.parseInt(hora1)*10;

	int i;

	//ponto de referencia para inicio de calculos transformacao
	T[0]=0;
	T[1]=-20;

	//Equação de Transformação Linear:
	//T(x,y) = (cos(a)*x - sin(a)*y ; sin(a)*x + cos(a)*y)
	//a = angulo

        int escala = 120;
	for (i=0;i<dx;i++){	//transf. linear 0.04~ = 2.7° em radianos, 270/100 (escala)
		T[0] = Math.cos(Math.toRadians(360)/escala)*(T[0]) - Math.sin(Math.toRadians(360)/escala)*(T[1]);	//para x
		T[1] = Math.sin(Math.toRadians(360)/escala)*(T[0]) + Math.cos(Math.toRadians(360)/escala)*(T[1]);	//para y
	}

	T[0] += x;	//soma ao centro
	T[1] += y;	//soma ao centro

        g.drawLine(x, y, (int)(T[0]), (int)(T[1]));

        escala = 600;
        formata = new SimpleDateFormat(min);  
        hora1 = formata.format(agora);  
        dx = Integer.parseInt(hora1)*10;

	T[0]=0;
	T[1]=-25;

	for (i=0;i<dx;i++) { //transf. linear 0.04~ = 2.7° em radianos, 270/100 (escala)
            T[0] = Math.cos(Math.toRadians(360)/escala)*(T[0]) - Math.sin(Math.toRadians(360)/escala)*(T[1]); //para x
            T[1] = Math.sin(Math.toRadians(360)/escala)*(T[0]) + Math.cos(Math.toRadians(360)/escala)*(T[1]); //para y
	}

	T[0] += x; //soma ao centro
	T[1] += y; //soma ao centro

        g.drawLine(x, y, (int)(T[0]), (int)(T[1]));

        formata = new SimpleDateFormat(seg);  
        hora1 = formata.format(agora);  
        dx = Integer.parseInt(hora1)*10;

	T[0]=0;
	T[1]=-30;

	for (i=0;i<dx;i++) {	//transf. linear 0.04~ = 2.7° em radianos, 270/100 (escala)
		T[0] = Math.cos(Math.toRadians(360)/escala)*(T[0]) - Math.sin(Math.toRadians(360)/escala)*(T[1]); //para x
		T[1] = Math.sin(Math.toRadians(360)/escala)*(T[0]) + Math.cos(Math.toRadians(360)/escala)*(T[1]); //para y
	}

	T[0] += x; //soma ao centro
	T[1] += y; //soma ao centro

        g.drawLine(x, y, (int)(T[0]), (int)(T[1]));

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
