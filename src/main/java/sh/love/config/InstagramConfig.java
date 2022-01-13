package sh.love.config;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InstagramConfig {

    private static WebDriver driver;

    @PostConstruct
    private void init() {
        try {
            ChromeOptions options = new ChromeOptions();
            // 헤드리스 사용
//        options.addArguments("--headless", "--disable-gpu", "--ignore-certificate-errors",
//                "--user-agent=Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Mobile Safari/537.36");
            // 헤드리스 미사용
            options.addArguments("--disable-gpu", "--ignore-certificate-errors",
                    "--user-agent=Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Mobile Safari/537.36");
            driver = new ChromeDriver(options);
            // 로그인
            driver.get("https://www.instagram.com/accounts/login/");
            Thread.sleep(5000);
            driver.findElements(By.name("username")).get(0).sendKeys("userName");
            driver.findElements(By.name("password")).get(0).sendKeys("password");
            ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName(\"sqdOP\")[2].click();");
//        driver.findElements(By.name("password")).get(0).submit();
//            Thread.sleep(2500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean getUser(String postId, String userId) {
        // https://www.instagram.com/p/CYdt0KNpLEC/
        try {
            driver.get("https://www.instagram.com/p/" + postId + "/");
            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName(\"zV_Nj\")[1].click();");
            //
            // driver.find_element_by_tag_name('body').send_keys(Keys.PAGE_DOWN)\
            int i = 0;
            while(true) {
                ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName(\"RnEpo\")[0].getElementsByClassName(\"qF0y9\")[0].getElementsByTagName(\"div\")[0].scroll(0,10000000000);");
                if(i++ > 30) {
                    break;
                }
            }
            Thread.sleep(100000);
        } catch (Exception e) {
            return false;
        }

        return false;
    }


}
