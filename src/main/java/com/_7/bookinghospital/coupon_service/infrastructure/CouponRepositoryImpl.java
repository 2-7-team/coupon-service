package com._7.bookinghospital.coupon_service.infrastructure;

import com._7.bookinghospital.coupon_service.domain.model.Coupon;
import com._7.bookinghospital.coupon_service.domain.repository.CouponRepository;
import com._7.bookinghospital.coupon_service.infrastructure.repository.jpa.CouponJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CouponRepositoryImpl implements CouponRepository {

    private final CouponJpaRepository couponJpaRepository;

    @Override
    public List<Coupon> findAllAvailable() {
        return couponJpaRepository.findByIsDeletedFalse();
    }

    @Override
    public Optional<Coupon> findById(UUID id) {
        return couponJpaRepository.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        couponJpaRepository.deleteById(id);
    }

    @Override
    public Coupon save(Coupon coupon) {
        return couponJpaRepository.save(coupon);
    }
}
