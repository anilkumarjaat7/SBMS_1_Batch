package com.anil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anil.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public List<Student> findByName(String name);
	
	public List<Student> findByEmail(String email);
	
	public List<Student> findByPhone(String phone);
	

}



//1) CrudRepository ( I )
//2) JpaRepository ( I )

//JpaRepository ( I ) =  CrudRepository (I) + pageination + sorting + findByXX + CustomQuery




//  1. save(Entity)
//  2. saveAll()

// Note Above two methods are called as UPSERT method(UPDATE + INSERT)


//  3. FindById()
//  4 . FindAllById()
//  5. findAll
//  6. count
//  7. existById(id)
//  8. deleteById(Id)
//  9.  deleteAllById(Id)
//  10. deleteAll()