package com.example.store.respository;

import com.example.store.product.Result;
import com.example.store.product.ResultData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

public interface ResultRepository extends JpaRepository<Result,Integer> {

    @Query(value = "Select email from loginDetail where user_id=:userId",nativeQuery = true)
    public String getEmail(String userId);

    @Query(value = "Select sno,email,result from result where result>=:mark",nativeQuery = true)
     List<Object[]> getResult(int mark);
}
