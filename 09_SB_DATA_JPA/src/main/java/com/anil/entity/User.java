package com.anil.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String  name;
	
	@Column(unique = true, nullable = false, length = 150)
	private String email;
	
	@Column(nullable = false)
	private Integer age;
	
	@Column(nullable = false)
	private double hight;
	
	  @CreationTimestamp
	  @Column(nullable = false , updatable = false)
	    private LocalDateTime createdAt;

	    @UpdateTimestamp
	    @Column(nullable = false)
	    private LocalDateTime updatedAt;
	    
	    

}
