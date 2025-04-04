package com.example.scooter_hiring.result;

public class CodeMsg {
    private int code;
    private String msg;

    //通用错误码
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    public static CodeMsg ACCESS_LIMIT_REACHED= new CodeMsg(500104, "访问高峰期，请稍等！");
    
    //登录模块 5002XX
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号不存在");
    public static CodeMsg MOBILE_ALREADY_EXIST = new CodeMsg(500215, "手机号已被使用");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500216, "密码错误");
    public static CodeMsg USER_NOT_EXIST = new CodeMsg(500217, "用户不存在");
    public static CodeMsg USER_EXIST = new CodeMsg(500218, "用户已存在");
    public static CodeMsg USER_NOT_LOGIN = new CodeMsg(500219, "用户未登录");
    public static CodeMsg USER_NOT_REGISTER = new CodeMsg(500220, "用户未注册");
    public static CodeMsg USER_ALREADY_LOGIN = new CodeMsg(500221, "用户已登录");
    public static CodeMsg USER_ALREADY_REGISTER = new CodeMsg(500222, "用户已注册");
    public static CodeMsg USER_ALREADY_LOGOUT = new CodeMsg(500223, "用户已登出");
    
    //构造函数
    private CodeMsg() {
    }

    //构造函数
    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    //返回带参数的错误码
    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    //重写toString
    @Override
    public String toString() {
        return "CodeMsg [code=" + code + ", msg=" + msg + "]";
    }
}
