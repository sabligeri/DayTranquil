package com.codecool.men.myTest;

import com.codecool.men.myTest.MyTestAnimal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTest {

  @GetMapping("/api/test")
  public MyTestAnimal myTest() {
    MyTestAnimal animal = new MyTestAnimal("kiskutya");
    return animal;
  }

}
