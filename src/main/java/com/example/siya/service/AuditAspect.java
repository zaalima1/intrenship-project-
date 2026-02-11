package com.example.siya.service;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.siya.entity.AuditLog;
import com.example.siya.entity.Auditable;
import com.example.siya.repo.AuditLogRepository;

@Aspect
@Component
public class AuditAspect {

    private final AuditLogRepository repo;

    public AuditAspect(AuditLogRepository repo) {
        this.repo = repo;
    }

    @Around("@annotation(audit)")
    public Object auditMethod(
            ProceedingJoinPoint jp,
            Auditable audit
    ) throws Throwable {

        Object result = jp.proceed(); // run business logic FIRST

        try 
        {
        	AuditLog log = new AuditLog();
        	log.setModule(audit.module());
        	log.setAction(audit.action());
        	log.setMethodName(jp.getSignature().getName());
        	log.setParameters(Arrays.toString(jp.getArgs()));
        	log.setUsername("SYSTEM"); // later: logged-in user
        	log.setPerformedBy("SYSTEM");

        	repo.save(log);

           
        } catch (Exception e) {
            // NEVER break main flow
            System.err.println("Audit logging failed: " + e.getMessage());
        }

        return result;
    }
}
