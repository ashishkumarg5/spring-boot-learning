package com.example.demo.repo1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model1.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer>{

}
