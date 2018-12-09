package com.datadrive.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ExcelUtility.Xls_Reader1;

public class ParametrizeTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Testing\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.co.uk/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='gh-eb-My']/div/a[1]")).click();
		driver.findElement(By.xpath("//*[@id='InLineCreateAnAccount']")).click();
		
		Xls_Reader1 reader = new Xls_Reader1("C:\\Users\\nehal ejazi\\workspace\\AAADec18\\src\\com\\Testdata\\Testdata.xlsx");
        int rowCount = reader.getRowCount("Sheet1");
        for(int i=2;i<=rowCount;i++){
        	String fname = reader.getCellData("Sheet1", "FirstName", i);
        	String sname = reader.getCellData("Sheet1", "Surname", i);
        	String emailid = reader.getCellData("Sheet1", "Email", i);
        	String pass = reader.getCellData("Sheet1", "Password", i);
		
		driver.findElement(By.xpath("//*[@id='firstname']")).clear();
		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(fname);
		driver.findElement(By.xpath("//*[@id='lastname']")).clear();
		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(sname);
		driver.findElement(By.xpath("//*[@id='email']")).clear();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(emailid);
		driver.findElement(By.xpath("//*[@id='PASSWORD']")).clear();
		driver.findElement(By.xpath("//*[@id='PASSWORD']")).sendKeys(pass);
		
//		Xls_Reader1 reader = new Xls_Reader1("C:\\Users\\nehal ejazi\\workspace\\AAADec18\\src\\com\\Testdata\\Logindata.xlsx");
//		int rowCount = reader.getRowCount("Data");
//		for(int i=2;i<=rowCount;i++){
//		System.out.println(reader.getCellData("Data", "Password", i));
		
		
		
		}
	}
}


