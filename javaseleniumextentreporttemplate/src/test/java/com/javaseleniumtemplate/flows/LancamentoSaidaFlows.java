package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.LancamentoSaidaPage;

public class LancamentoSaidaFlows {
    LancamentoSaidaPage lancamentoSaidaPage;

    public LancamentoSaidaFlows(){
        lancamentoSaidaPage = new LancamentoSaidaPage();
    }

    public void aplicarFiltro(String status, String unidade, String remetente, String serie){
        lancamentoSaidaPage.preencherFiltroStatus(status);
        lancamentoSaidaPage.preencherFiltroUnidade(unidade);
        //lancamentoSaidaPage.preencherFiltroEmpresa(empresa);
        lancamentoSaidaPage.preencherFiltroRemetente(remetente);
        //lancamentoSaidaPage.preencherFiltroDestinario(destinatario);
        lancamentoSaidaPage.preencherFiltroSerie(serie);
        //lancamentoSaidaPage.preencherFiltroDataEmissaoInicial(dataEmissaoInicial);
        //lancamentoSaidaPage.preencherFiltroDataEmissaoFinal(dataEmissaoFinal);
        //lancamentoSaidaPage.preencherFiltroDataSaidaInicial(dataSaidaInicial);
        //lancamentoSaidaPage.preencherFiltroDataSaidaFinal(dataSaidaFinal);
        //lancamentoSaidaPage.preencherFiltroOperacao(operacao);
        lancamentoSaidaPage.clicarAplicarFiltro();
    }
}
