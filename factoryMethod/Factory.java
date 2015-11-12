import java.util.ArrayList;

abstract class Employee {
  String name, type, paySchedule;
  public String getName(){return name;}
  abstract public String getPaySchedule();
}

class SalariedEmployee extends Employee{
  public SalariedEmployee(String name){
    this.name = name;
    this.type = "Salaried";
    this.paySchedule = "semi-monthly";
  }

  public String getPaySchedule(){
    return paySchedule;
  }
}

class Contractor extends Employee{
  public Contractor(String name){
    this.name = name;
    this.type = "Contract";
    this.paySchedule = "Hourly";
  }

  public String getPaySchedule(){
    return paySchedule;
  }
}

class EmployeeFactory {
  public Employee createEmployee(String name, String type){
    switch(type){
      case "salaried":
        return new SalariedEmployee(name);
      case "contract":
        return new Contractor(name);
      default:
        return null;
    }
  }
}

public class Factory{
  public static void main(String []args){
    EmployeeFactory factory = new EmployeeFactory();
    ArrayList<Employee> workforce = new ArrayList<>();
    String []names = {"John",
                      "Sue",
                      "James",
                      "Mary",
                      "Jo"};
    for(int i=0; i < 10; i++){
      workforce.add(factory.createEmployee(names[i%5], i%2==0?"salaried":"contract"));
    }

    for(Employee e :workforce){
      System.out.println(e.getName() + ":\t" + e.getPaySchedule());
    }
  }
}
