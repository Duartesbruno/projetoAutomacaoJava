package pages;

import lombok.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class CadastroPage extends BasePage{

    @FindBy(id="elementosForm:nome")
    private WebElement txNome;
    @FindBy(id="elementosForm:sobrenome")
    private WebElement txSobrenome;

    @FindBy(id="elementosForm:sexo:0")
    private WebElement rdSexoMasc;
    @FindBy(id="elementosForm:sexo:1")
    private WebElement rdSexoFem;

//    @FindAll(name="elementosForm:comidaFavorita")
//    private ArrayList<WebElement> comidas;

    @FindBy(id="elementosForm:comidaFavorita:0")
    private WebElement chkComidaCarne;
    @FindBy(id="elementosForm:comidaFavorita:1")
    private WebElement chkComidaFrango;
    @FindBy(id="elementosForm:comidaFavorita:2")
    private WebElement chkComidaPizza;
    @FindBy(id="elementosForm:comidaFavorita:3")
    private WebElement chkComidaVegetariano;

    @FindBy(id="elementosForm:escolaridade")
    private WebElement selEscolaridade;

    @FindBy(id="elementosForm:esportes")
    private WebElement selEsportes;
    @FindBy(id="elementosForm:sugestoes")
    private WebElement txSugestoes;

    @FindBy(id="elementosForm:cadastrar")
    private WebElement btnCadastrar;

    @FindBy(id="resultado")
    private WebElement resultado;

    @FindBy(partialLinkText="Google")
    private WebElement linkGoogle;

    @FindBy(linkText="Site da Globo")
    private WebElement linkGlobo;

    public CadastroPage(WebDriver driver) {
        super(driver);
    }

    public CadastroPage preencherNome(String nome) {
        txNome.sendKeys(nome);
        return this;
    }

    public CadastroPage preencherSobrenome(String sobrenome) {
        txSobrenome.sendKeys(sobrenome);
        return this;
    }

    public CadastroPage clickSexo() {
        rdSexoMasc.click();
        return this;
    }

    public CadastroPage clickComida() {
        chkComidaCarne.click();
        chkComidaFrango.click();
        chkComidaPizza.click();
        return this;
    }

    public CadastroPage selecionarEscolaridade(String escolaridade)  {
        Select dropdown = new Select(selEscolaridade);
        dropdown.selectByVisibleText(escolaridade);
        return this;
    }

    public CadastroPage preencherSugestao(String sugestao)  {
        txSugestoes.sendKeys(sugestao);
        return this;
    }

    public CadastroPage selecionarEsportes(String esporte) {
        Select dropdown = new Select(selEsportes);
        dropdown.selectByVisibleText(esporte);
        return this;
    }

//    este método foi criado como alternativa para selecionar multiplos esportes de ima unica vez
//    public CadastroPage selecionarEsporte(ArrayList<String> esportes)  {
//        Select dropdown = new Select(selEsportes);
//        for(int a=0;a<=esportes.size();a++) {
//            dropdown.selectByVisibleText(esportes.get(a));
//        }
//        return this;
//    }

    public CadastroPage clicarCadastrar() {
        btnCadastrar.click();
        return this;
    }

    public String obterResultado() {
        return resultado.getText();
    }

    public CadastroPage clicarLinkGlobo() {
        linkGlobo.click();
        String  titulo = driver.getTitle();
        driver.navigate().back();
        return titulo;
    }

    public CadastroPage clicarLinkGoogle() {
        linkGoogle.click();
        String url = driver.getCurrentUrl();
        driver.navigate().back();
        return url;

    }

}
