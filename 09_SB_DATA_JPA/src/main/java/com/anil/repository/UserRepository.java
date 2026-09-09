package com.anil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.anil.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

//	findByXXX
//	Select * from users where name="sonu"
Optional<User>	findByName(String name);

Optional<User>	findByEmail(String email);

// AND  OR  NOT

Optional<User>	findByEmailAndName(String name,String email);

	List<User> findByAgeGreaterThan(Integer age);
	
	List<User> findByAgeLessThan(Integer age);
	
//	HQL , SQL
	
//	SQL : "SELECT * FROM USERS where name = NAME"
//	HQL : SELECT u FROM USERs u where u.name = name"
	
//	 @Query("SELECT u FROM User u WHERE u.name = :name")
	@Query(value ="SELECT * FROM USERS   where name = :name" , nativeQuery = true)
	List<User> searchByName(@Param("name") String name);
	
	
	@Query("UPDATE User u SET u.age = :age where u.id = :id")
	int updateAge(@Param("id") Integer id, @Param("age") Integer age);

}
