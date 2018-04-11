package com.yunka.buluo.lottery.handler;

import com.yunka.buluo.lottery.body.ResultVO;
import com.yunka.buluo.lottery.exception.BussinessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by qianyi on 2017/11/21.
 * 全局异常处理
 * <p>
 * 对于返回JSON格式的数据，springBoot推荐使用：@ControllerAdvice和@ExceptionHandler进行处理
 *
 * @ControllerAdvice basePackageClasses针对某个Controller进行处理
 * @ControllerAdvice(value = "com.group.qianyi.springbootdemo")针对某个包进行处理
 */
//@ControllerAdvice(basePackageClasses = HelloController.class)
@ControllerAdvice
public class FooExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResultVO handleControllerException(HttpServletRequest request, Exception ex) {
        HttpStatus status = getStatus(request);
        ResultVO result = new ResultVO();
        StringBuilder sb = new StringBuilder();
        if (ex instanceof MethodArgumentNotValidException) {
            resolvervalidException(ex, sb, result);
            result.setCode(0 + "");
            result.setResult(sb);
            result.setTime(new Date());
            return result;
        } else if (ex instanceof BussinessException) {
            result.setCode(0 + "");
            result.setResult("业务异常错误");
            result.setTime(new Date());
            return result;
        }else {
             resolverOtherException(ex,sb,result);
        }
        return result;
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

    /*
     * 处理参数绑定异常
     */
    private void resolvervalidException(Exception ex, StringBuilder sb, ResultVO result) {
        MethodArgumentNotValidException be = (MethodArgumentNotValidException) ex;
        List<FieldError> errorList = be.getBindingResult().getFieldErrors();
        for (FieldError error : errorList) {
//            sb.append(error.getObjectName());
//            sb.append("对象的");
            sb.append(error.getField());
            sb.append("字段");
            sb.append(error.getDefaultMessage());
            sb.append(";");
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
