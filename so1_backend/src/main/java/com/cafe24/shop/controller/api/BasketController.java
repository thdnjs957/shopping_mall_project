package com.cafe24.shop.controller.api;

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
import com.cafe24.shop.vo.BasketVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("basketAPIController")
@RequestMapping("/api/basket")
public class BasketController {
	
	@Autowired
	private BasketService basketService;
	
	//사용자 장바구니 담기
	@ApiOperation(value="사용자 장바구니 담기")
	@ApiImplicitParams({
		@ApiImplicitParam(name="BasketVo", value ="장바구니 BasketVo", required=true, dataType="BasketVo", defaultValue="")
	})
	@PostMapping("/register")
	public  ResponseEntity<JSONResult> BasketRegister(@RequestBody List<BasketVo> bvoList ,BindingResult bResult) {
		
		boolean result = basketService.addBasket(bvoList);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}

	//장바구니 상품 존재 유무 체크
	@ApiOperation(value="장바구니 상품 존재 유무 체크")
	@ApiImplicitParams({
		@ApiImplicitParam(name="BasketVo", value ="장바구니 BasketVo", required=true, dataType="BasketVo", defaultValue="")
	})
	@PostMapping("/check")
	public  ResponseEntity<JSONResult> BasketCheck(@RequestBody List<BasketVo> bvoList ,BindingResult bResult) {
		
		boolean result = false;
		
		for(BasketVo vo : bvoList ) {
			Long no = vo.getPro_option_no();
			if(basketService.checkBasket(no)) 
				result = true;
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	

	//사용자 장바구니 리스트
	@ApiOperation(value="장바구니 리스트 조회")
	@ApiImplicitParams({
		@ApiImplicitParam(name="BasketVo", value ="장바구니 BasketVo", required=true, dataType="BasketVo", defaultValue="")
	})
	@PostMapping("")
	public  ResponseEntity<JSONResult> BasketList(@RequestBody BasketVo vo) {
		
		List<Map<String, Object>> bv = basketService.showBasket(vo); 
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(bv));
	}
	
	
	//사용자 장바구니 수정
	@ApiOperation(value="사용자 장바구니 수정")
	@PutMapping("")
	public ResponseEntity<JSONResult> BasketUpdate(@RequestBody @Valid BasketVo vo,BindingResult bResult) {
		
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
	@ApiOperation(value="사용자 장바구니 삭제")
	@DeleteMapping("/{no}")
	public ResponseEntity<JSONResult> BasketDelete(@PathVariable(value="no") Long no) {
		
		boolean result = basketService.deleteBasket(no);
		if(!result) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("입력 형식이 유효하지 않습니다."));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	
	
}
