package com.example.scooter_hiring.exception;

import com.example.scooter_hiring.result.CodeMsg;

//自定义全局异常类
public class GlobalException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}
