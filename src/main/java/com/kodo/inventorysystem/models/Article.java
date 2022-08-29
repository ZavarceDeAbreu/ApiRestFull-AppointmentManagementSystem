package com.kodo.inventorysystem.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "articles")
@SQLDelete(sql = "UPDATE articles SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Article {

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private Long id;

	@Column(nullable = false, length = 100, unique = true)
	private String name;

	@Column(nullable = false)
	private Integer amount;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfAdmission;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User user;

	private boolean deleted = false;
}
