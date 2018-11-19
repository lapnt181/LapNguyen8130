package Railway;
import Constant.Constant;
public class HomePage extends GeneralPage {
//Locators

//Element

//Methods

	public HomePage open() {
		Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
		return this;
	}
}
