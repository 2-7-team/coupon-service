package com._7.bookinghospital.coupon_service.application.service;

import com._7.bookinghospital.coupon_service.application.dto.request.CouponCreateRequestDto;
import com._7.bookinghospital.coupon_service.application.dto.request.CouponUpdateRequestDto;
import com._7.bookinghospital.coupon_service.application.dto.response.CouponDetailsResponse;
import com._7.bookinghospital.coupon_service.application.dto.response.CouponListResponseDto;
import com._7.bookinghospital.coupon_service.application.dto.response.CouponResponseDto;
import com._7.bookinghospital.coupon_service.application.mapper.CouponMapper;
import com._7.bookinghospital.coupon_service.domain.model.Coupon;
import com._7.bookinghospital.coupon_service.domain.repository.CouponRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;

    @Transactional
    public CouponResponseDto createCoupon(CouponCreateRequestDto request) {
        Coupon coupon = Coupon.create(request.getTotal_quantity(), request.getStatus());
        Coupon saved = couponRepository.save(coupon);
        return CouponMapper.toDto(saved);
    }

    @Transactional(readOnly = true)
    public CouponListResponseDto getAllCoupons() {
        List<Coupon> couponList = couponRepository.findAllAvailable();
        List<CouponResponseDto> dtoList = CouponMapper.toDtoList(couponList);
        return new CouponListResponseDto(dtoList);
    }

    @Transactional(readOnly = true)
    public CouponDetailsResponse getCouponDetails(UUID couponId) {
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(() -> new RuntimeException("Coupon not found"));

        return new CouponDetailsResponse(
                coupon.getId(),
                coupon.getTotal_quantity(),
                coupon.getStatus()
        );
    }

    @Transactional
    public CouponResponseDto updateCoupon(UUID id, CouponUpdateRequestDto dto) {
        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("쿠폰을 찾을 수 없습니다."));

        coupon.update(dto.getTotal_quantity(), dto.getStatus());
        return CouponMapper.toDto(coupon);
    }

    @Transactional
    public void deleteCoupon(UUID id) {
        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("쿠폰을 찾을 수 없습니다."));

        coupon.delete();
    }
}
