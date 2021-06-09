package com.datn.repository;

import com.datn.entity.Brand;
import com.datn.entity.Product;
import com.datn.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
    void deleteAllByBrand(Brand brand);

    @Query("select pro from Product pro where pro.status like '%new' ")
    List<Product> getProductNew();

    @Query("select p from Product p where p.brand.id = :id1 and p.productType.id = :id2 ")
    List<Product> getProductByBrandAndProductType(Long id1, Long id2);


    @Query("select pro from Product pro where pro.status like '%sale' ")
    List<Product> getProductSale();

    @Query("select p from  Product p join  Brand br on p.brand.id = br.id" +
            " where br.id = :id or p.brand.id = :id")
    List<Product> getAllByBrands(Long id);

    //@Query("select p from Product p where lower(p.name) like concat('%', :name, '%')")
    @Query("select p from Product p where lower(p.name) like concat('%', :name, '%')")
    List<Product>search (String name);

    //bạn ê có câu lệnh nào n tự truy vấn dc k

}
