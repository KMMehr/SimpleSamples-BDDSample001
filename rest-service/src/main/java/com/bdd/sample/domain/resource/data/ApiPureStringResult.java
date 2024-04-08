package com.bdd.sample.domain.resource.data;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class ApiPureStringResult {

    public ApiPureStringResult()  {  }

    public ApiPureStringResult(String message)  {
        this.message=message;
    }

    private String message;
}
