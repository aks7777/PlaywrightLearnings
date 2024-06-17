import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Screenshots {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://www.google.com");
	
        page.locator("body > div.L3eUgb > div.o3j99.LLD4me.yr19Zb.LS8OJ > div > img").click(new ClickOptions().setTimeout(60000)); //default timeout is 30 secs.
        //Page screenshot.
        // page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./playwright-practise/src/main/resources/screenshots/screenshot.png")));
        
        Thread.sleep(5000);
        //Element screenshot.
        page.locator("body > div.L3eUgb > div.o3j99.LLD4me.yr19Zb.LS8OJ > div > img").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./playwright-practise/src/main/resources/screenshots/screenshot_element.png")));
       
        page.close();
        browser.close();
        playwright.close();
    }
}
