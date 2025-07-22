package tw.com.elf.mapper.airshop.customerMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tw.com.elf.model.airshop.Reviews;

@Mapper
public interface CustomerReviewsMapper {
	
	List<Reviews> getReviews(@Param("productId") String productId);

}