import java.nio.file.Paths;
import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VideoRecord {
    public static void main(String[] args) throws InterruptedException {
         try (Playwright playwright = Playwright.create()) {
           
            ArrayList<String> arguments = new ArrayList<>();
    		arguments.add("--start-maximized");
            
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50).setArgs(arguments));
            BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null).setRecordVideoDir(Paths.get("./playwright-practise/src/main/resources/files/recordings/")));

            Page page = browserContext.newPage();
            page.navigate("http://playwright.dev");
            System.out.println("Aniel : " + page.title());
            
            Thread.sleep(3000);
            page.navigate("http://google.com");
            Thread.sleep(3000);
            page.goBack();
            Thread.sleep(3000);
            page.goForward();
            Thread.sleep(3000);
            page.reload(); //reload last url - google.com.

            page.close();
            browserContext.close(); //must for video recording to complete.
            browser.close();
            playwright.close();
        }
    }
}
