package com.openCart.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.itextpdf.text.DocumentException;
import com.openCart.Base.BaseClass;
import com.openCart.utilities.Xls_Reader;

public class TC_DD_Login_003 extends BaseClass {


	@Test
	public void loginTest() throws InterruptedException, IOException, DocumentException {

		driver.get(baseUrl);
		Thread.sleep(3000);

		WebElement Setting=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
		WebElement Login=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		Setting.click();
		Login.click();

		//Excel implementation
		Xls_Reader reader=new Xls_Reader("./src/test/java/com/opencart/testdata/LoginData.xlsx");
		String sheetName= "Sheet1";

		int rowCount=reader.getRowCount(sheetName);

		for(int rowNum=2; rowNum<=rowCount; rowNum++) {
			String email=reader.getCellData(sheetName, "Email", rowNum);
			String password=reader.getCellData(sheetName, "password", rowNum);

			//Login
			WebElement Email_field=driver.findElement(By.name("email"));
			WebElement password_field=driver.findElement(By.name("password"));

			WebElement Login_btn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

			Email_field.clear();
			Email_field.sendKeys(email);
			Thread.sleep(2000);

			password_field.clear();
			password_field.sendKeys(password);
			Thread.sleep(2000);

			Login_btn.click();
			
			String exp_title="Account Login";
			String act_title=driver.getTitle();
			
			if(exp_title.equals(act_title)) {
				reader.setCellData(sheetName, "Result", rowNum, "Tiger");
			}
			
			else {
				reader.setCellData(sheetName, "Result", rowNum, "Lion");
			}
		//	reader.setCellData(sheetName, "Result", rowNum, "Pass");
			
			PdfGenarate(driver,"newpdf");
			
		}

	}
}
