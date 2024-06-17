import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DragAndDrop {
    
    public static void main(String[] args) throws InterruptedException {
        
        Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://jqueryui.com/resources/demos/droppable/default.html");


        //drag an element (pick center point) and drop in another element (pick center point).
        
        Locator draggable = page.locator("#draggable");
        Locator droppable = page.locator("#droppable");
        page.mouse().move(draggable.boundingBox().x + draggable.boundingBox().width/2, draggable.boundingBox().y + draggable.boundingBox().height/2);

        page.mouse().down();
        Thread.sleep(3000);
        page.mouse().move(droppable.boundingBox().x + droppable.boundingBox().width/2, droppable.boundingBox().y + droppable.boundingBox().height/2);
        page.mouse().up();

        Thread.sleep(2000);
        page.close();
        browser.close();
        playwright.close();
    }
}
