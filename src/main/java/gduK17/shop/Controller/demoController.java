package gduK17.shop.Controller;


import gduK17.shop.Model.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController {
    @GetMapping("/hello")
    public Message hello(){
        Message helloNoti = new Message();
        helloNoti.setName("Long");
        helloNoti.setMessage("Hello");
        return helloNoti;
    }
}
