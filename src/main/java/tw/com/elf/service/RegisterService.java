package tw.com.elf.service;

import tw.com.elf.dao.RegisterRequest;
import tw.com.elf.dao.Response;

public interface RegisterService {
	
	public <T> Response<T> register(RegisterRequest registerRequest); 

}
