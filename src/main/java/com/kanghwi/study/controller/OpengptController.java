package com.kanghwi.study.controller;

import com.kanghwi.study.Service.BotService;
import com.kanghwi.study.ServiceImpl.BotServiceImpl;
import com.kanghwi.study.chatgpt.BotRequest;
import com.kanghwi.study.chatgpt.ChatGptResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/opengpt")
@RequiredArgsConstructor
public class OpengptController {

    private final BotServiceImpl botService;

    @PostMapping("/send")
    public ChatGptResponse sendMessage(@RequestBody BotRequest botRequest){
        return botService.askQuestion(botRequest);
    }

}
