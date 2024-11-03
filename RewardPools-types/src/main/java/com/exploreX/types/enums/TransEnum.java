package com.exploreX.types.enums;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/3 下午2:43
 **/
public enum TransEnum {
    TRANSFER("text",1),
    BURN("exchange",2),
    MINT("wish",3),
    ;
    private int code;//1-文本消息 2-碎片交换消息 3-许愿消息
    private String value;

    TransEnum(String value, int code) {
        this.value = value;
        this.code=code;
    }

    public  String  getNameByCode(int code) {
        for (TransEnum transEnum : TransEnum.values()) {
            if (transEnum.code == code) {
                return transEnum.value;
            }
        }
        return "default";
    }
}
