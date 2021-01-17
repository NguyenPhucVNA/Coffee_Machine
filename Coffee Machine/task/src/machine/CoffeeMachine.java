package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private   int water = 400;
    private   int milk = 540;
    private   int coffeeBeans = 120;
    private   int disposableCups = 9;
    private   int money = 550;
    static  CoffeeMachine machine = new CoffeeMachine();
    public int getWater() {
        return water;
    }
    public void setWater(int water) {
        this.water = water;
    }
    public int getMilk() {
        return milk;
    }
    public void setMilk(int milk) {
        this.milk = milk;
    }
    public int getCoffeeBeans() {
        return coffeeBeans;
    }
    @Override
    public String toString() {
        return "The coffee machine has:\n"+water+ " of water\n"+milk+ " of milk\n" +coffeeBeans +" of coffee beans\n"+ disposableCups+" of disposable cups\n"+money +" of money";
    }
    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }
    public int getDisposableCups() {
        return disposableCups;
    }
    public void setDisposableCups(int disposableCups) {
        this.disposableCups = disposableCups;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    final static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        choosePath();
    }
    private static void choosePath(){
            boolean run = true;
          while (run) {
              System.out.println("Write action (buy, fill, take, remaining, exit): ");
              switch (in.next().toLowerCase()) {
                  case "take":
                      take();
                        break;
                  case "fill":
                      fill();
                      break;
                  case "buy":
                      buy();
                      break;
                  case "remaining":
                      System.out.println(machine.toString());
                      break;
                  case "exit":
                       run =false;
              }
          }
      }
    private static void buy(){
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
            int choice =0;
            try{
             choice = Integer.parseInt(in.next());}
            catch (NumberFormatException e){
             e.printStackTrace();
            }
       switch (choice){
           case 1: espresso();break;
           case 2: latte();break;
           case 3 : cappuccino();break;
       }
    }
    private static void take(){

        System.out.println("i gave you $" + machine.getMoney());
        machine.setMoney(0);
    }
    private static void fill(){
        System.out.println("Write how many ml of water do you want to add: ");
        int water = in.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        int milk = in.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int beans = in.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int disposableCups = in.nextInt();
        calFill(water,milk,beans,disposableCups);


    }
    private static void calOrder(int water, int milk, int beans, int disposableCups, int money){
        int count= 0;
        if(machine.getWater()-water >=0){
           count++;
        }
        else
            System.out.println("Sorry, not enough water!");

        if(machine.getMilk()-milk >=0){

            count++;
        }
        else
            System.out.println("Sorry, not enough milk!");

        if(machine.getCoffeeBeans()-beans >=0){

            count++;
        }
        else
            System.out.println("Sorry, not enough coffee beans!");

        if(machine.getDisposableCups()-disposableCups >=0){

            count++;
        }
        else
            System.out.println("Sorry, not enough disposable cups!");


        if(count==4){
            System.out.println("I have enough resources, making you a coffee!");
            machine.setWater(machine.getWater() - water);
            machine.setMilk(machine.getMilk() - milk);
            machine.setCoffeeBeans(machine.getCoffeeBeans()- beans);
            machine.setDisposableCups(machine.getDisposableCups() - disposableCups);
            machine.setMoney(machine.getMoney() + money);
        }


    }
    private static void latte() {
            int water = 350;
            int milk = 75;
            int beans = 20;
            int disposableCups =1;
            int money = 7;
        calOrder(water,milk,beans,disposableCups,money);
    }
    private static void cappuccino() {
        int water = 200;
        int milk = 100;
        int beans = 12;
        int disposableCups =1;
        int money = 6;
        calOrder(water,milk,beans,disposableCups,money);
    }
    private static void espresso(){
        int water = 250;
        int milk = 0;
        int beans = 16;
        int disposableCups =1;
        int money = 4;
        calOrder(water,milk,beans,disposableCups,money);
    }
    private static void calFill(int water, int milk, int beans, int disposableCups) {
        machine.setWater(machine.getWater() + water);
        machine.setMilk(machine.getMilk() + milk);
        machine.setCoffeeBeans(machine.getCoffeeBeans() + beans);
        machine.setDisposableCups(machine.getDisposableCups() + disposableCups);
    }

}
