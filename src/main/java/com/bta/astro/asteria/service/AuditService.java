package com.bta.astro.asteria.service;

import com.bta.astro.asteria.dto.IdDto;
import com.bta.astro.asteria.entity.Audit;
import com.bta.astro.asteria.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    public IdDto createAudit(Audit audit) {
        Audit createdAudit = auditRepository.save(audit);
        return new IdDto(createdAudit.getGuid());
    }
}
