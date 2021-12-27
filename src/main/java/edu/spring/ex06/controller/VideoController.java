package edu.spring.ex06.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/video")

public class VideoController {
   private static final Logger logger = 
         LoggerFactory.getLogger(VideoController.class);
 
   @GetMapping("/music")
   public void loginGet() {
      logger.info("musicGet() 호출");
   }
}