
class CustomPart implements Cloneable{
  
  private int value;

  public CustomPart(int x){
    value = x;
    try{
      Thread.sleep(4000);
    }catch(InterruptedException e){
      System.out.println("Sleep interrupted");
    }
  }

  public getValue(){
    return value;
  }

  public Object clone(){
    Object obj = null;
    try {
      obj = super.clone();
    } catch (CloneNotSupportedException x) {

    }
    return obj;
  }

}

class Manufacturer{

  CustomPart prototype;

  public Manufacturer(){
    prototype = null;
  }

  public CustomPart createPrototype(){
    return new CustomPart();
  }

  public void submitPrototype(CustomPart proto){
    prototype = proto;
  }

  public CustomPart massProduce(){
    if(prototype == null) return null;
    return prototype.clone();
  }
}

public class Prototype{
  public static void main(String []args){
  
  CustomPart proto = null;
  CustomPart []inventory = new CustomPart[10];

  System.out.println("Developing Prototype.");
  for(int i=0; i < 5; i++){
    proto = new CustomPart();
  }
  System.out.println("Prototype complete. Beginning mass production.");
  for(int i = 0; i<10; i++){
    inventory[i] = (CustomPart) proto.clone();
  }
  System.out.println("inventory full");
    
  }
}
