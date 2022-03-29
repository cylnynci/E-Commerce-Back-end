package com.example.northwind.DataAccess.Abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.northwind.Entities.Concretes.Product;
import com.example.northwind.Entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product,Integer>{
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);

	List<Product> getByCategoryIn(List<Integer> categories);
	//select * from products where category_id in(1,2,3,4)
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName,int categoryId);
	
	@Query("Select new com.example.northwind.Entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	
	//select p.productId,p.productName,c.categoryName from Category c inner
	//on c.categoryId=p.categoryId;
}
