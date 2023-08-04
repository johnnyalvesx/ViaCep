import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BuscaCep buscaCep = new BuscaCep();

        System.out.println("Digite o CEP que deseja consultar");
        var cepDigitado = in.nextLine();

        try {
            Endereco novoEndereco = buscaCep.buscaEndereco(cepDigitado);
            System.out.println(novoEndereco);
            GeraArquivoJson gerador = new GeraArquivoJson();
            gerador.salvaJson(novoEndereco);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("O CEP deve conter 8 dígitos sem pontuação.");
        }
    }
}
