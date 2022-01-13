package sh.love.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sh.love.service.MainService;

@RestController
@ResponseBody
public class MainController {

    @Autowired
    private MainService mainService;

    @RequestMapping(value = "/")
    public String main(Model model) throws Exception{
        String postId = "post id";
        String userId = "체킹할 User Id";
        boolean re = mainService.instagram(postId, userId);
        return "/main";
    }

}
