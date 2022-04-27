package edu.multi.kdigital;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import other.OtherController;
import product.ProductController;
import product.ProductDAO;
import spring.mybatis.MemberDAO;
import spring.mybatis.MemberMybatisController;
import upload.UploadController;

@SpringBootApplication
@ComponentScan
@ComponentScan(basePackageClasses = OtherController.class)
//@ComponentScan(basePackageClasses = UploadController.class)
@ComponentScan(basePackages = {"upload"})
@ComponentScan(basePackageClasses = MemberMybatisController.class)
@MapperScan(basePackageClasses = MemberDAO.class)
@ComponentScan(basePackageClasses = ProductController.class)
@MapperScan(basePackageClasses = ProductDAO.class)

public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
		
	}

}
