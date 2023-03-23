package com.quinsic.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;


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