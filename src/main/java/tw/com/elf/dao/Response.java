package tw.com.elf.dao;

import lombok.Data;

@Data
public class Response<T> {
	
	private String code;
	
	private String msg;
	
	private T body;

}
