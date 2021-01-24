package me.xueyao.exception;

import me.xueyao.entity.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 * @author Simon.Xue
 * @date 1/24/21 10:28 PM
 **/
@ControllerAdvice
public class BaseExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public R error(HttpServletRequest request, HttpServletResponse response, Exception e) {
        e.printStackTrace();
        if (e.getClass() == CommonException.class) {
            CommonException commonException = (CommonException) e;
            return new R(commonException.getCode());
        } else {
            return R.ERROR();
        }

    }
}
