package com.yunka.buluo.lottery.handler;

import com.alibaba.fastjson.JSON;
import com.yunka.buluo.lottery.exception.BussinessException;
import com.yunka.buluo.lottery.body.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by qianyi on 2017/11/20.
 * 如果是模版的方式，直接继承HandlerExceptionResolver类，实现其方法即可
 *
 */
@Component
public class ExceptionResolver implements HandlerExceptionResolver {
    private static Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        ResultVO result = new ResultVO();
        StringBuilder sb = new StringBuilder();

        //处理异常
        if(ex instanceof BussinessException) {
            resolverBussinessException(ex, sb, result);
        } else if (ex instanceof MethodArgumentNotValidException) {
            resolverBindException(ex, sb, result);
        } else {
            resolverOtherException(ex, sb, result);
        }

        result.setCode(0+"");
        result.setResult(sb);
        result.setTime(new Date());

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException e) {
            logger.error("与客户端通讯异常：" + e.getMessage(), e);
            e.printStackTrace();
        }

        logger.debug("异常：" + ex.getMessage(), ex);
        ex.printStackTrace();

        return new ModelAndView();
    }

    /*
     * 处理业务层异常
     */
    private void resolverBussinessException(Exception ex, StringBuilder sb, ResultVO result) {
        BussinessException businessException = (BussinessException) ex;
        sb.append(businessException.getMsg());
        addResult(result, "业务异常");
    }

    /*
     * 处理参数绑定异常
     */
    private void resolverBindException(Exception ex, StringBuilder sb, ResultVO result) {
        BindException be = (BindException) ex;
        List<FieldError> errorList = be.getBindingResult().getFieldErrors();
        for (FieldError error : errorList) {
            sb.append(error.getObjectName());
            sb.append("对象的");
            sb.append(error.getField());
            sb.append("字段");
            sb.append(error.getDefaultMessage());
        }
        addResult(result, "参数传递异常");
    }

    /*
     * 处理其他异常
     */
    private void resolverOtherException(Exception ex, StringBuilder sb, ResultVO result) {
        sb.append(ex.getMessage());
        addResult(result, "其他异常");
    }

    /*
     * 封装code和msg
     */
    private void addResult(ResultVO result, String msg) {
        result.setMsg(msg);
    }


}
