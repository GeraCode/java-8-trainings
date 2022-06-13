package com.globant.streams;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *The intention of this class is showing how parallelStream is more benefit under certain criteria
 */
public class ParallelStreamExample {

  private static final String DIR = "C:/test/";

  public static void main(String[] args) throws IOException {
    Files.createDirectories(Paths.get(DIR));

    ParallelStreamExample obj = new ParallelStreamExample();

    List<Employee> employees = obj.generateEmployee(5000);

    // normal, sequential //83218 ms
    //employees.stream().forEach(ParallelExample5::save);

    // parallel //61340 ms
    long initialTime = System.currentTimeMillis();
    employees.parallelStream().forEach(ParallelStreamExample::save);
    long finalTime = System.currentTimeMillis();
    System.out.println(finalTime - initialTime);
  }

  /**
   * This method saves a new employee generated randomly into a txt file
   * @param input employee to be saved
   * */
  private static void save(Employee input) {
    try (FileOutputStream fos = new FileOutputStream(DIR + input.getName() + ".txt");
        ObjectOutputStream obs = new ObjectOutputStream(fos)) {
      obs.writeObject(input);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private List<Employee> generateEmployee(int num) {

    return Stream.iterate(0, n -> n + 1)
        .limit(num)
        .map(x -> new Employee(
            generateRandomName(4),
            generateRandomAge(15, 100),
            generateRandomSalary(900.00, 200_000.00)
        ))
        .collect(Collectors.toList());

  }

  private String generateRandomName(int length) {

    return new Random()
        .ints(5, 97, 122) // 97 = a , 122 = z
        .mapToObj(x -> String.valueOf((char) x))
        .collect(Collectors.joining());

  }

  private int generateRandomAge(int min, int max) {
    return new Random()
        .ints(1, min, max)
        .findFirst()
        .getAsInt();
  }

  private BigDecimal generateRandomSalary(double min, double max) {
    return new BigDecimal(new Random()
        .doubles(1, min, max)
        .findFirst()
        .getAsDouble()).setScale(2, RoundingMode.HALF_UP);
  }
  class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private BigDecimal salary;

    public Employee() {}

    public Employee(String name, int age, BigDecimal salary) {
      this.name = name;
      this.age = age;
      this.salary = salary;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public BigDecimal getSalary() {
      return salary;
    }

    public void setSalary(BigDecimal salary) {
      this.salary = salary;
    }

    @Override
    public String toString() {
      return "Employee{" +
          "name='" + name + '\'' +
          ", age=" + age +
          ", salary=" + salary +
          '}';
    }
  }
}

