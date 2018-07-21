package com.adam.ApiResponseUtil;

import java.io.Serializable;

public class ApiResponse<T> implements Serializable {

	private boolean success;
	private String errMsg;
	private int code;
	private T dataT;
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getDataT() {
		return dataT;
	}

	public void setDataT(T dataT) {
		this.dataT = dataT;
	}

	public static <T> ApiResponse<T> buildSuccess(T data){
		
		ApiResponse<T> response = new ApiResponse<T>();
		response.setDataT(data);
		response.setSuccess(true);
		return response;
	}
	
	public static <T> ApiResponse<T> buidSuccess(){
		
		ApiResponse<T> response = new ApiResponse<T>();
		response.setSuccess(true);
		
		return response;
	}
	
	public static <T> ApiResponse<T> buildFailure(){
		
		ApiResponse<T> response = new ApiResponse<T>();
		response.setSuccess(false);
		
		return response;
	}
	
	public static <T> ApiResponse<T> buildFailure(String errorMsg){
		
		ApiResponse<T> response = new ApiResponse<T>();
		response.setSuccess(false);
		response.setErrMsg(errorMsg);
		return response;
	}
	
	public static <T> ApiResponse<T> buildFailure(String errorMsg,String errorCode){
		
		ApiResponse<T> response = new ApiResponse<T>();
		response.setSuccess(false);
		response.setErrMsg(errorMsg);
		response.setCode(0);
		return response;
	}
}
