package com.johncnstn.data.repository;

import com.johncnstn.data.entity.ClientType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CleintTypeRepository extends JpaRepository<ClientType, Long> {
    ClientType findByType(String type);
}
