package com.example.mysql.repository.secondary;

import com.example.mysql.entity.secondary.Application2;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * @author g1335333249
 */
@Transactional(rollbackOn = Exception.class)
public interface ApplicationRepository2 extends JpaRepository<Application2, Integer> {}
