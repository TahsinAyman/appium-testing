import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestCase {

    private AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.google.android.calculator");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");
        this.driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testAdd() {
        MobileElement e1 = this.driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement ePlus = this.driver.findElementById("com.google.android.calculator:id/op_add");
        MobileElement e2 = this.driver.findElementById("com.google.android.calculator:id/digit_3");

        e1.click();
        ePlus.click();
        e2.click();

        MobileElement result = this.driver.findElementById("com.google.android.calculator:id/result_preview");

        Assert.assertEquals(Integer.parseInt(result.getText()), 4);
    }

}
