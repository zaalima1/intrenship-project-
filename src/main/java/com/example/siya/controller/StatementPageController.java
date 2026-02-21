package com.example.siya.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatementPageController {

    @GetMapping("/statement-page")
    public String showStatementPage() {
        return "statement";
    }
}
