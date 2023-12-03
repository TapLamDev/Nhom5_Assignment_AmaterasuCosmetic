package com.poly.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.poly.entity.OrderDetail;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Products")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@Column(columnDefinition = "nvarchar(max)")
	@NotBlank(message = "{NotBlank.item.name}")
	String name;
	String image;
	@Min(value = 0, message = "{Min.item.price}")
	@NotNull(message = "{NotNull.item.price}")
	Double price;
	@Temporal(TemporalType.DATE)
	@Column(name = "Createdate")
	@NotNull(message = "{NotNull.item.createDate}")
	Date createDate = new Date();
	@NotNull(message = "{NotNull.item.available}")
	Boolean available;
	@Column(columnDefinition = "nvarchar(max)")
	String describe;
	@Column(name = "số lượng")
	int qty;
	int tonKho;
	@ManyToOne
	@JoinColumn(name = "Categoryid")
	Category category;
	@ManyToOne
	@JoinColumn(name = "Brandid")
	Brand brand;
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetails;
}
