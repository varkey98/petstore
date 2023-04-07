package controller;

import entities.TestEntity;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

  @QueryMapping
  public TestEntity init() {
    System.out.println("I'm here!");
    TestEntity ret = new TestEntity();
    ret.setVal(5);
    return ret;
  }
}
