package com.globant.streams;

import com.globant.streams.models.Baker;
import com.globant.streams.models.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicStreamExample {

  public static void main(String[] args) {
    List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
    long count = strList.stream() .filter(x -> x.isEmpty()) .count();
    System.out.println("empty strings: "+count);

//    createBasicStream();
//    useCollectors();
//    useIntermediateOperations();
//    useReductionOnStreams();
    usageOfParallelStream();
  }

  /**
   * This method contains several ways to create a Stream
   */
  public static void createBasicStream() {
    System.out.println("--Creation of Streams--");
    /* Create a Stream of Strings*/
    Stream<String> names = Stream.of("Ana", "Anibal", "Diego", "Pedro", "Uriel");

    /* Create a Stream of integers from 1 to 10*/
    IntStream.range(1, 10).forEach(System.out::print);

    /* Create a Stream based on an array*/
    Stream<Integer> streamByArray = Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    streamByArray.forEach(System.out::print);

    /* Create a Stream based on varargs*/
    Stream<Integer> streamByVarArgs = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    /*Create a stream from a list*/
    List<Integer> numbersIntoList = new ArrayList<Integer>() {{
      add(1);
      add(2);
      add(3);
      add(4);
      add(5);
    }};
    Stream<Integer> streamByCollection = numbersIntoList.stream();
    streamByCollection.forEach(System.out::print);

    /*Create stream via generate method*/
    Stream.generate(() -> (new Random()).nextInt(100));
    Stream<Integer> streamViaIterator = Stream.iterate(1, a -> a + 1);
    streamViaIterator.limit(10).forEach(System.out::print);
  }

  /**
   * Method to review Collectors
   */
  public static void useCollectors() {
    System.out.println("\n--Usage of Collectors--");
    /*Basic examples of collectors*/
    List<String> names = Arrays.asList("Diego", "Uriel", "Mari", "Tino");
    List<String> filteredNames = names.stream().filter(name -> name.equals("Diego")).collect(Collectors.toList());
    //This method toList() will return a unmodifiable list but until java version 16
    //names.stream().filter(name -> name.equals("Diego")).toList();
    names.stream().filter(name -> name.equals("Diego")).collect(Collectors.toList());
    names.stream().filter(name -> name.equals("Diego")).collect(Collectors.toCollection(ArrayList::new));
    String joinedNames = names.stream().collect(Collectors.joining("- "));
    System.out.println(joinedNames);

    /*Examples with employees and collectors*/
    List<Employee> employees = getEmployeesList();

    /*Next collect invocation will group employees by department*/
    Map<String, List<Employee>> employeesGroupedByDepartment = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment));

    /*Next collect invocation will group employees by department and will print the total salary by department*/
    Map<String, Integer> salariesGroupedByDepartment = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));

    System.out.println(employeesGroupedByDepartment);
    System.out.println(salariesGroupedByDepartment);

    /*Next collect invocation will bring the employee with max salary among our employees list*/
    Optional<Employee> collect = employees.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
    collect.ifPresent(System.out::println);
  }

  /**
   * Method to review Intermediate Operations
   */
  public static void useIntermediateOperations() {
    List<Employee> employees = getEmployeesList();

    List<String> names = new ArrayList<>();
    names.add("Diego");
    names.add("Diego");
    names.add("Alejandro");
    names.add("Ruben");
    List<String> distinctNames = names.stream().distinct().collect(Collectors.toList());
    System.out.println(distinctNames);
    /*Example for sorted*/
    List<Employee> sortedEmployeesBySalary = employees.stream().sorted(Comparator.comparing(Employee::getSalary))
        .collect(Collectors.toList());
    System.out.println(sortedEmployeesBySalary);
    /*Example for map*/
    Stream<Integer> employeeSalaries = employees.stream().map(Employee::getSalary);
    System.out.println(employeeSalaries);

    /*Example for flatMap*/
    List<Baker> bakers = new ArrayList<>();
    bakers.add(new Baker("Benito", Arrays.asList("Donut", "Cheescake", "Apple pie"), 25));
    bakers.add(new Baker("Giancarlo", Arrays.asList("Almond Malai Kulfi", "Lemon tart", "Pistachio Phirni"), 28));
    bakers.add(new Baker("Manolo", Arrays.asList("Low Fat Tiramisu", "Coconut Kheer"), 22));

    List<String> recipes = bakers.stream().flatMap(baker -> baker.getRecipes().stream()).collect(Collectors.toCollection(ArrayList::new));
    System.out.println(recipes);

    Optional<Baker> max = bakers.stream().max(Comparator.comparing(Baker::getAge));
    Optional<Baker> min = bakers.stream().min(Comparator.comparing(Baker::getAge));

    Optional<Baker> firstBaker = bakers.stream().findFirst();
    boolean giancarloExist = bakers.stream().noneMatch(baker -> baker.getName().equals("Giancarlo"));

  }

  /**
   * Method which implements the terminal operation for reduction
   */
  public static void useReductionOnStreams() {
    System.out.println("\n--Usage of reduction on Streams--");
    /*Using summaryStatistics to reduce IntStream*/
    IntSummaryStatistics intSummaryStatistics = IntStream.range(1, 20).summaryStatistics();
    System.out.println(intSummaryStatistics.getAverage());
  }

  /**
   * Method which implements finalOperations
   */
  public static void useFinalOperations() {
    List<Employee> employees = getEmployeesList();
    /*Usage of foreach as terminal operation in stream*/
    employees.stream().forEach(System.out::println);
    /*Usage of collect as terminal operation in stream*/
    employees.stream().collect(Collectors.toList());
    /*Usage for reducing stream*/
    employees.stream().count();
    employees.stream().max(Comparator.comparing(Employee::getSalary));
    employees.stream().min(Comparator.comparing(Employee::getSalary));

  }

  private static List<Employee> getEmployeesList() {
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee("Diego", "Development", 20));
    employees.add(new Employee("Sara", "Sales", 21));
    employees.add(new Employee("Alejandro", "Development", 10));
    return employees;
  }

  /**
   * This methods will print how thread are executing each task on the stream
   */
  public static void usageOfParallelStream() {
    System.out.println("\n--Usage of parallel Streams--");
    /*Normal/Sequential Stream*/
    List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
    /*listOfNumbers.stream().forEach(number ->
        System.out.println(number + " " + Thread.currentThread().getName())
    );*/

    /*Parallel Stream executing several threads */
    listOfNumbers.parallelStream().forEach(number ->
        System.out.println(number + " " + Thread.currentThread().getName())
    );

    /*Incorrect Usage for parallel stream with reductions*/
    List<Integer> listOfNumbersForReduction = Arrays.asList(1, 2, 3, 4);
    int sum = listOfNumbers.parallelStream().reduce(5, Integer::sum);
    System.out.println("Sum of reduction operation:" + sum);
    assert sum != 15;

    int correctSum = listOfNumbers.parallelStream().reduce(0, Integer::sum) + 5;
    System.out.println("Sum of reduction operation:" + correctSum);
    assert sum == 15;

  }

}


