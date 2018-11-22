package Common;

import Railway.*;

public class Utilities {

	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}

	public static LoginPage initLoginPage() {
		HomePage homePage = new HomePage();
		homePage.open();
		LoginPage loginPage = homePage.gotoLoginPage();
		return loginPage;
	}
}
