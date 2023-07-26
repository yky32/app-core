package com.quinsic.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@Getter
@Setter
public class AuditEntityWithIsActive extends AuditEntity {
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @PrePersist
    private void isActive() {
        this.isActive = true;
    }
}