package com.bs.core.exception;

import java.util.List;

/**
 * User: zhangqh6
 * Date: 2015/11/16 17:07:07
 */
public class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;
	private String code;
    private List<String[]> keys;

    public BusinessException() {
        super();
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String[]> getKeys() {
        return keys;
    }

    public void setKeys(List<String[]> keys) {
        this.keys = keys;
    }

}
