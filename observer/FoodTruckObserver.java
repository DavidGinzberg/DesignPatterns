import java.util.Observable;
import java.util.Observer;
import java.util.HashMap;

/**
 * Location - A simple immutable object representing a 2-tuple of x and y coordinates
 **/
final class Location{
	final private int x, y;

	public Location(int xPos, int yPos){
		x = xPos;
		y = yPos;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public String toString(){
		return "(" + x + "," + y + ")";
	}

	public boolean equals(Object o){
		try{
			Location eqLoc = (Location) o;
			if(eqLoc.getX() == x){
				if(eqLoc.getY() == y){
					return true;
				}
			}
		}catch(Exception e){

		}
		return false;
	}

}


class FoodTruck extends Observable{
	private Location loc;
	private String name;

	public FoodTruck(String n, int x, int y){
		name = n;
		loc = new Location(x, y);
	}

	public FoodTruck(String n, Location l){
		name = n;
		loc = l;
	}

	public FoodTruck(String n){
		this(n, -1, -1);
	}

	@overload
	public void addObserver(Observer o){
		super.addObserver(o);
		o.update(this, null);
	}

	public Location getLocation(){
		return loc;
	}

	public String getName(){
		return name;
	}

	public void moveTruck(Location l){
		if(!l.equals(loc)){
		  this.setChanged();
		  loc = l;
		  this.notifyObservers();
		}

	}

	public void moveTruck(int x, int y){
		this.moveTruck(new Location(x,y));
	}


}

class FoodTruckTracker implements Observer{
  HashMap<String, Location> truckMap;

  public FoodTruckTracker(){
  	 truckMap = new HashMap<String, Location>();
  }

  public void update(Observable obs, Object o){
  	FoodTruck truck = (FoodTruck) obs;
  	truckMap.put(truck.getName(), truck.getLocation());
  }

  public String toString(){
  	String out = "";
  	for(String name:truckMap.keySet()){
  		out += name + ":\t" + truckMap.get(name) + "\n";
  	}
  	if(out.equals("")){out = "No Trucks Found.";}
  	return out;
  }

}

class FoodTruckCounter implements Observer{

  private int count;
  public FoodTruckCounter(){
  	count = 0;
  }

  public void update(Observable obs, Object o){
    FoodTruck truck = (FoodTruck) obs;


  }


}


public class FoodTruckObserver{

  public static void main(String []args){

  	FoodTruckTracker trakkr = new FoodTruckTracker();
  	FoodTruck brunchBox = new FoodTruck("Brunch Box");

  	System.out.println(trakkr);
    brunchBox.addObserver(trakkr);
    System.out.println(trakkr);
    brunchBox.moveTruck(2,4);
    System.out.println(trakkr);

  }
}

