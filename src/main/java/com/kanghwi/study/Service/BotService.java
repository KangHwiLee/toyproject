package com.kanghwi.study.Service;

import com.kanghwi.study.chatgpt.BotRequest;
import com.kanghwi.study.chatgpt.ChatGptResponse;

public interface BotService {

    ChatGptResponse askQuestion(BotRequest botRequest);
}