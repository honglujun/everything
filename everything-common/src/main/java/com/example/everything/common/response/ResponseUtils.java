package com.example.everything.common.response;

/**
 * @author win10
 */
public class ResponseUtils {

    public static ObjectResponse ok() {
        ObjectResponse objectResponse = new ObjectResponse(ReturnCode.SUCCESS_CODE,ReturnCode.SUCCESS_MESSAGE);
        return objectResponse;
    }

    public static ObjectResponse ok(Object data){
        ObjectResponse objectResponse = new ObjectResponse(ReturnCode.SUCCESS_CODE,ReturnCode.SUCCESS_MESSAGE,data);
        return objectResponse;
    }

    public static ObjectResponse error(String message){
        ObjectResponse objectResponse = new ObjectResponse(ReturnCode.ERROR_CODE,message);
        return objectResponse;
    }

    public static ObjectResponse noLogin(){
        ObjectResponse objectResponse = new ObjectResponse(ReturnCode.UNAUTHORIZED,ReturnCode.FORBIDDEN);
        return objectResponse;
    }
}
