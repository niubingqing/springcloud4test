package com.bqniu.capdemo.core.repository;

import com.bqniu.capdemo.core.entity.TransShadow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TCCRepository extends JpaRepository<TransShadow,Integer> {
}
