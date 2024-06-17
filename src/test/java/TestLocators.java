 
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
 
public class TestLocators {
 
	public static void main(String[] args) {
		
 
		Playwright playwright = Playwright.create();
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("http://gmail.com");
	
		//page.locator("#identifierId").type("trainer@way2automation.com");
		//page.locator("[id='identifierId']").type("trainer@way2automation.com");
		//page.type("id=identifierId", "trainer@way2automation.com", new TypeOptions().setDelay(100));
		page.locator("[type=email]").fill("trainer@way2automation.com");
		//page.click("text=Next");
		page.click("button:has-text('Next')");
		page.locator("[type=password]").fill("sdfsdfdsf");
		page.click("button:has-text('Next')");
		System.out.println(page.locator("/.Ly8vae > div:nth-child(2) > span:nth-child(1)").innerText());

        page.close();
        browser.close();

    }
}