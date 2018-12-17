package com.example.everything.common.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author win10
 */
@Setter
@Getter
public class ObjectResponse<T> implements Serializable {

    private static final long serialVersionUID = -8445953225786657614L;

    /**
     * 编号.
     */
    private int code;

    /**
     * 信息.
     */
    private String message;

    /**
     * 结果数据
     */
    private T result;

    public ObjectResponse() {
    }

    public ObjectResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ObjectResponse(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }
}
