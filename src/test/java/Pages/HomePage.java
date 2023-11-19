package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helper.Config;

public class HomePage {
	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/div/nav/ul/li[1]/a")
	WebElement tousNosRayons;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/div/nav/ul/li[1]/div/ul/li/a")
	List<WebElement> menus;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/div/nav/ul/li[1]/div/ul/li[3]/div/div/div[2]/ul/li[3]/a/span")
	List<WebElement> submenus;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void mouseHover(String menuTitle, String subMenuT) {

		Config.action = new Actions(Config.driver);
		Config.action.moveToElement(tousNosRayons).perform();

		for (WebElement menu : menus) {

			if (menu.getText().contains(menuTitle)) {
            menu.click();

			}
			Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Config.action = new Actions(Config.driver);
			Config.action.moveToElement(menu).perform();
			Config.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		}

	}

}
