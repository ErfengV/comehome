package com.ac.comehome.entity;

import com.ac.comehome.enums.ResultCode;
import lombok.Data;

/**
 * @program: comehome
 * @description: 结果异常
 * @author: ErFeng_V
 * @create: 2021-05-09 16:56
 */
@Data
public class ResultError extends RuntimeException {
    private static final long serialVersionUID = -4879677283847539655L;

    private ResultCode errorCode;

    private String errorMessage;

    private String exceptionMessage;

    private Exception exception;

    public ResultError(ResultCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public ResultError(ResultCode errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ResultError(ResultCode errorCode, String errorMessage, Exception exception) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.exception = exception;
    }

    public ResultError(String errorMessage, String exceptionMessage) {
        super();
        this.exceptionMessage = exceptionMessage;
        this.errorMessage = errorMessage;
    }


    public ResultError(ResultCode errorCode, String errorMessage, String exceptionMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.exceptionMessage = exceptionMessage;
    }
}
