package com.cafe24.shop.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shop.dto.JSONResult;
import com.cafe24.shop.service.AddressService;
import com.cafe24.shop.service.UserService;
import com.cafe24.shop.vo.AddressVo;
import com.cafe24.shop.vo.AddressVo;
import com.cafe24.shop.vo.UserVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("addrAPIController")
@RequestMapping("/api/addr")
public class AddressController {

	@Autowired
	private AddressService addressService;

	
	//사용자 배송지 등록
	@ApiOperation(value="사용자 배송지 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="addressVo", value ="배송지 addressVo", required=true, dataType="addressVo", defaultValue="")
	})
	@PostMapping("/register")
	public  ResponseEntity<JSONResult> AddressRegister(@RequestBody @Valid AddressVo vo ,BindingResult bResult) {
		
		if(bResult.hasErrors()) {
			List<ObjectError> list = bResult.getAllErrors();
			for(ObjectError error: list) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		
		boolean result = addressService.addAddress(vo);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}

	//사용자 배송지 수정
	@ApiOperation(value="사용자 배송지 수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="AddressVo", value ="카테고리 AddressVo", required=true, dataType="AddressVo", defaultValue="")
	})
	@PutMapping("/{no}")
	public ResponseEntity<JSONResult> AddressUpdate(@PathVariable(value="no") Long no,@RequestBody @Valid AddressVo vo) { 
		
		// no 값 세팅
		vo.setNo(no);
		
		boolean result = addressService.updateAddress(vo);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
		
	//사용자 배송지 삭제
	@ApiOperation(value="사용자 배송지 삭제")
	@DeleteMapping("/{no}")
	public ResponseEntity<JSONResult> AddressDelete(@PathVariable(value="no") Long no) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		boolean result = addressService.deleteAddress(no);
		
		
		map.put("result", result);
		map.put("no", no);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(map));
	}

	
	//사용자 배송지 조회
	@ApiOperation(value="사용자 배송지 목록 조회")
	@GetMapping("")
	public ResponseEntity<JSONResult> AddressList() {
		
		List<AddressVo> cList = addressService.showAddress();
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(cList));
	}
	
	
	
}



