package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StartController {

    @GetMapping("/")
    public String printWelcome(Model model) {
        List<String> messages = new ArrayList<>();
        messages.add("Здравствуйте!");
        messages.add("Вы попали на локальный сервер");
        messages.add("Хорошего дня");
        model.addAttribute("messages", messages);
        return "start";
    }
}