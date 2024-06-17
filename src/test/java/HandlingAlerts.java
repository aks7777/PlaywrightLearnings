import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingAlerts {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://mail.rediff.com/cgi-bin/login.cgi");
		
        //Alerts can come any time and cannot have locators. page.onDialog() method with accept, dismiss, message etc is supported.
        //lambda expression/function is the parameter.
        page.onDialog(dialog -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dialog.accept();
            System.out.println(dialog.message());
        });
        page.locator("[type='submit']").click();;

        Thread.sleep(5000);

        page.close();
        browser.close();
        playwright.close();
    }
}
