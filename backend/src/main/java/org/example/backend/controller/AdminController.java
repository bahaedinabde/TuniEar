package org.example.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/admin")
public class AdminController {
     @GetMapping("/admin")
    public String index(){
         return "index";
     }
}
