package tw.com.elf.service;

import tw.com.elf.dao.Response;
import tw.com.elf.dao.ShopRequest;

public interface ShopService {
	
	public <T> Response<T> getProducts(ShopRequest shopRequest); 
	
	public <T> Response<T> getDetail(String productId); 
	
	public <T> Response<T> getReviews(String productId); 

}
