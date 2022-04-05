package com.spring.boot.fundamentals.springbootfundamentals.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
  @RequestMapping
  @ResponseBody
  public ResponseEntity<String> test() {
    return new ResponseEntity<String>("Hello World", HttpStatus.OK);
  }
}
