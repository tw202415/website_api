package tw.com.elf.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tw.com.elf.dao.RegisterRequest;
import tw.com.elf.dao.Response;
import tw.com.elf.mapper.airset.Air0客戶Mapper;
import tw.com.elf.mapper.airset.customerMapper.CustomerAir0客戶Mapper;
import tw.com.elf.model.airset.Air0客戶;
import tw.com.elf.service.RegisterService;
import tw.com.elf.utils.TimeUtil;

@Service
@Slf4j
public class RegisterServiceImp implements RegisterService{
	
	@Autowired
	private Air0客戶Mapper air0客戶Mapper;
	
	@Autowired
	private CustomerAir0客戶Mapper customerAir0客戶Mapper;

	@Override
	@Transactional
	public Response<Object> register(RegisterRequest registerRequest) {
		Response<Object> res = new Response<>();
		try {
			int result = customerAir0客戶Mapper.countByIdNumberOrMobile(registerRequest.getIdNumber(), registerRequest.getMobile());
			if (result > 0) {
				return Response.error("002", "身分證、手機已註冊");
			}
			air0客戶Mapper.insertSelective(requestToAirset(registerRequest));
			
			return Response.success(null);
		} catch(DuplicateKeyException e) {
			log.error("信箱已註冊過: {}", e);
			return Response.error("001", "信箱已註冊過");
		} catch(Exception e) {
			log.error("註冊會員資料失敗: {}", e);
			return Response.error("999", "註冊會員資料失敗");
		} 
	}
	
	private Air0客戶 requestToAirset(RegisterRequest registerRequest) {
		Air0客戶 result = new Air0客戶();
		result.setEmail(registerRequest.getEmail());
		result.set姓名(registerRequest.getName());
		result.set出生日期(TimeUtil.strToDate(registerRequest.getBirthYear(), registerRequest.getBirthMonth(), registerRequest.getBirthDay()));
		result.set手機(registerRequest.getMobile());
		result.set聯絡電話(registerRequest.getPhone());
		result.set密碼md5(registerRequest.getPassword());
		result.set身分證字號(registerRequest.getIdNumber());
		result.set地址(registerRequest.getAddress());
		
		return result;
	}
	

}
