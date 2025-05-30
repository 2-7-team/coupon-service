package com._7.bookinghospital.coupon_service.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "p_coupon")
public class Coupon extends BaseEntity{

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false)
    private Long total_quantity;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CouponStatus status;

    @Builder
    public Coupon(Long total_quantity, CouponStatus status) {
        this.id = UUID.randomUUID();
        this.total_quantity = total_quantity;
        this.status = status;
    }

    public static Coupon create(Long total_quantity, CouponStatus status) {
        return Coupon.builder()
                .total_quantity(total_quantity)
                .status(status)
                .build();
    }

    public void update(Long totalQuantity, CouponStatus status) {
        this.total_quantity = totalQuantity;
        this.status = status;
    }

    public void delete() {
        this.isDeleted = true;
    }
}