package com._7.bookinghospital.coupon_service.presentation.controller;

import com._7.bookinghospital.coupon_service.application.service.CouponService;
import com._7.bookinghospital.coupon_service.domain.model.Coupon;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/coupons")
public class CouponController {

    private final CouponService couponService;

    //dto 네이밍?
    @PostMapping
    public ResponseEntity<Void> createCoupon(@RequestBody CreateCouponRequest request) {
        couponService.createCoupon(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<CouponListResponse> getAllCoupons() {
        CouponListResponse response = couponService.getAllCoupons();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{coupon/id}")
    public ResponseEntity<CouponDetailReponse> getCouponById(@PathVariable("coupon_id") UUID couponId) {
        CouponDetailReponse reponse = couponService.getCouponDetails(couponId);
        return ResponseEntity.ok(reponse);
    }

    @PatchMapping("/{coupon_id}")
    public ResponseEntity<Void> updateCoupon(@PathVariable("coupon_id") UUID couponId,
                                             @RequestBody UpdateCouponRequest request) {
        couponService.updateCoupon(couponId, request);
        return ResponseEntity.noContent().build();
    }

    //리턴값?
    @DeleteMapping("/{coupon_id}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable("coupon_id") UUID couponId) {
        return null;
    }
}
