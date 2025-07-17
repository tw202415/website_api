package tw.com.elf.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tw.com.elf.dao.Response;
import tw.com.elf.mapper.airshop.customerMapper.CustomerProductsMapper;
import tw.com.elf.model.airshop.customer.Products;
import tw.com.elf.service.ShopService;

@Service
@Slf4j
public class ShopServiceImp implements ShopService{
	
	@Autowired
	private CustomerProductsMapper customerproductsMapper;

	@SuppressWarnings("unchecked")
	@Override
	public Response<List<Products>> getProducts(String country) {
		return Response.success(customerproductsMapper.selectAll());
	}

	

}
