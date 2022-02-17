package tests;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SearchTest {


    private WebDriver navegador;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","c:\\Driver\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    /*
    * Cenário em que o usuário acessa a pagina do e-comerce
    * e realiza a busca de um produto utilizando o campo de busca.
    * */
    @Test
    public void buscarProdutoTest(){


        navegador.get("https://www.magazineluiza.com.br/");
        navegador.findElement(By.id("input-search")).click();
        navegador.findElement(By.id("input-search")).sendKeys("Notebook");
        navegador.findElement(By.id("input-search")).sendKeys(Keys.ENTER);
        String text = navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/main/section[4]/div[3]/div/ul/li[1]/a/div[2]/h2")).getText();
        System.out.println(text);
        Assert.assertEquals("Notebook Acer A515-54-59BU Intel Core i5 8GB", text);

    }

    /*
     * Cenário em que o usuário acessa a pagina do e-comerce
     * e realiza a busca utilizando a barra de navegação e clicando no departamneto
     * especifico.
     * */
    @Test
    public void buscarProdutoFLuxoAlternativoTeste(){

        navegador.get("https://www.magazineluiza.com.br/");
        navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/main/section[1]/div[2]/header/div/div[3]/nav/ul/li[7]/div[1]/a")).click();
        navegador.findElement(By.xpath("//*[@id=\"sideNavigation\"]/nav/ul/li[1]/ul/li[1]/a")).click();
        String text = navegador.findElement(By.xpath("//*[@id=\"showcase\"]/ul[1]/a[1]/div[3]/h3")).getText();
        System.out.println(text);
        Assert.assertEquals("Notebook Acer A515-54-59BU Intel Core i5 8GB", text);

    }
}
