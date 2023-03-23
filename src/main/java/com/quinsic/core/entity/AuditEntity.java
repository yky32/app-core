package com.quinsic.core.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
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
    protected Date createAt;

    @Column(name = "created_by")
    @CreatedBy
    protected UUID createdBy;

    @Column(name = "update_dt")
    @LastModifiedDate
    protected Date updateAt;

    @Column(name = "updated_by")
    @LastModifiedBy
    protected UUID updatedBy;
}