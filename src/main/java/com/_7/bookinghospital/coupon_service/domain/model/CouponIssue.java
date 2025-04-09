package com._7.bookinghospital.coupon_service.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "p_coupon_issues")
public class CouponIssue extends BaseEntity {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "coupon_id", columnDefinition = "BINARY(16)", nullable = false)
    private UUID couponId;

    @Column(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    private UUID userId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CouponIssueStatus status;

    @Builder
    public CouponIssue(UUID couponId, UUID userId, CouponIssueStatus status) {
        this.id = UUID.randomUUID();
        this.couponId = couponId;
        this.userId = userId;
        this.status = status;
    }
}

