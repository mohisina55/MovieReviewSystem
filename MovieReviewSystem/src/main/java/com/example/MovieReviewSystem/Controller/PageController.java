package com.example.MovieReviewSystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String homePage() {
        return "redirect:/index.html"; // Looks for templates/index.html
    }
}
