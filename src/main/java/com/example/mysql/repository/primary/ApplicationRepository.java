package com.example.mysql.repository.primary;

import com.example.mysql.entity.primary.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * @author g1335333249
 */
@Transactional(rollbackOn = Exception.class)
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}
