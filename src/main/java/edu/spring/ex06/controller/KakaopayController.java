package edu.spring.ex06.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/kakao")
public class KakaopayController {

      private static final Logger logger = LoggerFactory.getLogger(KakaopayController.class);
   @PostMapping("/pay")   
   @ResponseBody
   public String kakaoPay() {
      logger.info("kakaoPay()호출");
      try {
         URL adress = new URL("https://kapi.kakao.com/v1/payment/ready");
         HttpURLConnection connect = (HttpURLConnection) adress.openConnection();
         connect.setRequestMethod("POST");
         connect.setRequestProperty("Authorization", "KakaoAK 8733dd176b6dcd5720084dda63020353");
         connect.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
         connect.setDoOutput(true);
         String parameter = "cid=TC0ONETIME&partner_order_id=partner_order_id&partner_user_id=partner_user_id&item_name=onedayClass&quantity=10&total_amount=5000&tax_free_amount=0&approval_url=https://localhost:8080/ex06/&cancel_url=https://localhost:8080/ex06/product/list/&fail_url=https://localhost:8080/ex06/product/list";
         OutputStream give = connect.getOutputStream();
         DataOutputStream dataGive = new DataOutputStream(give);
         dataGive.writeBytes(parameter);
         dataGive.close();
         
         int result = connect.getResponseCode();
         
         InputStream take;
         if(result == 200) {
            take = connect.getInputStream();
         }else {
            take = connect.getErrorStream();
         }
         InputStreamReader reader = new InputStreamReader(take);
         
         BufferedReader parse = new BufferedReader(reader); 
         return parse.readLine();
          
      } catch (MalformedURLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return "https://localhost:8080";
      
      
      
   }
   
}