package com.bta.astro.asteria.audit;

import com.bta.astro.asteria.dto.IdDto;
import com.bta.astro.asteria.entity.Audit;
import com.bta.astro.asteria.service.AuditService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Aspect
@Component
public class AuditAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuditAspect.class);

    @Autowired
    private AuditService auditService;

    @Around("@annotation(audit)")
    public Object auditRequest(ProceedingJoinPoint proceedingJoinPoint, com.bta.astro.asteria.audit.Audit audit) throws Throwable {
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            Audit newAudit = new Audit.Builder()
                    .auditTimestamp(Instant.now())
                    .action(audit.action())
                    .actor("ME")
                    .method(proceedingJoinPoint.getSignature().getName())
                    .build();
            IdDto idDto = auditService.createAudit(newAudit);
            LOGGER.info("Created new audit event with guid {}", idDto.getId());
        }
    }
}
