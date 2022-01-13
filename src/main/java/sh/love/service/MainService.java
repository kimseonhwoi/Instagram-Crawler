package sh.love.service;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sh.love.config.InstagramConfig;

@Service
public class MainService {

    @Autowired
    private InstagramConfig instagramConfig;

    public boolean instagram(String postId, String userId) {
        return instagramConfig.getUser(postId, userId);
    }
}
