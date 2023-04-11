package com.greedy.section01.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CRUD {
	
	private static EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	@BeforeAll
	public static void initFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("gctest");
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
	public void 카테고리코드_조회_테스트() {
		
		//given
		int categoryCode = 4; // int categoryCode = 1; 기본자료형 int 에는 null값 들어가지 못해서 오류남, 오류 안나려면 참조형 Integer를 사용
		//when
		Category category = entityManager.find(Category.class, categoryCode);
		
		//then
		assertNotNull(category);
		assertEquals(categoryCode, category.getCategoryCode());
	}
	
	@Test
	public void 새로운_카테고리_추가_테스트() {
		
		//given
		Category category = new Category();
		category.setCategoryName("양식");
		category.setRefCategoryCode(1);
		
		//when
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			entityManager.persist(category);
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
			e.printStackTrace();
		}
		
		//then
		assertTrue(entityManager.contains(category));
	}
	
	@Test
	public void 카테고리_이름_수정_테스트() {
		
		//given
		Category category = entityManager.find(Category.class, 21);    //find(  , pk값 )
		System.out.println("category = " + category);
		
		String categoryNameToChange = "하이미디어";
		
		//when
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			category.setCategoryName(categoryNameToChange);
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
			e.printStackTrace();
		}
		
		//then
		assertEquals(categoryNameToChange, entityManager.find(Category.class, 21).getCategoryName());
	}
	
	@Test
	public void 카테고리_삭제하기_테스트() {
		
		//given
		Category categoryToRemove = entityManager.find(Category.class, 22);
		
		//when
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			entityManager.remove(categoryToRemove);
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
			e.printStackTrace();
		}
		
		//then
		Category removeCategory = entityManager.find(Category.class, 22);
		assertEquals(null, removeCategory);
	}
	
	
	
	
	

}
