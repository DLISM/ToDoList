package com.example.todolist.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.example.todolist.domain.User;
import com.example.todolist.domain.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @Value("${spring.profile.active}")
    private String profile;

    private final ObjectWriter profileWriter;

    @Autowired
    public MainController(ObjectMapper mapper) {
        ObjectMapper objectMapper = mapper
                .setConfig(mapper.getSerializationConfig());

        this.profileWriter = objectMapper
                .writerWithView(Views.FullProfile.class);
    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public String main(@AuthenticationPrincipal User user, Model model) throws JsonProcessingException {
        if(user!=null){
            String serializedProfile = profileWriter.writeValueAsString(user);
            model.addAttribute("profile", serializedProfile);
        }
        else {
            model.addAttribute("profile", "null");
        }
        model.addAttribute("isDevMode", true);
        return "index";
    }
}
