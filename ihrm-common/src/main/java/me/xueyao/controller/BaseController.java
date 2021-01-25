package me.xueyao.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Simon.Xue
 * @date 1/25/21 2:28 PM
 **/
public class BaseController {

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    @ModelAttribute
    public void setReqAndResp(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * 当前写死，后期动态获取
     * @return
     */
    public String parseCompanyId() {
        return "1";
    }

    public String parseCompanyName() {
        return "ICRM";
    }

}
