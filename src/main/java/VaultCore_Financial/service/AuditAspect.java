<<<<<<< HEAD:src/main/java/com/example/siya/service/AuditAspect.java
package com.example.siya.service;
=======
package VaultCore_Financial.service;
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/service/AuditAspect.java

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

<<<<<<< HEAD:src/main/java/com/example/siya/service/AuditAspect.java
import com.example.siya.entity.AuditLog;
import com.example.siya.entity.Auditable;
import com.example.siya.repo.AuditLogRepository;
=======
import VaultCore_Financial.entity.AuditLog;
import VaultCore_Financial.entity.Auditable;
import VaultCore_Financial.repo.AuditLogRepository;

>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/service/AuditAspect.java

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
