package com.cims.common;

/**
 * json api 返回状态
 *
 * @author vanh
 * @date 2019/7/12
 */
public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS(0, "SUCCESS"),
    /**
     * 失败
     */
    ERROR(1, "ERROR"),
    /**
     * 必须登录
     */
//    NEED_LOGIN(10, "NEED_LOGIN"),
    /**
     * 参数错误
     */
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT"),
    /**
     * 需要跳转
     */
    NEED_REDIRECT(302,"NEED_REDIRECT")
    ;


    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
