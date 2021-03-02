
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Arquivo {

    public int cadastrar(Veiculo veiculo) {
        int dadosGravados = 0;

        File f = new File("veiculos.txt");

        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            FileWriter fw = new FileWriter(f,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(veiculo.getPlaca() + ";" + veiculo.getTipo() + ";" + veiculo.getHoraEntrada() + ";" + veiculo.getHoraSaida() + ";" + veiculo.getVaga() + "/");
            bw.newLine();

            bw.close();
            dadosGravados = 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            dadosGravados = 0;
        }

        return dadosGravados;
    }

    public String[] consultar() {
        String[] vetor = null;
        String linha;
        String conteudo = "";
        int numero = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("veiculos" + ".txt"));
            while ((linha = br.readLine()) != null) {
                //System.out.println("Linha: " + linha);
                conteudo = conteudo + linha;
            }
            br.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
        vetor = conteudo.split("/");       
        return vetor;
    }
    
    public void limpar(){
        File f = new File("veiculos.txt");
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            bw.close();          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);          
        } 
    }
}
