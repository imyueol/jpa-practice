package com.greedy.section02.mapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntityMappingTests {
	
	private static EntityManagerFactory entityManagerFactory; // 싱글톤으로 만들어야하기 때문에 메모리에 미리 올려놓아야함-> static
	private EntityManager entityManager; // 요청 있을 때마다 생성할 것이므로 static x

	@BeforeAll
	public static void initFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
	}

	@BeforeEach
	public void initManager() {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@AfterAll
	public static void closeFactory() {
		entityManagerFactory.close();
	}

	@AfterEach
	public void closeManager() {
		entityManager.close();
	}
	
	@Test
	public void 상품_추가_테스트() {
		
		//given
		Product product1 = new Product();
		product1.setProductName("청자켓");
		product1.setProductPrice(10000);
		product1.setReleaseDate(new java.sql.Date(System.currentTimeMillis()));
		product1.setProductCategory(CategoryType.TOP.getDescription());
		product1.setProductCodeName("KGC-001");
		
		Product product2 = new Product();
		product2.setProductName("청바지");
		product2.setProductPrice(20000);
		product2.setReleaseDate(new java.sql.Date(System.currentTimeMillis()));
		product2.setProductCategory(CategoryType.PANTS.getDescription());
		product2.setProductCodeName("KGC-002");
		
		Product product3 = new Product();
		product3.setProductName("면바지");
		product3.setProductPrice(30000);
		product3.setReleaseDate(new java.sql.Date(System.currentTimeMillis()));
		product3.setProductCategory(CategoryType.PANTS.getDescription());
		product3.setProductCodeName("KGC-003");
		
		//when
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(product1);
		entityManager.persist(product2);
		entityManager.persist(product3);
		entityTransaction.commit();
		
	}
	
	

}
