package TestSuites;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import Helper.Config;
import Pages.TelephonePortable;

public class TelephonePortableTestSuites {

	TelephonePortable telephonePortable;
	@Before
	public void init() throws InterruptedException {
		Config.confChrome();
		Config.driver = new ChromeDriver();
		String url ="https://www.mytek.tn/telephonie-tunisie/smartphone-mobile-tunisie/telephone-portable.html";
		Config.driver.get(url);
		Config.maximizeWindow();
		telephonePortable = new TelephonePortable(Config.driver);	
		Thread.sleep(5000);
	}
	@Test
	public void ajoutProduitPanier( ) {
		telephonePortable.ajoutProduitPanier("Téléphone Portable AMI C14 Venise - Rouge");
	}
}