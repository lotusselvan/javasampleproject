package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Hey {
	
	@Test
		public void testchoice() { 
		WebDriver data=new ChromeDriver();
		data.get("https://omrbranch.com/apitestingtraininginchennaiomr");
		data.manage().window().maximize();
		
		WebElement fname = data.findElement(By.id("first_name"));
		fname.sendKeys("thamarai");
		String nn = fname.getAttribute("value");
		System.out.println("First name:"+nn);
		
		
		WebElement lname = data.findElement(By.id("last_name"));
		lname.sendKeys("selvan");
		String lsname = lname.getAttribute("value");
		System.out.println("Last name:"+lsname);
			
		WebElement add = data.findElement(By.xpath("/html/body/div[2]/section/div/div/div[1]/form/div[2]/div[2]/div/textarea"));
		add.sendKeys("Erode,Kongampalayam.-638005.");
		String address = add.getAttribute("value");
		System.out.println("Adderss :"+address);		
		
		
		WebElement email = data.findElement(By.id("email"));
		email.sendKeys("thamarai@gmail.com");
		String mail = email.getAttribute("value");
		System.out.println("Email id:"+mail);
		
		WebElement phno = data.findElement(By.id("phone"));
		phno.sendKeys("9876543210");
		String phoneno = phno.getAttribute("value");
		System.out.println("Phone NO:"+phoneno);
		
		WebElement mal = data.findElement(By.id("male"));
		mal.click();
		boolean checkmale = mal.isSelected();
		System.out.println("checkbox for male:"+checkmale);
		
		WebElement hob = data.findElement(By.id("checkbox-cricket"));
		hob.click();
		boolean hobbies = hob.isSelected();
		System.out.println("hobies1 cricket:"+hobbies);
	
		
		WebElement cr = data.findElement(By.id("checkbox-hockey"));
		cr.click();
		boolean games = cr.isSelected();
		System.out.println("Hobies3 hockey:"+games);
				
		
		WebElement pass = data.findElement(By.id("password"));
		pass.sendKeys("Lotus@123");
		String password = pass.getAttribute("value");
		System.out.println("password :"+password); 
		
		WebElement conpas = data.findElement(By.id("confirm-password"));
		conpas.sendKeys("Lotus@123");
		String conformpass = conpas.getAttribute("value");
		System.out.println("Conform Password :"+conformpass);
		
		WebElement sub = data.findElement(By.id("submitbtn"));
		sub.click();
		
		}
	

}



