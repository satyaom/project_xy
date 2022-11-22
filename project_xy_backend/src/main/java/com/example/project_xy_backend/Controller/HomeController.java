package com.example.project_xy_backend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/aao")
    public void test() {
        System.out.println("Controller Chal gaya");
    }
}
