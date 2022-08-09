package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase {
    //Mapping
    By usernameField = By.id("USER");
    By passwordField = By.id("PASSWORD");
    By loginButton = By.id("SUBMIT");
    By mensagemErroTextArea = By.xpath("//*[@class='zh-text-alert']");
    By mensagemAlert = By.xpath("//*[@class='zh-alert-button horizontal'][1]");
    By mensagemAlert2 = By.xpath("//*[@class='zh-alert-button']");

    By loadingWait = By.xpath("//*[@class='zh-background-loading ng-scope']//span[@class='zh-loading-icon']");

    //Actions
    public void preenhcerUsuario(String usuario){
        //click(usernameField);
        sendKeys(usernameField, usuario);
    }

    public void preencherSenha(String senha){
        sendKeys(passwordField, senha);
    }

    public void clicarEmLogin(){
        //waitForVisibilityOfElementLocated(loadingWait);
        //waitForInvisibilityOfElementLocated(loadingWait);
        click(loginButton);
    }

    public void aceitarMensagemAlerta(){
        click(mensagemAlert);
    }

    public void aceitarMensagemAlerta2(){
        click(mensagemAlert2);
    }

    public String retornaMensagemDeErro(){
        return getText(mensagemErroTextArea);
    }
}
