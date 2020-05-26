package com.projectiyzico.repository;

import com.projectiyzico.entity.Shopping;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingRepository extends CrudRepository<Shopping,Long> {
    @Query(value="select * from shopping where id = (select max(id) from shopping);",nativeQuery = true)
    public Shopping findLastShopping();




}
