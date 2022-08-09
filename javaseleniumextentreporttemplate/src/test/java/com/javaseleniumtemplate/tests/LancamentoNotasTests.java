package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LancamentoSaidaFlows;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.flows.MainFlows;
import com.javaseleniumtemplate.pages.LancamentoSaidaPage;
import com.javaseleniumtemplate.pages.LoginPage;
import com.javaseleniumtemplate.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LancamentoNotasTests extends TestBase {

    MainPage mainPage;
    LoginFlows loginFlows;
    MainFlows mainFlows;
    LancamentoSaidaFlows lancamentoSaidaFlows;
    LancamentoSaidaPage lancamentoSaidaPage;

    @Test
    public void efetuarLancamentoNotaComSucesso(){
        //Objects instances
        mainPage = new MainPage();

        loginFlows = new LoginFlows();
        mainFlows = new MainFlows();
        lancamentoSaidaFlows = new LancamentoSaidaFlows();
        lancamentoSaidaPage = new LancamentoSaidaPage();

        //Parameteres
        String usuario = "teknisa@hela.com.br";
        String senha = "01051990";

        String status = "Todos";
        String unidade = "HELA INGREDIENTES BRASIL";
        String remetente = "Todos";
        String destinatario = "Alibra Ingredientes Ltda";
        String serie = "SERIE 1";
        String operacao = "NF Cobrança";
        String modeloDocumentoFiscal = "Nota Fiscal Eletrônica";
        String serieFormulario = "Série 142";
        String dataSaida = "16/08/2021";

        String nomeProduto = "Hela Poultry Broth Paste Clear KG";
        String quantidadeProduto = "1";
        String statusEsperado = "Pendente";

        loginFlows.efetuarLogin(usuario,senha);
        mainFlows.navegarParaLancamentoDeSaida();
        lancamentoSaidaFlows.aplicarFiltro(status,unidade,remetente,serie);

        lancamentoSaidaPage.clicarAdicionarLancamento();

        //criando lancamento
        lancamentoSaidaPage.preencherUnidade(unidade);
        lancamentoSaidaPage.preencherOperacao(operacao);
        lancamentoSaidaPage.preencherDocumentoFiscal(modeloDocumentoFiscal);
        lancamentoSaidaPage.clicarPesquisaDestinatario();
        lancamentoSaidaPage.preencherDestinatario(destinatario);
        lancamentoSaidaPage.clicarEscolherDestinatario();
        lancamentoSaidaPage.clicarPesquisaSerie();
        lancamentoSaidaPage.preencherSerie(serieFormulario);
        lancamentoSaidaPage.clicarEscolherSerie(serieFormulario);
        lancamentoSaidaPage.preencherDataSaida(dataSaida);
        lancamentoSaidaPage.salvarLancamento();

        //adicionando produto
        lancamentoSaidaPage.clicarMenuProdutos();
        lancamentoSaidaPage.clicarAdicionarProduto();
        lancamentoSaidaPage.clicarPesquisaProduto();
        lancamentoSaidaPage.preencherNomeProduto(nomeProduto);
        lancamentoSaidaPage.clicarEscolherProduto();
        lancamentoSaidaPage.clicarPesquisaLoteProduto();
        lancamentoSaidaPage.clicarEscolherLoteProduto();
        lancamentoSaidaPage.clicarConfirmarProduto();
        lancamentoSaidaPage.preencherQuantidadeProduto(quantidadeProduto);
        lancamentoSaidaPage.clicarSalvarProduto();

        //finalizar lancamento
        lancamentoSaidaPage.clicarFecharLancamento();
        lancamentoSaidaPage.clicarConfirmarFecharLancamento();

        String statusAtual = lancamentoSaidaPage.retornarStatusLancamento();

        Assert.assertEquals(statusAtual,statusEsperado);
    }
}
