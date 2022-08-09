package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LancamentoSaidaPage extends PageBase {
    //Mapping
    By filtroStatus = By.xpath("//div[@class='col-xs-12 zh-field last-of-row'][1]//li[text() = 'texto']");
    By filtroStatusAux = By.xpath("//div[@class='col-xs-12 zh-field last-of-row'][1]");
    By filtroUnidadeAux = By.id("NMFILIAL");
    By filtroUnidade = By.xpath("//*[@id='NMFILIAL']//input");
    By filtroEmpresa = By.id("NMEMPRESA");
    By filtroDestRemet = By.xpath("//*[@id='IDORIGDESTNF']/following-sibling::div[1]//li[text() = 'texto']");
    By getFiltroDestRemetAux = By.xpath("//*[@id='IDORIGDESTNF']/following-sibling::div[1]");
    By filtroDestinatario = By.id("NMRAZSOCCLIE");
    By filtroSerie = By.xpath("//*[@id='DSSERIE']//input");
    By filtroSerieAux = By.id("DSSERIE");
    By filtroDataEmissaoInicial = By.id("DTEMISSAO_START");
    By filtroDataEmissaoFinal = By.id("DTEMISSAO_END");
    By filtroDataSaidaInicial = By.id("DTENTRSAID_START");
    By filtroDataSaidaFinal = By.id("DTENTRSAID_END");
    By filtroOperacao = By.id("NMTIPOOPER");

    By filtroAplicarFiltro = By.xpath("//span[text() = 'Aplicar filtro'][1]");
    By filtroFecharFiltro = By.xpath("//span[text() = 'Fechar'][1]");
    By filtroLimparFiltro = By.xpath("//a[@data-zh-title-tooltip = 'Limpar filtro'][1]");

    By adicionarLancamento = By.xpath("//a[@data-zh-title-tooltip = 'Adicionar (F2)']");

    By unidadeFieldAux = By.id("NMFILIAL");
    By unidadeField = By.xpath("//*[@id='NMFILIAL']//input");
    By operacaoFieldAux= By.xpath("//*[@class='zh-cabecalho ng-valid-maxlength']//*[@id='NMTIPOOPER']");
    By operacaoField = By.xpath("//div//span[text() = '01 | NF Venda']");
    By modeloDocumentoFiscalFIeldAux = By.id("DSMODDOCFISC");
    By modeloDocumentoFiscalFIeld = By.xpath("//*[@id='DSMODDOCFISC']//input");
    By destinarioSearchBtn = By.xpath("//div[@class='col-xs-9 zh-field']//*[@id='NMRAZSOCCLIE']//span");
    By destinarioSearchField = By.xpath("//div[@class='floating-card floating-filter-card no-filter-selection']//input[@ng-if='!isSearchFieldSelect(searchField)']");
    By destinatarioSelect = By.xpath("//div[@class='tr cell1']//div[@data-zh-field-name='NMRAZSOCCLIE']//span");
    By serieSearchBtn = By.xpath("//*[@id='DSSERIE']//span");
    By serieSearchField = By.xpath("//div[@class='floating-card floating-filter-card no-filter-selection']//input[@ng-if='!isSearchFieldSelect(searchField)']");
    By serieSelect = By.xpath("//div[@data-zh-field-name='DSSERIE']//span[text() = 'texto']");
    By dataSaidaField = By.id("DTENTRSAID");
    By numeroNFField = By.id("NRNOTAFISC");

    By salvarLancamentoBtn = By.xpath("//div[@id='footer']//span[text() = 'Salvar']");

    By loadingWait = By.xpath("//*[@class='zh-background-loading ng-scope']//span[@class='zh-loading-icon']");

    By produtosMenu = By.xpath("//label//a[text() = 'Produtos']");
    By adicionarProdutoBtn = By.xpath("//a[@data-zh-title-tooltip = 'Adicionar (F2)']");
    By produtoSearchBtn = By.xpath("//div[@id='NMPRODUTO']//span");
    By produtoSearchField = By.xpath("//div[@class='floating-card floating-filter-card no-filter-selection']//input[@ng-if='!isSearchFieldSelect(searchField)']");
    By produtoSelect = By.xpath("//div[@class='tr cell1']//div[@data-zh-field-name='NMPRODUTO']//span");
    By loteProdutoSearchBtn = By.xpath("//div[@id='NRLOTEESTQ']//span") ;
    By loteProdutoAtualizarBtn = By.xpath("//div[@class='control-menu']//li[@class='float-action refresh-action']//span");
    By loteProdutoSelect = By.xpath("//div[@class='tr cell1']//div[@data-zh-field-name='NRLOTEESTQ']//span");
    By confirmarProdutoBtn = By.xpath("//div[@id='footer']//span[text() = 'Confirmar']");
    By quantidadeProdutoField = By.xpath("//input[@id='QTITEMPROD']");
    By salvarProdutoBtn = By.xpath("//div[@id='footer']//span[text() = 'Salvar']");

    By fecharLancamentoBtn = By.xpath("//div[@id='footer']//span[text() = 'Fechar']");
    By fecharLancamentoConfirmarBtn = By.xpath("//button//span[text() = 'Sim']");

    By statusLancamento = By.xpath("//div[@class='tr cell1']//div");

    public void preencherFiltroStatus(String status){
        waitForInvisibilityOfElementLocated(loadingWait);
        click(filtroStatusAux);
        clickWithText(filtroStatus,status);
    }
    public void preencherFiltroUnidade(String unidade){
        //clickWithoutClickable(filtroUnidade);
        click(filtroUnidadeAux);
        sendKeys(filtroUnidade, unidade);
    }
    public void preencherFiltroEmpresa(String empresa){
        sendKeys(filtroEmpresa,empresa);
    }
    public void preencherFiltroRemetente(String remetente){
        click(getFiltroDestRemetAux);
        clickWithText(filtroDestRemet,remetente);
    }
    public void preencherFiltroDestinario(String destinatario){
        sendKeys(filtroDestinatario, destinatario);
    }
    public void preencherFiltroSerie(String serie){
        click(filtroSerieAux);
        sendKeys(filtroSerie,serie);
    }
    public void preencherFiltroDataEmissaoInicial(String dataEmissaoInicial){
        sendKeys(filtroDataEmissaoInicial,dataEmissaoInicial);
    }
    public void preencherFiltroDataEmissaoFinal(String dataEmissaoFinal){
        sendKeys(filtroDataEmissaoFinal,dataEmissaoFinal);
    }
    public void preencherFiltroDataSaidaInicial(String dataSaidaInicial){
        sendKeys(filtroDataSaidaInicial,dataSaidaInicial);
    }
    public void preencherFiltroDataSaidaFinal(String dataSaidaFinal){
        sendKeys(filtroDataSaidaFinal,dataSaidaFinal);
    }
    public void preencherFiltroOperacao(String operacao){
        sendKeys(filtroOperacao, operacao);
    }

    public void clicarAplicarFiltro(){
        click(filtroAplicarFiltro);
    }
    public void clicarFecharFiltro(){
        click(filtroFecharFiltro);
    }
    public void clicarLimparFiltro(){
        click(filtroLimparFiltro);
    }
    public void clicarAdicionarLancamento(){
        waitForVisibilityOfElementLocated(loadingWait);
        waitForInvisibilityOfElementLocated(loadingWait);
        click(adicionarLancamento);
    }

    public void preencherUnidade(String unidade){
        click(unidadeFieldAux);
        sendKeys(unidadeField,unidade);
    }
    public void preencherOperacao(String operacao){
        //clickWithoutClickable(operacaoFieldAux);
        //System.out.println(driver.getPageSource());
        //driver.findElement(operacaoFieldAux).click();
        //SendKeysJavaScript(operacaoField,operacao);
        //sendKeys(operacaoField,operacao);
        //click(operacaoFieldAux);
        //ClickJavaScript(operacaoFieldAux);
        //driver.findElement(operacaoFieldAux).click();
        //expandShadowRootElement(operacaoFieldAux).findElement(By.xpath(""))
        //System.out.println(getText(operacaoFieldAux));
    }
    public void preencherDocumentoFiscal(String documentoFiscal){
        click(modeloDocumentoFiscalFIeldAux);
        sendKeys(modeloDocumentoFiscalFIeld,documentoFiscal);
    }
    public void clicarPesquisaDestinatario(){
        click(destinarioSearchBtn);
    }
    public void preencherDestinatario(String destinatario){
        sendKeys(destinarioSearchField,destinatario);
    }
    public void clicarEscolherDestinatario(){
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(destinatarioSelect);
    }
    public void clicarPesquisaSerie(){
        click(serieSearchBtn);
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(serieSearchBtn);
    }
    public void preencherSerie(String serie){
        click(serieSearchField);
        sendKeys(serieSearchField,serie);
    }
    public void clicarEscolherSerie(String serie){
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //click(serieSelect);
        clickWithText(serieSelect,serie);
    }
    public void preencherDataSaida(String data){
        sendKeys(dataSaidaField,data);
    }
    public void preencherNumeroNF(String numeroNF){
        sendKeys(numeroNFField,numeroNF);
    }

    public void salvarLancamento(){
        click(salvarLancamentoBtn);
    }

    public void clicarMenuProdutos(){
        waitForVisibilityOfElementLocated(loadingWait);
        waitForInvisibilityOfElementLocated(loadingWait);
        click(produtosMenu);
    }
    public void clicarAdicionarProduto(){
        click(adicionarProdutoBtn);
    }
    public void clicarPesquisaProduto(){
        click(produtoSearchBtn);
    }
    public void preencherNomeProduto(String nomeProduto){
        sendKeys(produtoSearchField,nomeProduto);
    }
    public void clicarEscolherProduto(){
        click(produtoSelect);
    }
    public void clicarPesquisaLoteProduto(){
        click(loteProdutoSearchBtn);
    }
    public void clicarEscolherLoteProduto(){
        click(loteProdutoAtualizarBtn);
        click(loteProdutoSelect);
    }
    public void clicarConfirmarProduto(){
        click(confirmarProdutoBtn);
    }
    public void preencherQuantidadeProduto(String quantidadeProduto){
        waitForVisibilityOfElementLocated(loadingWait);
        waitForInvisibilityOfElementLocated(loadingWait);
        click(quantidadeProdutoField);
        sendKeys(quantidadeProdutoField,quantidadeProduto);
    }
    public void clicarSalvarProduto(){
        click(salvarProdutoBtn);
    }

    public void clicarFecharLancamento(){
        click(fecharLancamentoBtn);
    }
    public void clicarConfirmarFecharLancamento(){
        click(fecharLancamentoConfirmarBtn);
    }
    public String retornarStatusLancamento(){
        return getText(statusLancamento);
    }

}
