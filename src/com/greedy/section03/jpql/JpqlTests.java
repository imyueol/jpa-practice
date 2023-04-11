package com.greedy.section03.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class JpqlTests {
	
	 private static EntityManagerFactory entityManagerFactory;
	    private EntityManager entityManager;

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
	    public void 특정_EMP_ID를_가진_사원_조회() {
	    	
	    	String jpql = "SELECT m FROM section03_employee m WHERE m.empId = :empId";
	    	List<Employee> employeeList = entityManager.createQuery(jpql, Employee.class)
	    			.setParameter("empId", "200")
	    			.getResultList();
	    	
	    	System.out.println(employeeList);
	    	
	    	
	    }
	    
	    @Test
	    public void 새로운_사원_등록() {
	    	
	    	//given
	    	Employee employee = new Employee();
	    	employee.setEmpId("300");
	    	employee.setEmpName("김규철");
	    	employee.setEmpNo("990415-1000000");
	    	employee.setEmail("imyueol000@gmail.com");
	    	employee.setPhone("01099998888");
	    	employee.setJobCode("J1");
	    	employee.setSalLevel("S1");
	    	employee.setSalary(30000000);
	    	employee.setBonus(null);
	    	employee.setHireDate(new java.sql.Date(System.currentTimeMillis()));
	    	employee.setEntDate(new java.sql.Date(System.currentTimeMillis()));
	    	employee.setEntYn("N");
	    	employee.setDepartment(entityManager.find(Department.class, "D9"));
	    	
	    	//when
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(employee);
			entityTransaction.commit();
	    	
	    }
	    
	    @Test
	    public void 새로운_부서_등록_and_해당_부서에_등록된_사원_등록() {
	    	
	    	//given
	    	Department department = new Department();
	    	department.setDeptId("D0");
	    	department.setDeptTitle("코딩부");
	    	department.setLocationId("L1");
	    	
	    	Employee employee = new Employee();
	    	employee.setEmpId("301");
	    	employee.setEmpName("김규찬");
	    	employee.setEmpNo("990416-1000000");
	    	employee.setEmail("imyueol999@gmail.com");
	    	employee.setPhone("01077778888");
	    	employee.setJobCode("J1");
	    	employee.setSalLevel("S1");
	    	employee.setSalary(30000000);
	    	employee.setBonus(null);
	    	employee.setHireDate(new java.sql.Date(System.currentTimeMillis()));
	    	employee.setEntDate(new java.sql.Date(System.currentTimeMillis()));
	    	employee.setEntYn("N");
	    	employee.setDepartment(entityManager.find(Department.class, "D0"));
	    	
	    	EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(employee);
			entityTransaction.commit();
	    }
	    
	    @Test
	    public void 전체사원조회() {
	    	
	    	String jpql = "SELECT m FROM section03_employee m ";
	    	List<Employee> employeeList = entityManager.createQuery(jpql, Employee.class).getResultList();
	    	
	    	System.out.println(employeeList);
	    }
	    
	    @Test
	    public void 하씨_성을_가진_사원_조회() {
	    	
	    	String jpql = "SELECT m FROM section03_employee m WHERE m.empName LIKE '하%'";
	    	List<Employee> employeeList = entityManager.createQuery(jpql, Employee.class).getResultList();
	    	
	    	System.out.println(employeeList);
	    	
	    }
	
	
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

}
