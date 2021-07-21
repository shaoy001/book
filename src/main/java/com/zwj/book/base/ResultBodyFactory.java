package com.zwj.book.base;

public class ResultBodyFactory {

    public static ResultBody createResultBody() {
        return new ResultBody();
    }

    public static ResultBody createOKResultBody() {
        return createResultBody(0, "OK");
    }

    public static ResultBody createOKResultBody(Object data) {
        return createResultBody(0, "OK", data);
    }

    public static ResultBody createResultBody(int code, Object message) {
        return createResultBody(code, message, ResultBody.EMPTY_DATA);
    }

    public static ResultBody createResultBody(String code, Object message) {
        return createResultBody(Integer.parseInt(code), message, ResultBody.EMPTY_DATA);
    }
    public static ResultBody createResultBody(int code, Object message, Object data) {
        return new ResultBody(code, message, data);
    }
    

	/**
	 * 失败
	 */
	public static ResultBody error(BaseErrorInfoInterface errorInfo) {
		ResultBody rb = new ResultBody();
		rb.setCode(Integer.parseInt(errorInfo.getResultCode()));
		rb.setMessage(errorInfo.getResultMsg());
		rb.setData( ResultBody.EMPTY_DATA);
		return rb;
	}
    
}
