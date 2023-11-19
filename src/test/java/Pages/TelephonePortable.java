package Pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.Config;

public class TelephonePortable {

	@FindBy (xpath= "/html/body/div[2]/main/div[4]/div[1]/div[3]/ol/li/div/div[2]/div/strong/a")
	List <WebElement> Products;	
	@FindBy (xpath= "/html/body/div[2]/main/div[2]/div[1]/div[1]/div[3]/div[1]/span")
	WebElement avaibility;
	@FindBy (xpath= "/html/body/div[2]/main/div[2]/div[2]/div[2]/form/div/div/div[2]/button/span")
	WebElement commander;
	@FindBy (xpath= "/html/body/div[2]/main/div[2]/div[2]/div[2]/form/div/div/div[2]/button")
	WebElement ajout;
	@FindBy (xpath= "/html/body/div[2]/header/div[2]/div[1]/div/div/div/div[2]/div[4]/ol/li/div/div/strong")
	WebElement verifProduit;
	
	public TelephonePortable (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		public void ajoutProduitPanier(String ProductTitle) {
			try {
			for (WebElement Product: Products) {
				if (Product.getText().contains(ProductTitle)) {
					Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Product.click();
					
					Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Assert.assertTrue(avaibility.getText().equals("En stock"));
					commander.click();
					
					WebDriverWait wait = new WebDriverWait (Config.driver, Duration.ofSeconds(10));
					wait.until (ExpectedConditions.elementToBeClickable(ajout));
					ajout.click();
					
					Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					
	Assert.assertTrue(verifProduit.getText().contains(ProductTitle));

				}
				
			}
			} catch (Exception e) {
				
			}
			
		}
	}
