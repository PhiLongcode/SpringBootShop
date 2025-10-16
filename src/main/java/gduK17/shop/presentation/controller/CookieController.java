package gduK17.shop.presentation.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for demonstrating cookie operations
 */
@RestController
public class CookieController {
    @GetMapping("/set-cookie")
    public String setCookie(HttpServletResponse repo) {
        Cookie cookie = new Cookie("userName", "LongPi");
        cookie.setMaxAge(7 * 24 * 60 * 60); // 1 tuần
        cookie.setPath("/");
        repo.addCookie(cookie);
        return "Cookie set";
    }

    @GetMapping("/get-cookie")
    public String getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("userName")) {
                    return c.getValue();
                }
            }
        }
        return "Không tìm thấy";
    }
}