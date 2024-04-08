package com.bdd.sample.domain.service.exception;

import lombok.Getter;

public class Sample001NotFoundExecption extends  RuntimeException {
    @Getter
    private final String id;

   public Sample001NotFoundExecption(String  id)
  {
      //super(String.format("موجودیت با شناسه ی {1} پیدا نشد" , id));
      this.id = id;
  }
}
