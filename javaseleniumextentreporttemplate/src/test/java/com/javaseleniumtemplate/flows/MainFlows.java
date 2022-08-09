package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.LoginPage;
import com.javaseleniumtemplate.pages.MainPage;

public class MainFlows {

    MainPage mainPage;

    public MainFlows(){
        mainPage = new MainPage();
    }

    public void navegarParaLancamentoDeSaida(){
        mainPage.clicarEmMenuPrincipal();
        mainPage.clicarEmDocumentosFiscais();
        mainPage.clicarEmDocumentosFiscaisSaidas();
        mainPage.clicarEmDocumentosFiscaisSaidasLancamentos();
        mainPage.clicarEmDocumentosFiscaisSaidasLancamentosLancamentoDeSaida();
    }
}
