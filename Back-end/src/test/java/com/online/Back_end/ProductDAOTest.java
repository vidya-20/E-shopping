package com.online.Back_end;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.online.dao.productDao;
import com.online.model.Product;

public class ProductDAOTest {
	static productDao productDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		productDAO = (productDao) context.getBean("productDAO");
	}

	@Test
	public void addProductTest() {
		Product product = new Product();

		product.setProductName("Samsung A8");
		product.setProductDesc("Smart Mobile from Samsung Brand with All Feature");
		product.setStock(20);
		product.setSupplierId(1);
		product.setCategoryId(1);
		product.setPrice(16000);

		assertTrue("Problem in Adding Product", productDAO.addProduct(product));

	}

	@Ignore
	@Test
	public void updateProductTest() {
		Product product = productDAO.getProduct(2);

		product.setPrice(11000);
		product.setStock(40);

		assertTrue("Problem in Updating Product", productDAO.updateProduct(product));
	}

	@Ignore
	@Test
	public void listProductsTest() {
		List<Product> productList = productDAO.listProducts();

		assertTrue("Problem in Retrieving the List of Products", productList.size() > 0);

		for (Product product : productList) {
			System.out.print(product.getProductId() + ":::");
			System.out.print(product.getProductName() + ":::");
			System.out.println(product.getPrice() + ":::");
		}
	}

	@Ignore
	@Test
	public void listProductsCategoryWiseTest() {
		List<Product> productList = productDAO.listProductsCategoryWise(1);

		assertTrue("Problem in Retrieving the List of Products", productList.size() > 0);

		System.out.println("==================Category Wise==================");
		for (Product product : productList) {
			System.out.print(product.getProductId() + ":::");
			System.out.print(product.getProductName() + ":::");
			System.out.println(product.getPrice() + ":::");
		}
	}
}
