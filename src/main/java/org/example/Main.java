package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DecimalFormat;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver() ;// Placeholder for WebDriver initialization
        // In a real application, you would configure the WebDriver and perform actions on a web page.
        driver.get("https://www.amazon.in/");
        //A obj = new b();// Navigate to a web page
        String page = driver.getPageSource();
        //System.out.println(page);
        String currentUrl = driver.getCurrentUrl();
        //System.out.println("Current URL: " + currentUrl);
        String title = driver.getTitle();
        //System.out.println("Page Title: " + title);
        String WindowHandle = driver.getWindowHandle();
        //System.out.println("Window Handle: " + WindowHandle);
//        WebElement item = driver.findElement(By.xpath("//div[@id='nav-xshop']"));
//        WebElement item1 = driver.findElement(By.xpath("//span[contains(text(),'Account & Lists')]"));

        //span[@class = 'a-size-base a-color-base puis-bold-weight-text']  for
//        System.out.println(item.getAttribute("class"));
//        System.out.println(item1.getAttribute("class"));
//        System.out.println(item1.getTagName());
//        String cssValue = item1.getCssValue("color");
//        System.out.println("CSS Value: " + cssValue);
//        System.out.println("position:" + item1.getSize());
//        System.out.println("Location:" + item1.getLocation());
//        System.out.println("Rectangle:" + item1.getRect());
        String searchBoxXpath = "//input[@placeholder = 'Search Amazon.in' and @id = 'twotabsearchtextbox']";
        String submitSearchXpath = "//input[@type = 'submit' and @id = 'nav-search-submit-button']";
        String priceListxpath = "//div[@role = 'listitem']//span[contains(@class,'a-price-whole')]";
        String val = "000";
        String productNameListXpath = "//span[contains(text(), '"+val+"')]//ancestor::div[contains(@class,'puisg-row puis-desktop-list-row')]//preceding-sibling::div[contains(@data-cy, 'title-recipe')]//a/h2/span";

        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.xpath(searchBoxXpath));
        searchBox.sendKeys("television");
        Thread.sleep(2000);
        WebElement submitSearch = driver.findElement(By.xpath(submitSearchXpath));
        submitSearch.click();
        Thread.sleep(2000);

        // Find all product names and prices
        List<WebElement> priceElements = driver.findElements(By.xpath(priceListxpath));
        int maxPrice = 0;
        String FinalMaxPrice = "";
        for(WebElement e : priceElements){
            String price = e.getText();
            String valueItem = price.replace(",","");
            int n = Integer.valueOf(valueItem);
            if(n > maxPrice){
                FinalMaxPrice = price;
                maxPrice = n;
            }
        }
    //12,000
//        DecimalFormat formatter = new DecimalFormat("##,##,###");
//        String maxPriceString = formatter.format(maxPrice);
        String Finalxpath = productNameListXpath.replace(val, FinalMaxPrice);

        WebElement MaxProductNameEle = driver.findElement(By.xpath(Finalxpath));
        String result = MaxProductNameEle.getText();
        System.out.println("Product with maximum price: " + result + " with price: " + FinalMaxPrice);



    }
}