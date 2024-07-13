package modulos.produto;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import telas.LoginTela;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@DisplayName("Testes Mobile do Módulo de Produto")
public class ProdutoTest {
    private WebDriver app;
    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        //Abrir o App
        BaseOptions capacidades = new BaseOptions();
        capacidades.setCapability("deviceName","Google Pixel 2");
        capacidades.setCapability("platformName","Android");
        capacidades.setCapability("udid","192.168.205.101:5555");
        capacidades.setCapability("appPackage","com.lojinha");
        capacidades.setCapability("appActivity","com.lojinha.ui.MainActivity");
        capacidades.setCapability("app", "C:\\Android\\lojinha-nativa.apk");

        this.app = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);
        this.app.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    }

    @DisplayName("Validação do valor de produto não permitido")
    @Test
    public void testValidacaoDoValorDeProdutoNaoPermitido() {
        String mensagemApresentada = new LoginTela(app)
                .informarUsuario("alicewonderland")
                .informarSenha("12345")
                .submeterFormularioDeLogin()
                .acessarFormularioDeAdicaoDeProduto()
                .informarNomeDoProduto("Mac Book Pro")
                .informarValorDoProduto("700001")
                .informarCoresDoProduto("Preto,Cinza")
                .submeterMensagem()
                .obterMensagem();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @DisplayName("Validação do valor de produto Permitido")
    @Test
    public void testValidacaoDoValorDoProdutoPermitido() {
        String mensagemApresentada = new LoginTela(app)
                .informarUsuario("alicewonderland")
                .informarSenha("12345")
                .submeterFormularioDeLogin()
                .acessarFormularioDeAdicaoDeProduto()
                .informarNomeDoProduto("Samsung Galaxy S20")
                .informarValorDoProduto("200050")
                .informarCoresDoProduto("Preto,Cinza,Azul")
                .submeterMensagem()
                .obterMensagem();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
    }

    @AfterEach
    public void afterEach() {

        app.quit();
    }
}
