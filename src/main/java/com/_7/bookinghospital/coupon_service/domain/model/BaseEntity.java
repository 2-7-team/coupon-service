package com._7.bookinghospital.coupon_service.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    protected LocalDateTime createdAt;

    @CreatedBy
    protected Long createdBy;

    @LastModifiedDate
    protected LocalDateTime updatedAt;

    @LastModifiedBy
    protected Long updatedBy;

    protected boolean isDeleted;

    public void delete(Long deletedBy) {
        this.isDeleted = true;
    }
}

