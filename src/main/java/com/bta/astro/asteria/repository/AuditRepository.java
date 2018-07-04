package com.bta.astro.asteria.repository;

import com.bta.astro.asteria.entity.Audit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends CrudRepository<Audit, String> {
}
