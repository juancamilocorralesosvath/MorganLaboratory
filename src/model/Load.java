package model; 
import model.*;

/** 
  *This class administrates the information of the load.
  @autor Juan Camilo Corrales Osvath
  */
 public class Load{ 
  
  private final static int PERISHABLE = 250000;      
  private final static int NON_PERISHABLE = 80000;  
  private final static int HAZARDOUS = 390000;
  private final static int NORMAL_DISC = 0;
  private final static int SILVER_DISC = 3/200;
  private final static int GOLD_DISC = 3/100;
  private final static int PLATINUM_DISC = 5/100;
  private int kgQuantity;
  private int weightPerBox;
  private int boxes;
  private int typeOfLoad;
  private Client client;
  private int valueOfLoad;
  
  
 /**
	*Name: Load
	*it is the constructor method of the class, here the values of the 
	*number of boxes, the weight of each box, the type of the load, and the 
	*owner of the load, are initialized.
	@param boxes. the number of boxes.
	@param weightPerBox. the weight of each box.
	@param typeOfLoad. the type of the load.
	@param client. the owner of the load.
	*/
  public Load(int boxes, int weightPerBox, int typeOfLoad, Client client){ 
    this.boxes = boxes;
	this.weightPerBox = weightPerBox;
	this.typeOfLoad = typeOfLoad;
    this.client = client;
  } 
  /**
	*Name: setTypeOfLoad
	*it stablishes the value per kg of the load
	*according by the information entered by the user.
	*/
  public void setTypeOfLoad(){ 
  
    if(typeOfLoad == 1){ 
	
	  typeOfLoad = PERISHABLE;
	  
	}else if(typeOfLoad == 2){ 
	
	  typeOfLoad = NON_PERISHABLE;
	  
	}else if(typeOfLoad == 3){ 
	
	  typeOfLoad = HAZARDOUS;
	  
	}
  
		
  }
  /**
	*Name: setTypeOfLoad
	*returns the type of load.
	*@return typeOfLoad. the type of load.
	*/
  public int getTypeOfLoad(){ 
    return typeOfLoad;
  }
  /**
	*Name: calculateKgQuantity
	*calculates how many kg has the entered load.
	*/
  public void calculateKgQuantity(){ 
  kgQuantity = weightPerBox * boxes;
  } 
   /**
	*Name: calculateKgQuantity
	*returns how many kg has the entered load.
	*@return kgQuantity. the number of kg the load has.
	*/
  public int getKgQuantity(){ 
  
    return kgQuantity;
  } 
  
  /**
	*Name: setWeightPerBox
	*setter method of the attribute weightPerBox.
	*/
  public void setWeightPerBox(int weightPerBox){ 
    this.weightPerBox = weightPerBox;
  } 
/**
	*Name: getWeightPerBox
	*returns the weight per box of the load.
	*@return weightPerBox. the weight each box has.
	*/
  public int getWeightPerBox(){ 
  
    return weightPerBox;
  
  } 
/**
	*Name: setBoxes
	*setter method of the attribute boxes.
	*/
 public void setBoxes(int boxes){ 
   this.boxes = boxes;
 } 
/**
	*Name: getBoxes
	*returns the number of boxes of the load.
	*@return boxes. the number of boxes.
	*/
public int getBoxes(){ 

  return boxes;
}  
/**
	*Name: calculateValueOfLoad
	*calculates the value that the client has to pay
	*for transportating the load.
	*/
   public void calculateValueOfLoad(){ 
   
        int clientType = client.getType();
		int disc = 0;  

        if (clientType == 2 && typeOfLoad == PERISHABLE) {
			
		    disc = (250000 * 3) / 200;
			valueOfLoad = (typeOfLoad - disc) * kgQuantity;
			
        } else if (clientType == 3 && (typeOfLoad == PERISHABLE || typeOfLoad == NON_PERISHABLE)) {
			
			if(typeOfLoad == PERISHABLE){ 
			  
			  disc = (250000 * 3) / 100;
			  valueOfLoad = (typeOfLoad - disc) * kgQuantity;
			  
			} else if(typeOfLoad == NON_PERISHABLE){ 
			  
			  disc = (80000 * 3) / 100;
			  valueOfLoad = (typeOfLoad - disc) * kgQuantity;
			} 

        } else if (clientType == 4) {
			
			if(typeOfLoad == PERISHABLE){ 
			  
			  disc = (250000 * 5) / 100;
			  valueOfLoad = (typeOfLoad - disc) * kgQuantity; 
			  
			}else if(typeOfLoad == NON_PERISHABLE){ 
			  
			  disc = (80000 * 5) / 100;
			  valueOfLoad = (typeOfLoad - disc) * kgQuantity;
			  
			}else if(typeOfLoad == HAZARDOUS){ 
			  
			  disc = (390000 * 5) / 100;
			  valueOfLoad = (typeOfLoad - disc) * kgQuantity;
			}

        } else {

            valueOfLoad = typeOfLoad * kgQuantity;

        }
   }   
 /**
	*Name: getValueOfLoad
	*returns the value of the load.
	*@return valueOfLoad. the value of the load.
	*/
	 public int getValueOfLoad(){ 
	   return valueOfLoad;
	 }
 /**
	*Name: weightClient
	*this method calls a client method, the purpose here is sending
	*the client the information of how many kg has his load, in order to calculate 
	*the total of kilograms transportated by the client.
	*/
	 public void weightClient(){ 
	 
	   client.calculateTotalWeight(kgQuantity);
	 }
/**
	*Name: weightClient
	*very simillar to the one above, this method calls a client method, the purpose here is sending
	*the client the information of the value of his load, in order to calculate 
	*the total value paid by the client.
	*/
	 public void valueClient(){ 
	   client.calculateTotalValue(valueOfLoad);
	 }
/**
	*Name: getClientId
	*returns the id of the owner.
	@return the id of the owner.
	*/
	 public int getClientId(){ 
	   return client.getId();
	 }
	
  }  