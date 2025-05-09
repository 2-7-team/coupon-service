package com._7.bookinghospital.coupon_service.application.dto.response;

import com._7.bookinghospital.coupon_service.domain.model.CouponStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CouponDetailsResponse {
    private UUID id;
    private Long totalQuantity;
    private CouponStatus status;
}
