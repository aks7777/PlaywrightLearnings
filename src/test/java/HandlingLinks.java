import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingLinks {
    public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://www.wikipedia.org/");
		
        Locator links = page.locator("a");
        System.out.println(links.count());

        for (int i = 0; i < links.count(); i++)
        {
            // System.out.println("Link : " + links.nth(i).getAttribute("href"));
            System.out.println("Link : " + links.nth(i).innerText() + " ---- " + links.nth(i).getAttribute("href"));
        }

        //Handling links which are inside a particular block.
        Locator block = page.locator("#www-wikipedia-org > footer > nav");

        Locator blocklinks = block.locator("a");

        System.out.println("----Printing links from the block------");

        System.out.println(blocklinks.count());

        for(int i=0; i<blocklinks.count(); i++) {

            System.out.println(blocklinks.nth(i).innerText()+"---URL: ----"+blocklinks.nth(i).getAttribute("href"));

        }   
        
        Thread.sleep(5000);

        page.close();
        browser.close();
        playwright.close();
    }
}
