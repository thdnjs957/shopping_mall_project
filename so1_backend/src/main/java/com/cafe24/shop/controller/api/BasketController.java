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
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shop.dto.JSONResult;
import com.cafe24.shop.service.BasketService;
import com.cafe24.shop.vo.AddressVo;
import com.cafe24.shop.vo.BasketVo;
import com.cafe24.shop.vo.ProductOptionVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("basketAPIController")
@RequestMapping("/api/basket")
public class BasketController {
	
	@Autowired
	private BasketService basketService;

	@PostMapping("/getNo")
	public  ResponseEntity<JSONResult> ProductOptiongetNo(@RequestBody ProductOptionVo vo) {
		
		ProductOptionVo pov = basketService.getProductOptionNo(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(pov));
		
	}
	
	//장바구니 담기
	@ApiOperation(value="장바구니 담기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="BasketVo", value ="장바구니 BasketVo", required=true, dataType="BasketVo", defaultValue="")
	})
	@PostMapping("/register")
	public  ResponseEntity<JSONResult> BasketRegister(@RequestBody List<BasketVo> bvoList ,BindingResult bResult) {
		
		//만약에 bvoList 확인했을때 이미 같은 품목이 들어가있으면 add 가 아니라 update 해줌
//		for(BasketVo vo : bvoList ) {
//			vo.
//		}
		
		//basketService.updateBasket(bvo);
		
		basketService.addBasket(bvoList);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(true));
	}


	//사용자 장바구니 리스트
	@ApiOperation(value="사용자 장바구니 리스트 조회")
	@ApiImplicitParams({
		@ApiImplicitParam(name="BasketVo", value ="장바구니 BasketVo", required=true, dataType="BasketVo", defaultValue="")
	})
	@GetMapping("")
	public  ResponseEntity<JSONResult> BasketList() {
		
		List<Map<String, Object>> bv = basketService.showBasket(9L); 
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(bv));
	}
	
	//사용자 장바구니 수정
	@ApiOperation(value="사용자 장바구니 수정")
	@PutMapping("")
	public ResponseEntity<JSONResult> AddressUpdate(@RequestBody @Valid BasketVo vo,BindingResult bResult) {
		
		if(bResult.hasErrors()) {
			List<ObjectError> list = bResult.getAllErrors();
			for(ObjectError error: list) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		
		boolean result = basketService.updateBasket(vo);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
		
	//사용자 배송지 삭제
//	@ApiOperation(value="사용자 배송지 삭제")
//	@DeleteMapping("/{no}")
//	public ResponseEntity<JSONResult> AddressDelete(@PathVariable(value="no") Long no) {
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		
//		boolean result = addressService.deleteAddress(no);
//		
//		
//		map.put("result", result);
//		map.put("no", no);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(map));
//	}
	
	
	
}
