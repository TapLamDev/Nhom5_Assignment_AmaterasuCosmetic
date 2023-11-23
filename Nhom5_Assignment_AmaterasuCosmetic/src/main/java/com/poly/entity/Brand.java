package com.poly.entity;

import java.io.Serializable;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Brands")
@Validated
public class Brand implements Serializable {
	@Id
	String id;
	@Column(columnDefinition = "nvarchar(max)")
	String name;
	@Column(columnDefinition = "nvarchar(max)")
	String image;
	@OneToMany(mappedBy = "brand")

	List<Product> products;

}
