<<<<<<< HEAD:src/main/java/com/example/siya/controller/AuditLogController.java
package com.example.siya.controller;
=======
package VaultCore_Financial.controller;
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/controller/AuditLogController.java

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD:src/main/java/com/example/siya/controller/AuditLogController.java
import com.example.siya.repo.AuditLogRepository;

@Controller
@RequestMapping("/audit")
public class AuditLogController {

    private final AuditLogRepository auditRepo;

    public AuditLogController(AuditLogRepository auditRepo) {
        this.auditRepo = auditRepo;
=======
import VaultCore_Financial.implement.AuditLogService;

@Controller
@RequestMapping("/admin")
public class AuditLogController {

    private final AuditLogService auditLogService;

    public AuditLogController(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/controller/AuditLogController.java
    }

    @GetMapping("/audit-logs")
    public String viewAuditLogs(Model model) {
<<<<<<< HEAD:src/main/java/com/example/siya/controller/AuditLogController.java
        model.addAttribute("logs", auditRepo.findAll());
=======
        model.addAttribute("logs", auditLogService.getAllAuditLogs());
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/controller/AuditLogController.java
        return "audit-logs";
    }
}
