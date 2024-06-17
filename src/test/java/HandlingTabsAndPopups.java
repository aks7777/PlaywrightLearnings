import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingTabsAndPopups {
    
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://sso.teachable.com/secure/673/identity/sign_up/email");

        //The main page opens up a new tab and we need handle for this tab.
        //lambda/callback expression/function is the parameter.
        Page newTab = page.waitForPopup(() -> {
            page.locator("text=Privacy Policy").nth(0).click();
        });

        newTab.locator("[id='header-sign-up-btn']").click();
        System.out.println("New tab title : " + newTab.title());

		Thread.sleep(2000);

        newTab.close();
        Thread.sleep(2000);
        page.close();
        browser.close();
        playwright.close();
    }
}