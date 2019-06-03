package com.lgin.qb.phd.Repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lgin.qb.phd.model.Bill;



@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {


//	Optional<Bill> findByBillid(Long billid);

}
