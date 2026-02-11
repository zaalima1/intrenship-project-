package com.example.siya.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.siya.repo.AuditLogRepository;

@Controller
@RequestMapping("/audit")
public class AuditLogController {

    private final AuditLogRepository auditRepo;

    public AuditLogController(AuditLogRepository auditRepo) {
        this.auditRepo = auditRepo;
    }

    @GetMapping("/audit-logs")
    public String viewAuditLogs(Model model) {
        model.addAttribute("logs", auditRepo.findAll());
        return "audit-logs";
    }
}
