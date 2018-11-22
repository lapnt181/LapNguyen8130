package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Constant.Constant;
import Railway.*;
import java.lang.Math;
import java.util.Random;
public class Utilities {

	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}

	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	public static WebElement getElement(By element) {
		return Constant.WEBDRIVER.findElement(element);
	}

	public static String getElementText(By element) {
		return getElement(element).getText();
	}
	
	public static String getRandomString() {
        StringBuilder str = new StringBuilder();
        Random rnd = new Random();
        while (str.length() < 10) 
        { 
            int index = (int) (rnd.nextFloat() * Constant.ALLOWEDCHARS.length());
            str.append(Constant.ALLOWEDCHARS.charAt(index));
        }
        String randomString = str.toString();
        return randomString;
    }
	
	public static String randomEmailGenerator() {
	
		String randomEmail="";
		return randomEmail=getRandomString()+"@mailinator.com";
	}

}
