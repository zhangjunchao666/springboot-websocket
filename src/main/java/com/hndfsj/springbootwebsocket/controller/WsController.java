package com.hndfsj.springbootwebsocket.controller;

import com.hndfsj.springbootwebsocket.bean.WiselyMessage;
import com.hndfsj.springbootwebsocket.bean.WiselyResponse;
import com.hndfsj.springbootwebsocket.constant.Constant;
import com.hndfsj.springbootwebsocket.service.WebSocketService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * TODO：
 * </pre>
 *
 * @author zhangjunchao
 * @date 2019/7/2
 */
@Controller
public class WsController {

    @Resource
    WebSocketService webSocketService;

    @MessageMapping(Constant.FORETOSERVERPATH)//@MessageMapping和@RequestMapping功能类似，用于设置URL映射地址，浏览器向服务器发起请求，需要通过该地址。
    @SendTo(Constant.PRODUCERPATH)//如果服务器接受到了消息，就会对订阅了@SendTo括号中的地址传送消息。
    public WiselyResponse say(WiselyMessage message) throws Exception {
        List<String> users =  new ArrayList<String>();
        //此处写死只是为了方便测试,此值需要对应页面中订阅个人消息的userId
        users.add("123456789");
        users.add("654321");
        String msg ="你好世界！";
        webSocketService.send2Users(users,msg);

        WiselyResponse wiselyResponse = new WiselyResponse("Welcome, " + message.getName() + "!");


        return wiselyResponse;
    }

}
