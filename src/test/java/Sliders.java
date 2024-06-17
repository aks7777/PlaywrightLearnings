import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Sliders {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://jqueryui.com/resources/demos/slider/default.html");

        //slider.
        Locator slider = page.locator("#slider > span");
        page.mouse().move(slider.boundingBox().x + slider.boundingBox().width/2, slider.boundingBox().y + slider.boundingBox().height/2);

        page.mouse().down();
        Thread.sleep(3000);
        page.mouse().move(slider.boundingBox().x + 500, slider.boundingBox().y + slider.boundingBox().height/2);
        page.mouse().up();
        
        Thread.sleep(5000);
        page.close();
        browser.close();
        playwright.close();
    }
}
