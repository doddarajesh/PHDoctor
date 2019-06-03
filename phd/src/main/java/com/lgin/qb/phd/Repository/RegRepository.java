package com.lgin.qb.phd.Repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lgin.qb.phd.model.Reg;




@Repository
public interface RegRepository extends JpaRepository<Reg, Long>  {

    boolean existsByPassword(String password);
    
    boolean existsByEmail(String email);
	
    Optional<Reg> findByEmail(String email);
    
	boolean existsByMobilenumber(String mobilenumber);
	
	 @Query("select email from Reg") 
	 Optional<Reg> getAllEmail();

	boolean existsByCnfpass(String cnfpass);


	
//	void save(Accountsettings account);
	

}
