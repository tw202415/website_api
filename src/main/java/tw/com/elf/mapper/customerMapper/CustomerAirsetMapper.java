package tw.com.elf.mapper.customerMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerAirsetMapper {
	
	int countByIdNumberOrMobile(@Param("idNumber")String idNumber, @Param("mobile")String mobile);
    
}