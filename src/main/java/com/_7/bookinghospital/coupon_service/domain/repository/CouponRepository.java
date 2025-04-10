package com._7.bookinghospital.coupon_service.domain.repository;

import com._7.bookinghospital.coupon_service.domain.model.Coupon;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CouponRepository {
    List<Coupon> findAllAvailable();
    Optional<Coupon> findById(UUID id);
    void deleteById(UUID id);
    Coupon save(Coupon coupon);
}