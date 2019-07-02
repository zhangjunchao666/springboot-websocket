package com.hndfsj.springbootwebsocket.bean;

/**
 * <pre>
 * TODO：后台发送消息实体
 * </pre>
 *
 * @author zhangjunchao
 * @date 2019/7/2
 */
public class WiselyResponse {

    private String responseMessage;

    public WiselyResponse(String responseMessage){
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }


}
