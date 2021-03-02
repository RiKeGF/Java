
import javax.swing.JOptionPane;

public class Principal {

    //-------------------- Utilidades --------------------
    public static void msg(String msg) {
        System.out.println(msg);
    }

    public static void msgBox(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public static String msgScan(String msg) {
        return JOptionPane.showInputDialog(msg);
    }

    //-----------------------------------------------------
    public static void main(String[] args) {
        int valor1;
        int valor2;
        String op;
        

        valor1 = Integer.parseInt(msgScan("Digite o primeiro valor:"));
        
        do{
            valor2 = Integer.parseInt(msgScan("Digite o segundo valor:"));
            if(valor2==0){
                msgBox("O valor 2 não pode ser zero !");
            }
        }while(valor2==0);
        

        op = msgScan("Digite a operação desejada:\n+ | - | * | /");
        

        msgBox("" + calcular(valor1, valor2, op));
    }

    /*public static int somar(int v1, int v2){
        return v1+v2;
    }
    public static int subtrair(int v1, int v2){
        return v1-v2;
    }
    public static int multiplicar(int v1, int v2){
        return v1*v2;
    }
    public static int dividir(int v1, int v2){
        return v1/v2;
    }*/
    
    public static int calcular(int v1, int v2, String op) {
        switch (op) {
            case "+": {
                return v1 + v2;
            }
            case "-": {
                return v1 - v2;
            }
            case "*": {
                return v1 * v2;
            }
            case "/": {
                return v1 / v2;
            }
        }
        return 0;
    }

}
