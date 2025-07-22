package tw.com.elf.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tw.com.elf.dao.Response;
import tw.com.elf.dao.ShopRequest;
import tw.com.elf.mapper.airshop.customerMapper.CustomerProductsMapper;
import tw.com.elf.mapper.airshop.customerMapper.CustomerReviewsMapper;
import tw.com.elf.model.airshop.Reviews;
import tw.com.elf.model.airshop.customer.Products;
import tw.com.elf.service.ShopService;

@Service
@Slf4j
@SuppressWarnings("unchecked")
public class ShopServiceImp implements ShopService{
	
	@Autowired
	private CustomerProductsMapper customerproductsMapper;
	
	@Autowired
	private CustomerReviewsMapper customerReviewsMapper;

	@Override
	public Response<List<Products>> getProducts(ShopRequest shopRequest) {
		int size = shopRequest.getSize();
    	int offset = (shopRequest.getPage() - 1) * size;
		return Response.success(customerproductsMapper.query(shopRequest, size, offset));
	}

	@Override
	public Response<Products> getDetail(String productId) {
		return Response.success(customerproductsMapper.getDetail(productId));
	}

	@Override
	public Response<List<Reviews>> getReviews(String productId) {
		return Response.success(customerReviewsMapper.getReviews(productId));
	}
	
}
