package model;
import java.util.ArrayList;
import model.*;

public class Journey{ /** hacer un arraylist de las cargas */ /** para descargar el barco le hago el metodo clear*/

 private int totalWeight;
 private int totalValue;
 private ArrayList <Load> loads;
 
 /**
	*Name: Journey
	*it is the constructor method of the class, here the ArrayList of the loads is created, 
	*and the total value of the journey, as well as
	*the total weight, are initialized in zero.
	*/
  public Journey(){ 
     loads = new ArrayList <Load>();
	 totalWeight = 0;
	 totalValue = 0;
  } 
  /**
	*Name: calculateTotalWeight
	*calculates the total weight the ship is carrying in this current journey.
	*/
  public void calculateTotalWeight(){  
   
    for(int i = 0; i < loads.size(); i++){ 	  
		totalWeight += loads.get(i).getKgQuantity();		  
	}
  }
   /**
	*Name: getTotalWeight
	*returns the total weight calculated.
	*@return the total weight.
	*/
  public int getTotalWeight(){ 
    return totalWeight;
  }
  /**
	*Name: calculateTotalValue
	*calculates the total value the ship has in the current journey.
	*/
  public void calculateTotalValue(){
 
	   for(int i = 0; i < loads.size(); i++){  
	     totalValue += loads.get(i).getValueOfLoad();
	   }
  }
  /**
	*Name: getTotalValue
	*returns the total value.
	*@return the total value.
	*/
  public int getTotalValue(){ 
    return totalValue;
  }
  /**
	*Name: addLoad
	*adds a new load to the ship in the current journey. adds a load to
	*the ArrayList of loads.
	*@param boxes. the number of boxes of the load.
	*@param weightPerBox. the weight each box is going to have.
	*@param typeOfLoad. the type of the load.
	*@param client. the owner of the load.
	*/
  public void addLoad(int boxes, int weightPerBox, int typeOfLoad, Client client){	

    Load newLoad = new Load(boxes, weightPerBox, typeOfLoad, client);

    loads.add(newLoad);
  
  } 
  /**
	*Name: howManyLoads
	*returns the number of loads the ship has in the current journey, 
	*that is, the size of the ArrayList of loads.
	*@return the number of loads.
	*/
  public int howManyLoads(){
	  
    return loads.size();
  }
  /**
	*Name: journeyIsAllowed
	*returns if the journey is allowed having in mind the
	*conditions: if there is a perishable load and a hazardous
	*load in the same journey, the ship is not allowed to sail.
	*@return isAllowed. true if the journey is allowed, false if not.
	*/
  public boolean journeyIsAllowed(){ 
  
    boolean isAllowed = true;
	boolean hasPerishable = false;
	boolean hasHazardous = false;
  
    int[] types = new int[loads.size()];
	
	int j = 0;
  //hago un arreglo con los tipos
    for(int i = 0; i < loads.size(); i++){ 
	
	  types[j] = loads.get(i).getTypeOfLoad();
      j++;	  
	} 
	//busco si hay perecedera
	for(int i = 0; i < types.length; i++){ 
	
	  if(types[i] == 250000){ 
	    hasPerishable = true;
	  }
	}
	//busco si hay peligrosa
	for(int i = 0; i < types.length; i++){ 
	  
	  if(types[i] == 390000){ 
	    hasHazardous = true;
	  }
	}
	
	if(hasPerishable && hasHazardous){ 
	  isAllowed = false;
	} 
	
	return isAllowed;
  
  
  } 
  /**
	*Name: clearLoads
	*erases, clears the ArrayList of loads in the journey.
	*/
  public void clearLoads(){ 
    loads.clear();
  }
  /**
	*Name: clearLoads
	*returns the last load added, that is, the load in the last
	*position in the ArrayList.
	@return the last load added.
	*/
  public Load getLoad(){ 
  
  return loads.get(loads.size()-1);
  }
  /**
	*Name: restoreTotalValue
	*restores the total value of the journey, that is, puts the value 
	*again in zero.
	*/
  public void restoreTotalValue(){ 
    totalValue = 0;
  }
   /**
	*Name: restoreTotalWeight
	*restores the total weight of the journey, that is, puts the value 
	*again in zero.
	*/
  public void restoreTotalWeight(){ 
    totalWeight = 0;
  }
}