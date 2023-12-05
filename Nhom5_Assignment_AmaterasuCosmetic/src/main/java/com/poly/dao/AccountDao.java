package com.poly.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.Account;

public interface AccountDao extends JpaRepository<Account, String> {
<<<<<<< HEAD
//	Account findByUsername(String username);
//	
=======
	
	Account findByUsername(String username);

>>>>>>> branch 'masters' of https://github.com/TapLamDev/Nhom5_Assignment_AmaterasuCosmetic
//	@Query("SELECT o FROM Account o WHERE o.username = :username AND o.email = :email")
//	Account findByUsernameAndEmail(@Param("username") String username, @Param("email") String email);
<<<<<<< HEAD
//	
//	Page<Account> findAll(Pageable pageable);
//	
////	@Query("SELECT o FROM Account WHERE activated = true")
////	Page<Account> findByActived(Pageable pageable);
//	
//	
	@Query("SELECT count(o) FROM Account o")
	Integer getCount();
=======

	Page<Account> findAll(Pageable pageable);

//	@Query("SELECT o FROM Account WHERE activated = true")
//	Page<Account> findByActived(Pageable pageable);
//
//	@Query("SELECT count(o) FROM Account o")
//	Integer getCount();
	
>>>>>>> branch 'masters' of https://github.com/TapLamDev/Nhom5_Assignment_AmaterasuCosmetic
}
