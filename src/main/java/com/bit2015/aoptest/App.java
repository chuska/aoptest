package com.bit2015.aoptest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit2015.aoptest.service.ProductService;
import com.bit2015.aoptest.vo.ProductVo;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"config/applicationContext.xml");
		ProductService productService = (ProductService) applicationContext
				.getBean("productService");
		ProductVo vo = productService.findProduct("TV");
	}
}
