package gduK17.shop.presentation.controller;

import gduK17.shop.domain.entity.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo controller for simple message response
 */
@RestController
public class DemoController {
    @GetMapping("/hello")
    public Message hello() {
        Message helloNoti = new Message();
        helloNoti.setName("Long");
        helloNoti.setMessage("Hello");
        return helloNoti;
    }
}