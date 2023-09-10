package org.springboot.demo.upload.util;

/**
 * @author wxy
 * @date 2022/10/7 23:31
 */
public class Result {
    // 响应业务状态
    private String status;
    // 响应消息
    private String msg;
    // 响应中的数据
    private Object data;
    public Result(String status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    public Result(){

    }
    public static Result ok(String status,String msg,Object data) {
        return new Result(status,msg,data);
    }
}
