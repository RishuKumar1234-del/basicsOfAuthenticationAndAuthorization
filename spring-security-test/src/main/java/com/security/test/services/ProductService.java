package com.security.test.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.test.dto.Product;
import com.security.test.entity.UserInfo;
import com.security.test.repository.UserInfoRepo;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {
	
	List<Product> productList=null;
	
	@Autowired
	private UserInfoRepo unrepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void loadProductFromDB() {
		productList=new ArrayList<>();
		productList.add(new Product(101, "mobile", 2, 56000));
		productList.add(new Product(102, "tv", 1, 25000));
		productList.add(new Product(103, "AC", 1, 30000));
		productList.add(new Product(104, "home theater", 1, 45000));
		
	}
	
	public List<Product> getProducts(){
		
		return productList;
	}
	
	public Product getProductById(int pid){
		return productList.stream().filter(t->t.getPid()==pid).findAny()
				.orElseThrow(()->new RuntimeException("product with id " +pid +" is not found"));
	}
	
	
	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		unrepo.save(userInfo);
		
		return "user added to system";
		
	}
	
	

}
