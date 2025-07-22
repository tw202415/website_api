package tw.com.elf.mapper.airshop.customerMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tw.com.elf.dao.ShopRequest;
import tw.com.elf.model.airshop.customer.Products;

@Mapper
public interface CustomerProductsMapper {
	
	List<Products> query(@Param("shopRequest") ShopRequest shopRequest, @Param("limit") int limit, @Param("offset") int offset);
	
	Products getDetail(@Param("productId") String productId);
}