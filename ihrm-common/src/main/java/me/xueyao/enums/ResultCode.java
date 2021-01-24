package me.xueyao.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Simon.Xue
 * @date 1/22/21 5:10 PM
 **/
@Getter
@AllArgsConstructor
public enum  ResultCode {
    SUCCESS(true, 10000, "操作成功"),
    FAIL(false, 10001, "操作失败"),
    UNAUTHENTICATED(false, 10002, "您还未登录"),
    UNAUTHORISE(false, 10003, "权限不足"),
    SERVICE_ERROR(false, 99999, "抱歉，系统繁忙，请稍后重试!");

    boolean success;
    int code;
    String message;
}
