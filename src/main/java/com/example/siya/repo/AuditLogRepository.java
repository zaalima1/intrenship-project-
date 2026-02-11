package com.example.siya.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.siya.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}

