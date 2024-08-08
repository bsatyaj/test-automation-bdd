package pages;

import utils.WebDriverUtils;

public class Home {
    String signupOrLoginLink = "//a[text()=' Signup / Login']";

    public void navigateToLoginPage() {
        WebDriverUtils.findByXpath(signupOrLoginLink).click();
    }
}
