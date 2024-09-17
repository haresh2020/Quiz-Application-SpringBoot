package com.example.store.respository;

import com.example.store.product.Product;
import com.example.store.product.QuestionDTO;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.store.product.Quest;

import java.util.List;


public interface Respository extends JpaRepository<Product,Integer>{
    @Query(value="Select password from login_Detail where user_Id=:a",nativeQuery=true)
     String findbyUserId(String a);

//    @Query(value="Select stream from login_Detail where user_Id=:b",nativeQuery=true)
//    String findStream(String b);

//    select new com.foo.bar.entity.Document(d.docId, d.filename) from Document d where d.filterCol = ?1
    @Query(value="Select Questionno,Question from question  Where Stream=:c",nativeQuery=true)
    List<QuestionDTO> getQues(String c);
}
