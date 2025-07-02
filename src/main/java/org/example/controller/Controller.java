package org.example.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


import java.util.List;

public class Controller {
 public static void main(String agrs[]) throws InterruptedException {

     WebDriver driver = new ChromeDriver();
     driver.get("https://www.cricbuzz.com/");
     Thread.sleep(2000);
     String mainMenuXpath = "//*[contains(@id, 'cb-main-menu')]/*[contains(@class, 'mnu-itm')]";
     List<WebElement> mainMenuEle = driver.findElements(By.xpath(mainMenuXpath));

     for(WebElement e : mainMenuEle){
         System.out.println(e.getText());
     }


//     String TeamNameXpath = "//td[@class = 'cb-srs-pnts-td text-left']";
//     Actions DropDown = new Actions(driver);
//     DropDown.
//     List<WebElement> teamNames = driver.findElements(By.xpath(TeamNameXpath));
//
//     int size = teamNames.size();
//     System.out.println("size");

    }
}
