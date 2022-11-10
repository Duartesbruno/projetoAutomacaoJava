import entities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CadastroPage;

import java.util.ArrayList;

public class CadastroTest extends BaseTest {

    @org.testng.annotations.Test
    public void deveCadastrarPessoa(){

        CadastroPage page = new CadastroPage(getDriver());

        //ArrayList<String> ListaEsportes = new ArrayList<>();
        //ListaEsportes.add("Futebol");
        //ListaEsportes.add("Corrida");

        String nome = "Bruno";
        String sobrenome = "Silva Duarte";
        String escolaridade = "Doutorado";
        String esporte1 = "Futebol";
        String esporte2 = "Corrida";
        String sugestoes = "Nada a declarar";


        String resultado = page.preencherNome(nome)
                .preencherSobrenome(sobrenome)
                .clickSexo()
                .clickComida()
                .selecionarEscolaridade(escolaridade)
                //.selecionarEsporte(listaEsportes)
                .selecionarEsportes(esporte1)
                .selecionarEsportes(esporte2)
                .preencherSugestao(sugestoes)
                .clicarCadastrar()
                .obterResultado();

        Assert.assertTrue(resultado.contains("Nome: " + nome));
        Assert.assertTrue(resultado.contains("Sobrenome: " + sobrenome));
        Assert.assertTrue(resultado.contains("Sexo: Masculino"));
        Assert.assertTrue(resultado.contains("Comida: Carne Frango Pizza"));
        Assert.assertTrue(resultado.contains("Escolaridade: " + escolaridade.toLowerCase()));
        Assert.assertTrue(resultado.contains("Esportes: " + esporte1 + " " + esporte2));
        Assert.assertTrue(resultado.contains("Sugestoes: " + sugestoes));

        System.out.println(resultado);

    }

    @org.testng.annotations.Test
    public void deveValidarLinks() {
        CadastroPage page = new CadastroPage(getDriver());
        Assert.assertEquals(page.clicarLinkGlobo(), "G1 - O portal de notícias da Globo");
        Assert.assertEquals(page.clicarLinkGoogle(), "https://www.google.com/?qws_rd=ssl");
    }

}
