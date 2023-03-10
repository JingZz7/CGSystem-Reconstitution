package com.zhiyixingnan.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

  private Boolean flag;

  private Object data;

  public Result(Boolean flag) {
    this.flag = flag;
  }

  public Result(Object data) {
    this.data = data;
  }
}
