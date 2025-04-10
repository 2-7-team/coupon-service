package com._7.bookinghospital.coupon_service.presentation.controller;

import com._7.bookinghospital.coupon_service.application.dto.request.CouponCreateRequestDto;
import com._7.bookinghospital.coupon_service.application.dto.request.CouponUpdateRequestDto;
import com._7.bookinghospital.coupon_service.application.dto.response.CouponDetailsResponse;
import com._7.bookinghospital.coupon_service.application.dto.response.CouponListResponseDto;
import com._7.bookinghospital.coupon_service.application.dto.response.CouponResponseDto;
import com._7.bookinghospital.coupon_service.application.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/coupons")
public class CouponController {

    private final CouponService couponService;

    @PostMapping
    public CouponResponseDto createCoupon(@RequestBody CouponCreateRequestDto requestDto) {
        return couponService.createCoupon(requestDto);
    }

    @GetMapping
    public ResponseEntity<CouponListResponseDto> getAllCoupons() {
        CouponListResponseDto response = couponService.getAllCoupons();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @GetMapping("/{couponId}")
    public CouponDetailsResponse getCouponDetails(@PathVariable UUID couponId) {
        return couponService.getCouponDetails(couponId);
    }

    @PatchMapping("/{couponId}")
    public CouponResponseDto updateCoupon(@PathVariable UUID couponId,
                                          @RequestBody CouponUpdateRequestDto requestDto) {
        return couponService.updateCoupon(couponId, requestDto);
    }

    @DeleteMapping("/{couponId}")
    public void deleteCoupon(@PathVariable UUID couponId) {
        couponService.deleteCoupon(couponId);
    }
}
