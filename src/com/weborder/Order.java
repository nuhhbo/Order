package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Order {
public static void main(String[] args) {

	System.setProperty("webdriver.chrome.driver",
					"/Users/nuhhacibektasoglu/Documents/selenium dependencies/drivers/chromedriver");
	
	WebDriver driver = new ChromeDriver();
	driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	
	Random rd = new Random();
	
	
	driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
	driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
	driver.findElement(By.name("ctl00$MainContent$login_button")).click();
	driver.findElement(By.linkText("Order")).click();
	
	int i = rd.nextInt(99);
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(i+1+"");
	
	char midName=(char)(rd.nextInt(26)+65);
    String name="John "+midName+" Smith";
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(name);
	
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Anytown");
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia");
	
	String zip="";
	for (int k = 0; k <5; k++) {
		zip+=rd.nextInt(10);	
	}
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(zip);
	
	WebElement visa=driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
	WebElement master=driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1"));
	WebElement amex=driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2"));
	WebElement cardN=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
	String cardNumber="";
	
	int card=rd.nextInt(2);
	
		switch(card) {
		case 0:
			visa.click();
			for (int i1 = 0; i1 < 15; i1++) {
				int visaN=rd.nextInt(10);
				cardNumber+=visaN;
			}
			cardNumber="4"+cardNumber;
			cardN.sendKeys(cardNumber);
			break;
			
		case 1:
			master.click();
			for (int i2 = 0; i2 < 16; i2++) {
				int masterN=rd.nextInt(10);
				cardNumber+=masterN;
			}
			cardNumber="5"+cardNumber;
			cardN.sendKeys(cardNumber);
			break;
		case 2:
			amex.click();
			for (int i3 = 0; i3 < 14; i3++) {
				int amexN=rd.nextInt(10);
				cardNumber+=amexN;
			}
			cardNumber="3"+cardNumber;
			cardN.sendKeys(cardNumber);
			break;
		}
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("11/22");
		
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

		WebElement verify=driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong"));
		if(verify.getText().contains("New order has been successfully added.")) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		



	
}
	
}
