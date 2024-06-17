import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestFrames {
    
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		// body > button


        //click on Try it button but it is in IFRAME and hence error.
        // page.locator("body > button").click(new ClickOptions().setTimeout(2000)); //default timeout is 30 secs.
        //locate frame first.
        FrameLocator frameLocator = page.frameLocator("[id='iframeResult']");
        frameLocator.locator("body > button").click(new ClickOptions().setTimeout(60000)); //default timeout is 30 secs.

        Thread.sleep(5000);

        //Total frames count.
        Locator frames = page.locator("iframe");
		System.out.println(frames.count());
		
        //id of each frame.
		for(int i=0; i<frames.count(); i++) {
			
			System.out.println(frames.nth(i).getAttribute("id"));
			
		}
        Thread.sleep(5000);
        page.close();
        browser.close();
        playwright.close();
    }
}
