package sh.love.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sh.love.service.MainService;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    @RequestMapping(value = "/")
    public String main(@RequestParam(value = "postId") String postId,
                       @RequestParam(value = "userId") String userId) throws Exception{
        return mainService.instagram(postId, userId);
    }

}
