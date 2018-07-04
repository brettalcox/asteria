package com.bta.astro.asteria.performance;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class PerformanceLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceLogAspect.class);

    @Around("@annotation(performanceLog)")
    public Object logPerformance(ProceedingJoinPoint proceedingJoinPoint, PerformanceLog performanceLog) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try {
            return proceedingJoinPoint.proceed();
        } catch (Exception e) {
            stopWatch.stop();
            LOGGER.info("Time to execute {}: {} ms (Exception was thrown)", proceedingJoinPoint.getSignature().getName(), stopWatch.getTotalTimeMillis());
            throw e;
        } finally {
            stopWatch.stop();
            LOGGER.info("Time to execute {}: {} ms", proceedingJoinPoint.getSignature().getName(), stopWatch.getTotalTimeMillis());
        }
    }
}
