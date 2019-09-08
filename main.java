import java.util.Random;

import javax.print.attribute.standard.PrinterMessageFromOperator;

import java.util.ArrayList;
import java.util.Collections;

class Main {

  public final static int MIN = 1;
  public final static int MAX = 42;
  public final static int NUMBER_TO_GENERATE = 10000;
  private ArrayList<Integer> myRandomNumbers;
  private ArrayList<Integer> group;
  private ArrayList<Integer> mostPopularNumbers;
  private Random random;

  public Main() {
    myRandomNumbers = new ArrayList<Integer>();
    group = new ArrayList<Integer>();
    mostPopularNumbers = new ArrayList<Integer>();
    random = new Random(System.currentTimeMillis());


    // initialise group totals
    for (int i = 0; i < MAX; i++) {
      group.add(0);
    }
  }

  public ArrayList<Integer> getMyRandomNumbers() {
    return this.myRandomNumbers;
  }

  public ArrayList<Integer> getGroupNumbers(){
    return this.group;
  }

  public ArrayList<Integer> getMostPopularNumbers() {
    return this.mostPopularNumbers;
  }

  public void addNumToRandomNumbers(int num) {
    this.myRandomNumbers.add(num);
  }

  public void addNumToGroupNumbers(int num) {
    this.group.add(num);
  }

  public void addNumberToMostPopularNumbers(int num) {
    this.mostPopularNumbers.add(num);
  }

  public void printRandomNumbers() {
    for (int i: this.myRandomNumbers) {
      System.out.println(i);
    }
  }

  public void sortRandomNumbers() {
    Collections.sort(this.myRandomNumbers);
  }

  public void groupRandomNumbers() {
    /*
    loop through the random number list as currentNumber
      add 1 to the group total in group list at index currentNumber - 1
    */    
    int currentNumber = 0;
    for (int i = 0; i < myRandomNumbers.size(); i++) {
      currentNumber = this.myRandomNumbers.get(i);
      group.set(currentNumber - 1, group.get(currentNumber - 1) + 1);      
    }
  }

  public void printGroupNumbers() {
    for (int i = 0; i < MAX; i++) {
      System.out.println("Number " + (i + 1) + " occurs " + group.get(i) + " times");
    }
  }

  public static void main(String[] args) {
    Main main = new Main();
    int num = -1;
    for (int i=0; i < NUMBER_TO_GENERATE; i++) {
      num = main.random.nextInt(MAX - MIN + 1) + MIN;
      main.addNumToRandomNumbers(num);
    }
    System.out.println("Generating " + NUMBER_TO_GENERATE + " random numbers between " + MIN + " and " + MAX + "...");
    //main.sortRandomNumbers();
    //main.printRandomNumbers();
    //System.out.println("###");
    main.groupRandomNumbers();
    main.printGroupNumbers();
  }

}
