package tw.com.elf.service;

import tw.com.elf.dao.Response;

public interface ShopService {
	
	public <T> Response<T> getProducts(String country); 

}
