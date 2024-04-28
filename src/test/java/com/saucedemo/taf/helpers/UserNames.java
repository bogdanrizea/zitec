package com.saucedemo.taf.helpers;

public enum UserNames {
  STANDARD_USER("standard_user"),
  LOCKED_OUT_USER("locked_out_user"),
  PROBLEM_USER("problem_user"),
  PERFORMANCE_GLITCH_USER("performance_glitch_user"),
  ERROR_USER("error_user"),
  VISUAL_USER("visual_user");

  public final String userName;

  private UserNames(String userName) {
    this.userName = userName;
  }
}
