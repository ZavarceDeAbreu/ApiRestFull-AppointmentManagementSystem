package com.kodo.inventorysystem.models;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import com.kodo.inventorysystem.models.enums.Position;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class User {

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private Long id;

	@Column(nullable = false, length = 60)
	private String name;

	@Column(nullable = false, length = 3)
	private Integer age;

	@Column(nullable = false)
	private Position position;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate creationDate;
	
	@UpdateTimestamp
	private Timestamp updateAt;

	private boolean deleted = false;
}
