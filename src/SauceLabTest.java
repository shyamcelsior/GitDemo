import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabTest {

public static void main(String[] args) throws MalformedURLException {

// TODO Auto-generated method stub
	
	ChromeOptions browserOptions = new ChromeOptions();
	
	
	browserOptions.setPlatformName("Windows 10");
	browserOptions.setBrowserVersion("latest");
	Map<String, Object> sauceOptions = new HashMap<>();
	sauceOptions.put("build", "<your build id>");
	sauceOptions.put("name", "<your test name>");
	browserOptions.setCapability("sauce:options", sauceOptions);

	URL url = new URL("https://oauth-shyamagarwal.hbti-15c0f:6a3fba77-9897-4a5c-ab9d-45de5d80c987@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
	RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);



driver.get("http://google.com");

System.out.println(driver.getTitle());

}



}

