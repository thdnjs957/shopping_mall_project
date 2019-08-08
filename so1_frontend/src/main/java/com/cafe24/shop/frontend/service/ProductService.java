package com.cafe24.shop.frontend.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.shop.frontend.dto.JSONResult;
import com.cafe24.shop.frontend.vo.CategoryVo;
import com.cafe24.shop.frontend.vo.ProductVo;

@Service
public class ProductService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	private static final String SAVE_PATH = "/shop-uploads";
	private static final String URL = "/images";

	public List<ProductVo> getProductList(){
		
		String endpoint = "http://localhost:8080/so1_backend/api/product/";
		
		JSONResultProductList jsonResult = restTemplate.getForObject(endpoint, JSONResultProductList.class);
		
		return jsonResult.getData();
	}
	
	public List<ProductVo> getProductList(Long no){
		
		String endpoint = "http://localhost:8080/so1_backend/api/product/"+no;
		
		JSONResultProductList jsonResult = restTemplate.getForObject(endpoint, JSONResultProductList.class);
		
		return jsonResult.getData();
	}
	
	public List<CategoryVo> getCategoryList(){
		
		String endpoint = "http://localhost:8080/so1_backend/api/admin/category/";
		
		JSONResultCategoryList jsonResult = restTemplate.getForObject(endpoint, JSONResultCategoryList.class);
		
		return jsonResult.getData();
	}
	
	public ProductVo getProduct(Long no1, Long no2) {
		
		String endpoint = "http://localhost:8080/so1_backend/api/product/"+no1+"/"+no2;

		JSONResultProduct jsonResult = restTemplate.getForObject(endpoint, JSONResultProduct.class);
		
		System.out.println(jsonResult.getData());
		return jsonResult.getData();
	}
	
	public Boolean registProduct(ProductVo productVo) {
		String endpoint = "http://localhost:8080/so1_backend/api/admin/product/register";
		JSONResultProductReceive jsonResult = restTemplate.postForObject(endpoint,productVo,JSONResultProductReceive.class);
		
		return jsonResult.getData();
	}
	
	// DTO Class
	private static class JSONResultProductList extends JSONResult<List<ProductVo>> {
	}
	
	private static class JSONResultCategoryList extends JSONResult<List<CategoryVo>> {
	}
	
	private static class JSONResultProduct extends JSONResult<ProductVo> {
	}
	
	private static class JSONResultProductReceive extends JSONResult<Boolean> {
	}


	public String restore(MultipartFile multipartFile) {
		
		String url = "";

		try {
			if(multipartFile.isEmpty()) {
				return url;
			}
			
			String originalFilename = 
					multipartFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf('.')+1);
			String saveFileName = generateSaveFileName(extName);
			long fileSize = multipartFile.getSize();
			
			System.out.println("##########" + originalFilename);
			System.out.println("##########" + extName);
			System.out.println("##########" + saveFileName);
			System.out.println("##########" + fileSize);
			
			byte[] fileData = multipartFile.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
			os.write(fileData);
			os.close();
			
			url = URL + "/" + saveFileName;
			
		} catch (IOException e) {
			throw new RuntimeException("Fileupload error:" + e);
		}
		
		return url;
	}
	
	private String generateSaveFileName(String extName) {
		
		String filename = "";
		Calendar calendar = Calendar.getInstance();
		
		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += ("." + extName);
		
		return filename;
	}
}

