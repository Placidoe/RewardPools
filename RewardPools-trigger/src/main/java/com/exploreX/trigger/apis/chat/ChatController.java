package com.exploreX.trigger.apis.chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/8 上午1:11
 **/
@RestController
@RequestMapping("/chat")
@Slf4j
public class ChatController {
    /*交换碎片、文本聊天、许愿*/
    @RequestMapping("/chat")
    public String chat() {
        return "chat";
    }

    /*交换碎片、文本聊天、许愿*/
    @RequestMapping("/exchange")
    public String exchange() {
        return "exchange";
    }

    /*交换碎片、文本聊天、许愿*/
    @RequestMapping("/wish")
    public String wish() {
        return "wish";
    }
}
