package edu.spring.ex06.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/introduce")

public class ProcessController {
   private static final Logger logger = 
         LoggerFactory.getLogger(ProcessController.class);
 
   @GetMapping("/process")
   public void loginGet() {
      logger.info("processGet() 호출");
   }
}