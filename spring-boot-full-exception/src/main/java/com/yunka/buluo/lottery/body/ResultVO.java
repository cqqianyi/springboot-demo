package com.yunka.buluo.lottery.body;

import java.util.Date;

/**
 * Created by qianyi on 2017/11/21.
 */
public class ResultVO {

    private String msg;

    private String code;

    private Date time=new Date();


    public ResultVO(String msg,String code){
        this.code=code;
        this.msg=msg;
    }

    public ResultVO(){

    }

    private Object result;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
