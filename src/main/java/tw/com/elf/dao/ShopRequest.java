package tw.com.elf.dao;

import lombok.Data;

@Data
public class ShopRequest {
	
	private String country;
	
	private Integer categoryId;
	
	private String name;
	
	private Integer page;
	
	private Integer size;

}
