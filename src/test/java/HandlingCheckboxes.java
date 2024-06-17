import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingCheckboxes {
    
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		
        //click all checkboxes in page.
        // Locator checkboxes = page.locator("[type='checkbox']");
        // System.out.println(checkboxes.count());

        // for (int i = 0; i < checkboxes.count(); i++)
        // {
        //     checkboxes.nth(i).click();
        // }

        //click all checkboxes in a block only.
        Locator block = page.locator("body > table:nth-child(3) > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr > td > div:nth-child(9)");
        Locator checkboxes = block.locator("[type='checkbox']");
        System.out.println(checkboxes.count());

        for (int i = 0; i < checkboxes.count(); i++)
        {
            checkboxes.nth(i).click();
        }

        Thread.sleep(5000);

        page.close();
        browser.close();
        playwright.close();
    }
}
