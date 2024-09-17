package com.example.store.respository;

import com.example.store.product.Quest;
import com.example.store.product.QuestionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Quest,Integer> {
    @Query(value="Select questionno,question,Option1,Option2,Option3,Option4,Answer from question where Stream=:c",nativeQuery=true)
    List<Object[]> getQues(String c);
}
