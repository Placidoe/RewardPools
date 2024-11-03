package com.exploreX.domain.chat.model;

/**
 * @Author: chuxia0811
 * @Date: 2023/7/9 10:58
 * @Description :
 */
public class MessageData {
    private Integer id;
    private String from;
    private String to;
    private String msg;
    private String date;
    private Integer type;//消息发送的类型，0系统群发，1用户私聊
    private Integer is_read;//消息是否已读，0未读，1已读

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIs_read() {
        return is_read;
    }

    public void setIs_read(Integer is_read) {
        this.is_read = is_read;
    }
}
