package com._7.bookinghospital.coupon_service.infrastructure.repository.jpa;

import com._7.bookinghospital.coupon_service.domain.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CouponJpaRepository extends JpaRepository<Coupon, UUID> {
    List<Coupon> findByIsDeletedFalse();
}
