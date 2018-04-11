# spring-boot-full-exception
全局日志处理，本例子主要对参数验证异常进行捕获然后进行相关逻辑的处理
>1.直接写在Controller 
 @ExceptionHandler(MethodArgumentNotValidException.class)
 @ResponseStatus(HttpStatus.BAD_REQUEST)
 
>2.如果是模版的方式，直接继承HandlerExceptionResolver类，实现其方法即可
```
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
```
>3.返回JSON格式的字符串
对于返回JSON格式的数据，springBoot推荐使用：@ControllerAdvice和@ExceptionHandler进行处理
```
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
```
>4.代码中请求：http://localhost:8080/user/add
{"name":"asfasf","age":990}，发生异常会返回JSO格式：
```
{
    "msg": "参数传递异常",
    "code": "0",
    "time": 1511538816085,
    "result": "age字段年龄范围必须小于150;"
}

```





