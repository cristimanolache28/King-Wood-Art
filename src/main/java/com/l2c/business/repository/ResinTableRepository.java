package com.l2c.business.repository;

import com.l2c.business.entity.ResinTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResinTableRepository extends JpaRepository<ResinTable, Integer> {
}