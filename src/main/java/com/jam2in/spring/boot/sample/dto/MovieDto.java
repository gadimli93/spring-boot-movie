package com.jam2in.spring.boot.sample.dto;

import java.io.Serializable;

public class MovieDto implements Serializable {

  private Long id;

  private String movName;

  private Integer movYear;

  private String movLang;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMovName() {
    return movName;
  }

  public Integer getMovYear() { return movYear; }

  public String getMovLang() { return movLang; }

  public void setMovName(String movName) {
    this.movName = movName;
  }

  public void setMovYear(Integer movYear) { this.movYear = movYear; }
  public void setMovLang(String movLang) { this.movLang = movLang; }

  @Override
  public String toString() {
    return "MovieDto{" +
        "id=" + id +
        ", movName='" + movName + '\'' +
        ", movYear=" + movYear +
        ", movLang='" + movLang + '\'' +
        '}';
  }
}
