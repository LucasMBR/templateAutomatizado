package com.javaseleniumtemplate.bases;

import com.javaseleniumtemplate.GlobalParameters;
import com.javaseleniumtemplate.utils.DriverFactory;
import com.javaseleniumtemplate.utils.ExtentReportUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.apache.commons.lang3.time.StopWatch;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;

public class PageBase {
    //Variaveis globlais
    protected WebDriverWait wait = null;
    protected WebDriver driver = null;
    protected JavascriptExecutor javaScriptExecutor = null;
    protected Wait<WebDriver> waitFluent = null;

    //Construtor
    public PageBase(){
        wait = new WebDriverWait (DriverFactory.INSTANCE, GlobalParameters.TIMEOUT_DEFAULT);
        driver = DriverFactory.INSTANCE;
        waitFluent = new FluentWait<WebDriver>(DriverFactory.INSTANCE)
                .withTimeout(Duration.ofSeconds(GlobalParameters.TIMEOUT_DEFAULT))
                .pollingEvery(Duration.ofSeconds(GlobalParameters.TIMEOUT_POLLING_DEFAULT))
                .ignoring(Exception.class);
        javaScriptExecutor = (JavascriptExecutor) driver;
    }

    //Custom Actions
    private void waitUntilPageReady(){
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= GlobalParameters.TIMEOUT_DEFAULT)
        {
            String documentState = javaScriptExecutor.executeScript("return document.readyState").toString();
            if (documentState.equals("complete")){
                timeOut.stop();
                break;
            }
        }
    }

    protected WebElement waitForElement(By locator){
        waitUntilPageReady();
        waitFluent.until(ExpectedConditions.elementToBeClickable(locator));
        waitFluent.until(ExpectedConditions.presenceOfElementLocated(locator));
        waitFluent.until(ExpectedConditions.visibilityOfElementLocated(locator));

        WebElement element = driver.findElement(locator);
        waitFluent.until(ExpectedConditions.visibilityOf(element));
        waitFluent.until(ExpectedConditions.elementToBeClickable(element));

        return element;
    }

    protected WebElement waitForElementWithoutClickable(By locator){
        waitUntilPageReady();
        //wait2();
        //wait.until(ExpectedConditions.elementToBeClickable(locator));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(locator));


        WebElement element = driver.findElement(locator);
        //wait.until(ExpectedConditions.visibilityOf(element));
        //wait.until(ExpectedConditions.elementToBeClickable(element));


        return element;
    }

    protected WebElement waitForElementByTime(By locator, int time){
        waitUntilPageReady();
        WebDriverWait waitTime = new WebDriverWait(driver, time);
        waitTime.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        waitTime.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    protected WebElement waitForElementDisabled(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        return element;
    }

    //Função usada para acessar os elementos que estão dentro de um #shadow-root
    //Ex:  WebElement root = driver.findElement(By.tagName("driver-app-shell"))---> elemento onde se encontra o shadow-root
    //     WebElement shadowRoot = expandShadowRootElement(root); ----> pegando os elementos que estão dentro do shadow-root
    protected WebElement expandShadowRootElement(By locator) {
        WebElement shadowRootElement = (WebElement) javaScriptExecutor.executeScript("return arguments[0].shadowRoot", waitForElementWithoutClickable(locator));
        return shadowRootElement;
    }

    protected void click(By locator){
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= GlobalParameters.TIMEOUT_DEFAULT)
        {
            WebElement element = null;

            try
            {
                element = waitForElement(locator);
                element.click();
                timeOut.stop();
                ExtentReportUtils.addTestInfo(3, "");
                return;
            }

            catch (StaleElementReferenceException e)
            {
                continue;
            }

            catch (WebDriverException e)
            {
                possibleWebDriverException = e;
                if (e.getMessage().contains("Other element would receive the click"))
                {
                    //continue;
                }

                throw e;
            }
        }

        try {
            throw new Exception(possibleWebDriverException);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void clickWithoutClickable(By locator){
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= GlobalParameters.TIMEOUT_DEFAULT)
        {
            WebElement element = null;

            try
            {
                element = waitForElementWithoutClickable(locator);
                element.click();
                timeOut.stop();
                ExtentReportUtils.addTestInfo(3, "");
                return;
            }

            catch (StaleElementReferenceException e)
            {
                continue;
            }

            catch (WebDriverException e)
            {
                possibleWebDriverException = e;
                if (e.getMessage().contains("Other element would receive the click"))
                {
                    continue;
                }

                throw e;
            }
        }

        try {
            throw new Exception(possibleWebDriverException);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void clickWithText(By locator,String text){
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();
        String loc = locator.toString().replace("texto",text).replace("By.xpath: ","");
        locator = By.xpath(loc);

        while (timeOut.getTime() <= GlobalParameters.TIMEOUT_DEFAULT)
        {
            WebElement element = null;

            try
            {
                //String loc = locator.toString().replace("texto",text).replace(" By.xpath: ","");
                //locator = new By.ByXPath(loc);
                element = waitForElementWithoutClickable(locator);
                element.click();
                timeOut.stop();
                ExtentReportUtils.addTestInfo(3, "");
                return;
            }

            catch (StaleElementReferenceException e)
            {
                continue;
            }

            catch (WebDriverException e)
            {
                possibleWebDriverException = e;
                if (e.getMessage().contains("Other element would receive the click"))
                {
                    //continue;
                }

                throw e;
            }
        }

        try {
            throw new Exception(possibleWebDriverException);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void sendKeys(By locator, String text){
        waitForElement(locator).sendKeys(text);
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
    }

    protected void sendKeysWithoutWaitVisible(By locator, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
    }

    protected void clear(By locator){
        WebElement webElement = waitForElement(locator);
        webElement.clear();
    }

    protected void clearAndSendKeys(By locator, String text){
        WebElement webElement = waitForElement(locator);
        webElement.sendKeys(Keys.CONTROL + "a");
        webElement.sendKeys(Keys.DELETE);
        webElement.sendKeys(text);
    }

    protected void comboBoxSelectByVisibleText(By locator, String text){
        Select comboBox = new Select(waitForElementWithoutClickable(locator));
        comboBox.selectByVisibleText(text);
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
    }

    protected void comboBoxSelectByValue(By locator, String text){
        Select comboBox = new Select(waitForElementWithoutClickable(locator));
        comboBox.selectByValue(text);
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
    }

    protected void mouseOver(By locator){
        Actions action = new Actions(driver);
        action.moveToElement(waitForElement(locator)).build().perform();
        ExtentReportUtils.addTestInfo(3, "");
    }

    protected String getText(By locator){
        String text = waitForElement(locator).getText();
        ExtentReportUtils.addTestInfo(3, "RETURN: " + text);
        return text;
    }

    protected String getValue(By locator){
        String text = waitForElement(locator).getAttribute("value");
        ExtentReportUtils.addTestInfo(3, "RETURN: " + text);
        return text;
    }

    protected boolean returnIfElementIsDisplayed(By locator){
        boolean result = waitForElement(locator).isDisplayed();
        ExtentReportUtils.addTestInfo(3, "RETURN: " + result);
        return result;
    }

    protected boolean returnIfElementExists(By locator){
        boolean result = false;

        try
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            result = true;
        }
        catch (Exception e)
        {

        }
        ExtentReportUtils.addTestInfo(3, "RETURN: " + result);
        return result;
    }


    protected boolean returnIfElementIsEnabled(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        boolean result = driver.findElement(locator).isEnabled();
        ExtentReportUtils.addTestInfo(3, "RETURN: " + result);
        return result;
    }

    protected boolean returnIfElementIsSelected(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        boolean result = driver.findElement(locator).isSelected();
        ExtentReportUtils.addTestInfo(3, "RETURN: " + result);
        return result;
    }

    //Javascrip actions
    protected void SendKeysJavaScript(By locator, String value){
        WebElement element = waitForElementWithoutClickable(locator);
        javaScriptExecutor.executeScript("arguments[0].value='" + value + "';", element);
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + value);
    }

    protected void ClickJavaScript(By locator){
        WebElement element = waitForElementWithoutClickable(locator);
        javaScriptExecutor.executeScript("arguments[0].click();", element);
        ExtentReportUtils.addTestInfo(3, "");
    }

    protected void ScrollToElementJavaScript(By locator){
        WebElement element = waitForElement(locator);
        javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        ExtentReportUtils.addTestInfo(3, "");
    }

    protected void ScrollToTop(){
        javaScriptExecutor.executeScript("window.scrollTo(0, 0);");
        ExtentReportUtils.addTestInfo(3, "");
    }

    //Default actions
    public void refresh(){
        DriverFactory.INSTANCE.navigate().refresh();
        ExtentReportUtils.addTestInfo(2, "");
    }

    public void navigateTo(String url){
        DriverFactory.INSTANCE.navigate().to(url);
        ExtentReportUtils.addTestInfo(2, "PARAMETER: " + url);
    }

    public void openNewTab(){
        javaScriptExecutor.executeScript("window.open();");
        ExtentReportUtils.addTestInfo(2, "");
    }
    public void closeTab(){
        driver.close();
        ExtentReportUtils.addTestInfo(2, "");
    }

    public String getTitle(){
        String title = driver.getTitle();
        ExtentReportUtils.addTestInfo(2, "");
        return title;
    }

    public String getURL(){
        String url = driver.getCurrentUrl();
        ExtentReportUtils.addTestInfo(2, "");
        return url;
    }

    public void wait2(){
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)javaScriptExecutor.executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return javaScriptExecutor.executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        wait.until(jQueryLoad);
        wait.until(jsLoad);
    }

    protected WebElement waitForVisibilityOfElementLocated(By locator) {
        waitUntilPageReady();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        return element;
    }

    protected void waitForInvisibilityOfElementLocated(By locator) {
        waitUntilPageReady();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }


}
