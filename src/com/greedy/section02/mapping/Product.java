package com.greedy.section02.mapping;

import java.sql.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name="mapping_product")
@Table(name="TBL_PRODUCT")
@TableGenerator(
		name="PRODUCT_SEQ_TABLE_GENERATOR",
		table="TBL_PRODUCT_SEQUENCES",
		pkColumnValue="MY_SEQ_PRODUCT_NO",	//PK 컬럼의 이름 지정
		// pkColumnName : 시퀀스 컬럼명 (기본 값은 SEQUENCE_NAME)
		// valueColumnName : 시퀀스 값 컬럼명 (기본 값은 NEXT_VAL)
		allocationSize=1
)
public class Product {
	
	@Id
	@Column(name="PRODUCT_NO")
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PRODUCT_SEQ_TABLE_GENERATOR")
	private int productNo;
	
	@Column(name="PRODUCT_NAME", nullable=false)
	private String productName;
	
	@Column(name="PRODUCT_PRICE", nullable=false)
	private int productPrice;
	
	@Column(name="RELEASE_DATE", nullable=false)
	private java.sql.Date releaseDate;
	
	@Column(name="PRODUCT_CODE_NAME", nullable=false)
	private String productCodeName;
	
	@Column(name="PRODUCT_CATEGORY", nullable=false)
	private String productCategory;
	
	public Product() {}

	public Product(int productNo, String productName, int productPrice, Date releaseDate, String productCodeName,
			String productCategory) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.releaseDate = releaseDate;
		this.productCodeName = productCodeName;
		this.productCategory = productCategory;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public java.sql.Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(java.sql.Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getProductCodeName() {
		return productCodeName;
	}

	public void setProductCodeName(String productCodeName) {
		this.productCodeName = productCodeName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", releaseDate=" + releaseDate + ", productCodeName=" + productCodeName + ", productCategory="
				+ productCategory + "]";
	}

	
	



}
