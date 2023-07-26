package com.quinsic.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


@MappedSuperclass
@Getter
@Setter
@EntityListeners(value = AuditingEntityListener.class)
public class AuditEntity implements Serializable {
    @Version
    @Column(name = "version")
    protected int version;

    @Column(name = "create_dt")
    @CreatedDate
    protected Date createDt;

    @Column(name = "created_by")
    @CreatedBy
    protected UUID createdBy;

    @Column(name = "update_dt")
    @LastModifiedDate
    protected Date updateDt;

    @Column(name = "updated_by")
    @LastModifiedBy
    protected UUID updatedBy;
}