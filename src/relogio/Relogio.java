package relogio;

public class Relogio {

    public static void main(String[] args) {
        Tela1 t1 = new Tela1();
        t1.setVisible(true);

        while(true) {
            t1.oi();
            t1.atualizarRelogioDigital();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
