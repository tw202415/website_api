package tw.com.elf.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tw.com.elf.dao.RegisterRequest;
import tw.com.elf.dao.Response;
import tw.com.elf.mapper.AirsetMapper;
import tw.com.elf.mapper.customerMapper.CustomerAirsetMapper;
import tw.com.elf.model.Airset;
import tw.com.elf.service.RegisterService;
import tw.com.elf.utils.TimeUtil;

@Service
@Slf4j
public class RegisterServiceImp implements RegisterService{
	
	@Autowired
	private AirsetMapper airsetMapper;
	
	@Autowired
	private CustomerAirsetMapper customerAirsetMapper;

	@Override
	@Transactional
	public Response<Object> register(RegisterRequest registerRequest) {
		Response<Object> res = new Response<>();
		try {
			int result = customerAirsetMapper.countByIdNumberOrMobile(registerRequest.getIdNumber(), registerRequest.getMobile());
			if (result > 0) {
				res.setCode("002");
				res.setMsg("身分證、手機已註冊");
				return res;
			}
			airsetMapper.insertSelective(requestToAirset(registerRequest));
			
			res.setCode("200");
			res.setMsg("success");
			return res;
		} catch(DuplicateKeyException e) {
			log.error("信箱已註冊過: {}", e);
			res.setCode("001");
			res.setMsg("信箱已註冊過");
			return res;
		} catch(Exception e) {
			log.error("註冊會員資料失敗: {}", e);
			res.setCode("999");
			res.setMsg("註冊會員資料失敗");
			return res;
		} 
		
		
	}
	
	private Airset requestToAirset(RegisterRequest registerRequest) {
		Airset result = new Airset();
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
