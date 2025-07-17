package tw.com.elf.mapper.airshop.customerMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import tw.com.elf.model.airshop.customer.Products;

@Mapper
public interface CustomerProductsMapper {
	
	List<Products> selectAll();
}