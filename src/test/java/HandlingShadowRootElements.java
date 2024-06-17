import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingShadowRootElements {

    //elements inside DOM with tag shadow-root are not handled easily by Selenium. We had to use JavaScriptExecuter commands from parent to targetted element.
    //In Playright, it is considered same as normal element.
    public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); 
		Page page = browser.newPage();
		// page.navigate("chrome://downloads/");
		// page.locator("#searchInput").fill("Java");
        
        page.navigate("https://books-pwakit.appspot.com/");
        //input is shadow root element.
		page.locator("#input").fill("Java");
	}
}
