package org.example.crickbuzz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class position {
    public static void main(String [] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cricbuzz.com/");
        int maxPoint = 0;
        String topTeam = "";
        Thread.sleep(2000);

        String mainMenuXpath = "//*[contains(@id, 'cb-main-menu')]/*[contains(@class, 'mnu-itm')]";
        List<WebElement> mainMenuEle = driver.findElements(By.xpath(mainMenuXpath));
        //Enter menu value
        String targetMenu = "More";
        Actions actions = new Actions(driver);
        for(WebElement e : mainMenuEle) {
            String MainMenu = e.getText().trim();
//            System.out.println(MainMenu);
            if(MainMenu.equalsIgnoreCase(targetMenu)){
                System.out.println("Menu name is : "+ MainMenu);
                actions.moveToElement(e).perform();
                Thread.sleep(3000);
                //Enter value for list item
                String targetListVal = "World Test Championship";
                String MenuListXapth = "//nav[@id = 'cb-main-menu']//nav[@class = 'cb-sub-navigation']//a[@class = 'cb-subnav-item' and contains(@href , '/')]";
                List<WebElement> menuListEle = driver.findElements(By.xpath(MenuListXapth));
                for(WebElement el : menuListEle) {
                    String listVal = el.getText().trim();
//                    System.out.println(el.getText());
                    if (listVal.equalsIgnoreCase(targetListVal)) {
                        System.out.println("List value is: " + listVal);
                        el.click();
                        Thread.sleep(2000);
                        break;
                    }
                }
                    //Table heading
                    String targetTableHead1 = "Team";
                    String targetTableHead2 = "Points";
                    String tableHeadXpath = "//thead/tr/td";
                    int teamIdx = 0, pointIdx = 0;
                    int pos = 1;
                    List<WebElement> tableHead = driver.findElements(By.xpath(tableHeadXpath));
                    for(WebElement tel : tableHead){
//                        System.out.println(tel.getText());
                        String elListVal = tel.getText().trim();
                        if(elListVal.equalsIgnoreCase(targetTableHead1)) {
                            teamIdx = pos;
                            System.out.println("Index of team name in table " + teamIdx);
                        }
                        if(elListVal.equalsIgnoreCase(targetTableHead2)) {
                            pointIdx = pos;
                            System.out.println("Index of points in table " + pointIdx);
                        }
                        pos++;
                    }
                    //Table Body
                    String tblBodyXpath = "//tbody/tr";
                    List<WebElement> tblBody = driver.findElements(By.xpath(tblBodyXpath));

                    for(WebElement tel : tblBody) {
//                        System.out.println(tel.getText());
                        String teamName = tel.findElement(By.xpath("./td[" + teamIdx + "]")).getText();
                        String pointVal = tel.findElement(By.xpath("./td[" + pointIdx + "]")).getText();

                        String points = tel.getText();
                        int mp = Integer.valueOf(pointVal);
                        if (mp > maxPoint) {
                            maxPoint = mp;
                            topTeam = teamName;
                        }
                    }
            }

        }

        System.out.println("Team which has highest point is " + topTeam + " with points: " + maxPoint);
        driver.close();

    }
}
