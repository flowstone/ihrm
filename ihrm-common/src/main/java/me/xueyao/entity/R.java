package me.xueyao.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.xueyao.enums.ResultCode;


/**
 * @author Simon.Xue
 * @date 1/22/21 4:53 PM
 **/
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R {
    /**
     * 是否成功
     */
    private boolean success;
    private Integer code;
    private String message;
    private Object data;

    public R(ResultCode code) {
        this.success = code.isSuccess();
        this.code = code.getCode();
        this.message = code.getMessage();
    }

    public R(ResultCode code, Object data) {
        this.success = code.isSuccess();
        this.code = code.getCode();
        this.message = code.getMessage();
        this.data = data;
    }

    public R(Integer code, String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public static R SUCCESS() {
        return new R(ResultCode.SUCCESS);
    }

    public static R ERROR() {
        return new R(ResultCode.SERVICE_ERROR);
    }

    public static R FAIL() {
        return new R(ResultCode.FAIL);
    }
}
