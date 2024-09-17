package com.example.store.service;

import com.example.store.product.*;
import com.example.store.respository.QuestionRepository;
import com.example.store.respository.Respository;
import com.example.store.respository.ResultRepository;
import com.example.store.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    @Autowired
    private  Respository respository;
    @Autowired
    private QuestionRepository questionRepo;
    @Autowired
    private ResultRepository resultRepository;
//    @Autowired
//    public Check checkclass;
    public Product add(Product product){
        return respository.save(product);
    }

    public boolean check(Check c){
        String Password=respository.findbyUserId(c.getUserId());
        System.out.println(Password);
        System.out.println(c.getPassword());
        if(Password.equals(c.getPassword())){
//            String stream=respository.findStream(c.getUserId());
            return true;
        }
        return false;
    }

//    public String uploadImage(MultipartFile file){
//        respository.save(ImageData.)
//    }

//    public List<Quest> get(String stream){
//       return questionRepo.findAll();
//    }
    public List<QuestionDTO> get(String Stream){
        List<QuestionDTO> questList = new ArrayList<>();
        List<Object[]> questions = questionRepo.getQues(Stream);
        for(Object[] obj : questions){
            QuestionDTO questDto = new QuestionDTO();
            if(obj[0]!=null){
                questDto.setQuestionno((int)obj[0]);
            }
            if(obj[1]!=null){
                questDto.setQuestion(String.valueOf(obj[1]));
            }
            if(obj[2]!=null){
                questDto.setOption1(String.valueOf(obj[2]));
            }
            if(obj[3]!=null){
                questDto.setOption2(String.valueOf(obj[3]));
            }
            if(obj[4]!=null){
                questDto.setOption3(String.valueOf(obj[4]));
            }
            if(obj[5]!=null){
                questDto.setOption4(String.valueOf(obj[5]));
            }
            if(obj[6]!=null){
                questDto.setAnswer(String.valueOf(obj[6]));
            }
            questList.add(questDto);
        }
        return questList;

//        List<QuestionDTO> l=new ArrayList<>();
//        List<QuestionDTO> s=new ArrayList<>();
//        for(QuestionDTO q:ques){
//            QuestionDTO m=new QuestionDTO(q.getQuestionno(),q.getQuestion());
////            m.setQuestionno(q.getQuestionno());
////            m.setQuestion(q.getQuestion());
//            l.add(m);
        }
//        System.out.print(l);
//        return l;
//    }
//    public Product find(int id){
//        return respository.findById(id).orElse(null);
//    }
//
//    public Product update(int id,Product updatedProduct) {
//        Product existingProduct = respository.findById(id).orElseThrow(null);
//        existingProduct.setName(updatedProduct.getName());
//        existingProduct.setAge(updatedProduct.getAge());
//        return respository.save(existingProduct);
//    }
//
//    public String Delete(int id){
//        respository.deleteById(id);
//        return "Deleted";
//    }


//    public String UploadImage(MultipartFile
//                               file){
//        respository.save(Image.)
//    }


   public String getEmail(String userId){
       return resultRepository.getEmail(userId);
   }

    public String saveResult(Result result){
        resultRepository.save(result);
        return "Success";
    }

    public List<ResultData> getResult(int mark){
        List<ResultData> results=new ArrayList<>();
        List<Object[]> result= resultRepository.getResult(mark);
        for(Object[] obj:result){
            ResultData data=new ResultData();
            if(obj[0]!=null){
                data.setSno((int)obj[0]);
            }
            if(obj[1]!=null){
                data.setEmail(String.valueOf(obj[1]));
            }
            if(obj[2]!=null){
                data.setResult((int)obj[2]);
            }
           results.add(data);
        }
        return results;
    }

//    @Autowired
//    public JavaMailSender mailsender;
//
//    public String sendmail(String tomail,String subject,String body){
//        SimpleMailMessage mailMessage=new SimpleMailMessage();
//        mailMessage.setFrom("hareshsit2020@gmail.com");
//        mailMessage.setTo(tomail);
//        mailMessage.setSubject("It works Fine");
//        mailMessage.setText(body);
//        mailsender.send(mailMessage);
//
//        return "Sucess";
//    }

}
