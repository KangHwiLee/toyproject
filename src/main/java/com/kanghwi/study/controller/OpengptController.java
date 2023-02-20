package com.kanghwi.study.controller;

import com.kanghwi.study.Service.BotService;
import com.kanghwi.study.ServiceImpl.BotServiceImpl;
import com.kanghwi.study.chatgpt.BotRequest;
import com.kanghwi.study.chatgpt.ChatGptResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/opengpt")
@RequiredArgsConstructor
public class OpengptController {

    private final BotServiceImpl botService;

    @ResponseBody
    @PostMapping("/send")
    public ChatGptResponse sendMessage(@RequestBody BotRequest botRequest){
        return botService.askQuestion(botRequest);
    }

    @GetMapping("/chat")
    public String chat(){
        return "settings/chatgpt";
    }

}
