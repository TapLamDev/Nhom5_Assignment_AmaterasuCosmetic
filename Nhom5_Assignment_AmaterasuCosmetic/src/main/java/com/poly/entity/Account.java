package com.poly.entity;

import java.io.Serializable;

import java.util.Date;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Table(name = "Accounts")
public class Account implements Serializable {

	/* @NotBlank(message = "Vui lòng nhập username") */
	@Id
	private String username;

	/* @NotBlank(message = "Vui lòng nhập password") */
	private String password;

	@Column(columnDefinition = "nvarchar(max)")
	/* @NotEmpty(message = "Vui lòng nhập họ tên") */
	private String fullname;

	/*
	 * @NotBlank(message = "Vui lòng nhập số điện thoại")
	 * 
	 * @Size(min = 10, max = 10, message = "Số điện thoại phải có 10 chữ số")
	 * 
	 */
	// @Pattern(regexp = "^[0-9]{10}$", message = "Số điện thoại không hợp lệ")
	private String numberPhone;

	/*
	 * @Size(min = 12, max = 12, message = "Căn cước công dân phải có đủ 12 số")
	 * 
	 * @Pattern(regexp = "^[0-9]{12}$", message = "Căn cước công dân không được chứa chữ")
	 */
//	@Column(name = "Căn cước công dân")
//	private String CCCD;


	/* @NotBlank(message = "Vui lòng nhập địa chỉ") */
	@Column(columnDefinition = "nvarchar(max)")
	private String address;

	@Temporal(TemporalType.DATE)
	private Date birthDay = new Date();

	/*
	 * @NotBlank(message = "Vui lòng nhập email")
	 * 
	 * @Email(message = "Email sai định dạng")
	 */
	private String email;
	
	/* @NotNull(message = "Trạng thái hoạt động không được bỏ trống") */	
	private boolean activated;
	
	/* @NotNull(message = "Role không được bỏ trống") */
	@Column(name = "Role")
	private boolean admin;
	private String image;
}
