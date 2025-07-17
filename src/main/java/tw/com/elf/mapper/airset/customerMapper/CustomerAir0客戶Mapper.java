package tw.com.elf.mapper.airset.customerMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerAir0客戶Mapper {
	
	int countByIdNumberOrMobile(@Param("idNumber")String idNumber, @Param("mobile")String mobile);
    
}