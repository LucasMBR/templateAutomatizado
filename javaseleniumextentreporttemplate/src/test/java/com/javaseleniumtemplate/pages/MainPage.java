package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class MainPage extends PageBase {
    //Mapping
    By usernameLoginInfoTextArea = By.xpath("//div[@class='zh-header-info']");
    By reportIssueLink = By.xpath("//a[@href='/bug_report_page.php']");

    By menuPrincipal = By.xpath("//div[@class='bars']");
    //By menuPrincipal = By.id("splash");
    By displayPagamentosVencidos = By.xpath("//span[text() = 'Pagamentos - Vencidos']");
    By menuDocumentosFiscais = By.xpath("//span[text() = 'Documentos Fiscais']");
    By menuDocumentosFiscais_Saidas = By.xpath("//span[text() = 'Saídas']");
    By menuDocumentosFiscais_Saidas_Lancamentos = By.xpath("//span[text() = 'Lançamentos']");
    By menuDocumentosFiscais_Saidas_Lancamentos_LancamentoDeSaida = By.xpath("//span[text() = 'Lançamento de Saída']");

    By loadingWait = By.xpath("//*[@class='zh-background-loading ng-scope']//span[@class='zh-loading-icon']");

    //Actions
    public String retornaUsernameDasInformacoesDeLogin(){
        return getText(usernameLoginInfoTextArea);
    }

    public void clicarEmReportIssue(){
        click(reportIssueLink);
    }

    public void clicarEmMenuPrincipal(){
        waitForElement(displayPagamentosVencidos);
        waitForElement(usernameLoginInfoTextArea);
        click(menuPrincipal);
    }

    public void clicarEmDocumentosFiscais(){
        click(menuDocumentosFiscais);
    }

    public void clicarEmDocumentosFiscaisSaidas(){
        click(menuDocumentosFiscais_Saidas);
    }

    public void clicarEmDocumentosFiscaisSaidasLancamentos(){
        click(menuDocumentosFiscais_Saidas_Lancamentos);
    }

    public void clicarEmDocumentosFiscaisSaidasLancamentosLancamentoDeSaida(){
        click(menuDocumentosFiscais_Saidas_Lancamentos_LancamentoDeSaida);
    }
}
