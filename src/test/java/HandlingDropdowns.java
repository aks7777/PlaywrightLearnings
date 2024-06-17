
//Dropdown in HTML is PARENT TAG : "select" and children tags "option"
import java.util.List;
 
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;
 
public class HandlingDropdowns {
	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://www.wikipedia.org/");
		
		//select by value
		page.selectOption("select", "hi");
		Thread.sleep(3000);
	
		//select by text
		page.selectOption("select", new SelectOption().setLabel("Eesti"));
        Thread.sleep(3000);
		
		//select by index
		page.selectOption("select", new SelectOption().setIndex(1));
		Thread.sleep(3000);
		
        //print values in dropdown using loops.
		// Locator values = page.locator("select > option");
		// System.out.println(values.count());
		
		
		// for(int i=0; i<values.count(); i++) {
			
		// 	System.out.println(values.nth(i).innerText()+"----"+values.nth(i).getAttribute("lang"));
			
			
		// }
		
		List<ElementHandle> values = page.querySelectorAll("select > option");
		System.out.println(values.size());
		for(ElementHandle value: values) {
			System.out.println(value.innerText()+"----"+value.getAttribute("lang"));
		}
		
		Thread.sleep(5000);

        page.close();
        browser.close();
        playwright.close();
		
	}
 
}