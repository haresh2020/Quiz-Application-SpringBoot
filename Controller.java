package com.example.store.controller;

import com.example.store.product.*;
import com.example.store.respository.Respository;
import com.example.store.service.ProductService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class Controller {
    @Autowired
    private Respository respository;
    @Autowired
    private ProductService productservice;
    @GetMapping("/world")
    public String World(){
        return "Welcome1";
    }

    @PostMapping("api/task")
    public Product createTask(@RequestBody Product product){
//        System.out.print(product);
//          return respository.save(product);
        return productservice.add(product);
    }

    @PostMapping("/check")
    public boolean check(@RequestBody Check check){
        return productservice.check(check);
    }


    @PostMapping("/ques")
    public List<QuestionDTO> getQUes(@RequestBody String stream){
        List<QuestionDTO> q=new ArrayList<>();
        return productservice.get(stream);
    }

//    @PostMapping("/result")
//   public String submitResult(@RequestBody Result result){
//        System.out.print(result.getIdno());
//        productservice.saveResult(result);
//        return "Success";
//   }


    @PostMapping("/getEmail")
    public String getEmail(@RequestBody String userId){
        String email=productservice.getEmail(userId);
        System.out.println(email);
        return email;
    }

    @PostMapping("/result")
   public String submitResult(@RequestBody Result result){
        productservice.saveResult(result);
        return "Success";
   }

   @PostMapping("/getResult")
   public List<ResultData> getResult(@RequestBody String mark){
        return productservice.getResult(Integer.parseInt(mark));
   }
//    @DeleteMapping("api/task/{id}")
//    public String Delete(@PathVariable int id){
//         productservice.Delete(id);
//         return "Deleted";
//    }
//
//    @GetMapping("api/{id}")
//    public Product find(@PathVariable int id){
//        return productservice.find(id);
//    }
//
//    @PatchMapping("/api/test/{id}")
//    public Product update(@PathVariable int id,@RequestBody Product updatedProduct) {
//        return productservice.update(id,updatedProduct);
//    }

//@PostMapping("sendMail")
//public String sendMail(@RequestBody Mailcheck mail){
//      productservice.sendmail(mail.getTomail(),mail.getSubject(),mail.getBody());
//      return "Success";
//}

}


