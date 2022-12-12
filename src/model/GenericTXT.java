package model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class GenericTXT<S, N extends Integer> {
    private S arquivo;
    private N id;

    public GenericTXT(S arquivo, N id) {
        this.arquivo = arquivo;
        this.id = id;
        try {
            FileWriter fw = new FileWriter("voos.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            Voo meuVoo = Voo.getByID(id);
            bw.write(meuVoo.getDestino());
            bw.newLine();
            bw.write(meuVoo.getOrigem());
            bw.newLine();
            bw.write(meuVoo.getPiloto());
            bw.newLine();
            bw.write(meuVoo.getCopiloto());
            bw.newLine();
            bw.write(meuVoo.getObservacao());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void readArquivo(String arquivo) {
        try {
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = br.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = br.readLine();
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}