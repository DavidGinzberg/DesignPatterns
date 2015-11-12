import java.lang.reflect.Constructor;

final class MySingleton{
  private static MySingleton instance;

  private MySingleton(){}
  
  public static MySingleton getInstance(){
    if(instance == null) instance = new MySingleton();

    return instance;
  }
}

public class SingletonPattern{

  public static void main(String []args){
  boolean privateConstructor;
  Singleton s1, s2;
  s1 = Singleton.getInstance();
  s2 = Singleton.getInstance();

  try{
    Constructor<MySingleton> singletonConstructor = MySingleton.class.getDeclaredConstructor();
    privateConstructor = !singletonConstructor.isAccessible();
  }
  catch(NoSuchMethodException e){
    System.out.println("Constructor not found");
    privateConstructor = false;
  }
  System.out.println((s1==s2 && privateConstructor?"Good job!":"Keep trying."));
  }
}
