package com.bqniu.mqmiddleware.repository;

import com.bqniu.mqmiddleware.dataobject.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRegisterRepository extends JpaRepository<ServiceRegisterInfo,String> {
}
