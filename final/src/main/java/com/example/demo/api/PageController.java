package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/flaskpage")
    public String displayData(Model model) {
        String jsonData = apiService.fetchDataFromFlaskApi();
        model.addAttribute("jsonData", jsonData);
        return "flask_Page";
    }
}
