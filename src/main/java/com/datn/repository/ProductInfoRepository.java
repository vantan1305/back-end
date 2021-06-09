package com.datn.repository;

import com.datn.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {
}
