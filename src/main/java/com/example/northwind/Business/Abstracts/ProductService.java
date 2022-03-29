package com.example.northwind.Business.Abstracts;

import java.util.List;

import com.example.northwind.Core.Utilities.Results.DataResult;
import com.example.northwind.Core.Utilities.Results.Result;
import com.example.northwind.Entities.Concretes.Product;
import com.example.northwind.Entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	
	DataResult<List<Product>> GetAll();
	DataResult<List<Product>> GetAllSorted();
	DataResult<List<Product>> GetAll(int pageNo,int pageSize);
	Result Add(Product product);
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategoryId(String productName,int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName,int categoryId);

	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
	DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
 }

