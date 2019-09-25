package com.mrq.backend.repository;

import com.mrq.backend.entity.CashierEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashierRepository extends CrudRepository<CashierEntity,Long> {
    CashierEntity findByCounterName(String name);
    CashierEntity findByCashierId(String id);
}

