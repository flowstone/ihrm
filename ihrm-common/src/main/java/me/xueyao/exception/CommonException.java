package me.xueyao.exception;

import lombok.Getter;
import me.xueyao.enums.ResultCode;

/**
 * @author Simon.Xue
 * @date 1/24/21 10:25 PM
 **/
@Getter
public class CommonException extends RuntimeException {
    private ResultCode code = ResultCode.SERVICE_ERROR;

    public CommonException() {}

    public CommonException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode;
    }
}
