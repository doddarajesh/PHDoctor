package com.lgin.qb.phd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.stereotype.Repository;

import com.lgin.qb.phd.model.FileModel;




@Repository
public interface FileRepository extends JpaRepository<FileModel,Long>{


}
