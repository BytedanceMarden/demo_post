/**
  * Copyright 2021 bejson.com 
  */
package com.bytedance.demo_post;

/**
 * Auto-generated: 2021-08-12 11:2:35
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class MyResponse {

    private Data data;
    private int errorCode;
    private String errorMsg;


    public void setData(Data data) {
         this.data = data;
     }
     public Data getData() {
         return data;
     }

    public void setErrorCode(int errorCode) {
         this.errorCode = errorCode;
     }
     public int getErrorCode() {
         return errorCode;
     }

    public void setErrorMsg(String errorMsg) {
         this.errorMsg = errorMsg;
     }
     public String getErrorMsg() {
         return errorMsg;
     }

    @Override
    public String toString() {
        return "MyResponse{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}