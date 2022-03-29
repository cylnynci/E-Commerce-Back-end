package com.example.northwind.Api.Controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.Business.Abstracts.ProductService;
import com.example.northwind.Core.Utilities.Results.DataResult;
import com.example.northwind.Core.Utilities.Results.Result;
import com.example.northwind.Entities.Concretes.Product;
import com.example.northwind.Entities.dtos.ProductWithCategoryDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.GetAll();
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product){
		return this.productService.Add(product);	
	}	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
		System.out.println(productName);
		System.out.println(categoryId);
	return this.productService.getByProductNameAndCategoryId(productName,categoryId);
	}	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
	      return this.productService.getByProductNameContains(productName);
	}	
	@GetMapping("/GetAllByPage")
	DataResult<List<Product>> GetAll(int pageNo,int pageSize){
		return this.productService.GetAll(pageNo, pageSize);
	}	
	@GetMapping("/GetAllDesc")
	public DataResult<List<Product>> GetAllSorted(){
		return this.productService.GetAllSorted();
	}
	
}
	

	
//kodlama.io/api/products