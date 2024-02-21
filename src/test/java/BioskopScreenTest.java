import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import net.bytebuddy.asm.Advice;
import org.example.Utils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.Key;

public class BioskopScreenTest {

        AndroidDriver driver;

        @BeforeClass
        public void setUp () throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 2 API 30");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("platformVersion", "11");
        dc.setCapability("appPackage", "id.tix.android");
        dc.setCapability("appActivity", "id.tix.android.splash.view.SplashActivity");
        dc.setCapability("noReset", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dc);
    }

        @AfterClass
        public void finish () {
        Utils.delay(3);
        driver.quit();
    }

        @Test
        public void testBioskopScreen () {
        Utils.delay(20);
        MobileElement bioskop = (MobileElement) driver.findElementById("id.tix.android:id/navigation_theater");
        bioskop.click();
        Utils.delay(5);
        MobileElement formSearch = (MobileElement) driver.findElementById("id.tix.android:id/et_input");
        formSearch.click();
        Utils.delay(2);
        MobileElement searchFilm = (MobileElement) driver.findElementById("id.tix.android:id/et_input");
        searchFilm.sendKeys("AGAK LAEN");
        Utils.delay(5);
        MobileElement filmPilihan = (MobileElement) driver.findElementById("id.tix.android:id/iv_picture_of_movie");
        filmPilihan.click();
        //Assert validasi
        Utils.delay(5);
        String strCityName = bioskop.getText();
        System.out.println(strCityName);
        Assert.assertEquals(strCityName, "BANDUNG");

    }

}

