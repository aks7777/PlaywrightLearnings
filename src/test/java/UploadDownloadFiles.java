import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class UploadDownloadFiles {
    
    //Upload file button must be of type=file to work upon, else request developer to modify the locator.
    // public static void main(String[] args) throws InterruptedException {
    //     Playwright playwright = Playwright.create();
	// 	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
 
	// 	Page page = browser.newPage();

    //     //single file
	// 	// page.navigate("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
 
	// 	// page.locator("#register_form > fieldset:nth-child(9) > input[type=file]").setInputFiles(Paths.get("./playwright-practise/src/main/resources/files/testfile.png"));


    //     //multiple files
    //     page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_multiple");
 
    //     //present inside IFRAME.
	// 	page.frameLocator("#iframeResult").locator("#myFile").setInputFiles(new Path[]{
    //         Paths.get("./playwright-practise/src/main/resources/files/testfile.png"),
    //         Paths.get("./playwright-practise/src/main/resources/files/testfile1.png")
    //     });

    //     Thread.sleep(3000);
    //     page.close();
    //     browser.close();
    //     playwright.close();
    // }


    //Downloading a file.
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
 
		Page page = browser.newPage();

        //multiple files
        page.navigate("https://www.selenium.dev/downloads/");
 
        Download file = page.waitForDownload(() -> {
            page.locator("body > div > main > div:nth-child(5) > div.col-sm-6.py-3.ps-0.pe-3 > div > div > p:nth-child(1) > a").click();
        });

        file.saveAs(Paths.get("./playwright-practise/src/main/resources/files/selenium.jar"));
        
        Thread.sleep(3000);
        page.close();
        browser.close();
        playwright.close();
    }
}
