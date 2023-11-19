package TestSuites;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import Helper.Config;
import Pages.HomePage;

public class HomePageTestSuite {
HomePage home;
	@Before
	public void init () {
		Config.confChrome();
		Config.driver= new ChromeDriver ();
		String url= "https://www.mytek.tn/";
		Config.driver.get(url);
		Config.maximizeWindow();
		home= new HomePage(Config.driver);
	}
	@Test
	public void mouseHover() {
		home.mouseHover("TELEPHONIE & MONTRE CONNECTÉE", "Téléphone Portable");
	}
	
}
