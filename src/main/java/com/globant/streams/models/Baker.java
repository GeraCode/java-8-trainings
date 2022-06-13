package com.globant.streams.models;

import java.util.List;

public class Baker {
  private String name;
  private List<String> recipes;
  private int age;

  public Baker(String name, List<String> recipes, int age) {
    this.name = name;
    this.recipes = recipes;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getRecipes() {
    return recipes;
  }

  public void setRecipes(List<String> recipes) {
    this.recipes = recipes;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Baker{" +
        "name='" + name + '\'' +
        ", recipes=" + recipes +
        ", age=" + age +
        '}';
  }
}
