package com.security.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.test.dto.Product;
import com.security.test.services.ProductService;

@RestController
@RequestMapping("/Product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/test")
	public String welcome() {
		
		return "welcome this endpoint is not  secure!!";
	}
	
	@GetMapping("/products")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Product> getAllProducts(){
		
		return  productService.getProducts();
	}
	
	
	@GetMapping("/products/{pid}")
	@PreAuthorize("hasAuthority('ROLE_FIRSTUSER')")
	public Product getProductBYId(@PathVariable int pid) {
		
		return productService.getProductById(pid);
	}

}
