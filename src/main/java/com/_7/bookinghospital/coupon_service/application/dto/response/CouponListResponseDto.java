package com._7.bookinghospital.coupon_service.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CouponListResponseDto {
    private List<CouponResponseDto> coupons;
}
