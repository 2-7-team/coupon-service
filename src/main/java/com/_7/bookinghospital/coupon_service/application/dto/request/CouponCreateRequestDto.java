package com._7.bookinghospital.coupon_service.application.dto.request;

import com._7.bookinghospital.coupon_service.domain.model.CouponStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class CouponCreateRequestDto{
    private Long total_quantity;
    private CouponStatus status;
}

