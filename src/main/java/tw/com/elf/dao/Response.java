package tw.com.elf.dao;

import lombok.Data;

@Data
public class Response<T> {
	
	private String code;
	
	private String msg;
	
	private T body;
	
	public static <T> Response<T> success(T body) {
        Response<T> res = new Response<>();
        res.setCode("200");
        res.setMsg("success");
        res.setBody(body);
        return res;
    }

    public static <T> Response<T> error(String code, String msg) {
        Response<T> res = new Response<>();
        res.setCode(code);
        res.setMsg(msg);
        res.setBody(null);
        return res;
    }

}
