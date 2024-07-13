package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeAdicaoDeProdutoTela extends BaseTela {

    public FormularioDeAdicaoDeProdutoTela(WebDriver app) {
        super(app);
    }

    public FormularioDeAdicaoDeProdutoTela informarNomeDoProduto(String produtoNome) {
        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoNome);
        return this;
    }

    public FormularioDeAdicaoDeProdutoTela informarValorDoProduto(String produtoValor) {
        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoValor);
        return this;
    }

    public FormularioDeAdicaoDeProdutoTela informarCoresDoProduto(String produtoCores) {
        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys(produtoCores);
        return this;
    }

    public FormularioDeAdicaoDeProdutoTela submeterMensagem() {
        app.findElement(By.id("com.lojinha:id/saveButton")).click();
        return this;
    }

    public String obterMensagem() {
        return capturarToast();
    }
}