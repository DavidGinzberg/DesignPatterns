import java.util.Observable;
import java.util.Observer;

class FoodTruck extends Observable{

}

class FoodTruckTracker implements Observer{

  public void update(Observable obs, Object o){
  	
  }
  
}

class FoodTruckCounter implements Observer{

  private int count;
  public FoodTruckCounter(){
  	count = 0;
  }

  public void update(Observable obs, Object o){

  }


}


public class FoodTruckObserver{

  public static void main(String []args){

  }
}

