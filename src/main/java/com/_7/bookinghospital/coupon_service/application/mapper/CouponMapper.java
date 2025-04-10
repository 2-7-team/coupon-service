package com._7.bookinghospital.coupon_service.application.mapper;

import com._7.bookinghospital.coupon_service.application.dto.request.CouponCreateRequestDto;
import com._7.bookinghospital.coupon_service.application.dto.response.CouponResponseDto;
import com._7.bookinghospital.coupon_service.domain.model.Coupon;

import java.util.List;
import java.util.stream.Collectors;

public class CouponMapper {

    public static Coupon toEntity(CouponCreateRequestDto dto) {
        return Coupon.create(dto.getTotal_quantity(), dto.getStatus());
    }

    public static CouponResponseDto toDto(Coupon coupon) {
        return CouponResponseDto.builder()
                .id(coupon.getId())
                .total_quantity(coupon.getTotal_quantity())
                .status(coupon.getStatus())
                .build();
    }

    public static List<CouponResponseDto> toDtoList(List<Coupon> couponList) {
        return couponList.stream()
                .map(CouponMapper::toDto)
                .collect(Collectors.toList());
    }
}
