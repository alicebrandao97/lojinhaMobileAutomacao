package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutosTela extends BaseTela {

    public ListaDeProdutosTela(WebDriver app) {
        super(app);
    }

    public FormularioDeAdicaoDeProdutoTela acessarFormularioDeAdicaoDeProduto() {
        app.findElement(By.id("com.lojinha:id/floatingActionButton")).click();
        return new FormularioDeAdicaoDeProdutoTela(app);
    }
}
