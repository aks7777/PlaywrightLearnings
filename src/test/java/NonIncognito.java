import java.nio.file.Paths;
import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NonIncognito {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            BrowserContext browserContext = playwright.chromium().launchPersistentContext(
               Paths.get(""), new BrowserType.LaunchPersistentContextOptions().setHeadless(false));
           
            // Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50).setArgs(arguments));
        //    BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

           Page page = browserContext.newPage();
           page.navigate("http://playwright.dev");
           System.out.println("Aniel : " + page.title());
           Thread.sleep(3000);
           page.close();
        //    browser.close();
           playwright.close();
       }
   }
}
