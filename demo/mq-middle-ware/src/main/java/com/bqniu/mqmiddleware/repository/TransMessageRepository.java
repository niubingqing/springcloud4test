package com.bqniu.mqmiddleware.repository;

import com.bqniu.mqmiddleware.dataobject.TransMessageInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransMessageRepository extends JpaRepository<TransMessageInfo,String> {
    void findAllById(String id);
}
