package com._7.bookinghospital.coupon_service.application.dto.response;

import com._7.bookinghospital.coupon_service.domain.model.CouponStatus;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class CouponResponseDto {
    private UUID id;
    private Long total_quantity;
    private CouponStatus status;
}
