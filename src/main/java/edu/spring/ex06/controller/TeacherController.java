package edu.spring.ex06.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/introduce")

public class TeacherController {
   private static final Logger logger = 
         LoggerFactory.getLogger(TeacherController.class);
 
   @GetMapping("/teacher")
   public void loginGet() {
      logger.info("teacherGet() 호출");
   }
}